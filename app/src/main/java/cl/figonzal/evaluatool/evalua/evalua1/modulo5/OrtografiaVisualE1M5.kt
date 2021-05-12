/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12-05-21 12:02
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo5

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.ortografiaVisualE1M5Baremo
import cl.figonzal.evaluatool.databinding.ActivityOrtografiaVisualE1M5Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class OrtografiaVisualE1M5 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 7.57
        private const val MEDIA = 14.59
    }

    private lateinit var binding: ActivityOrtografiaVisualE1M5Binding

    //PD,PC CHILE
    private val perc = ortografiaVisualE1M5Baremo()

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var aprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrtografiaVisualE1M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_ORTOGRAFIA_VISUAL, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@OrtografiaVisualE1M5.etAprobadasT1 = etAprobadasT1

            //TOTAL
            this@OrtografiaVisualE1M5.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0][1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)
            }
            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_ORTOGRAFIA_VISUAL)
            )
        }).also {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        null,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        null,
                        null
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(
        nTarea: Int?,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int?,
        omitidas: Int?,
        reprobadas: Int?
    ): Double {
        var total = floor(aprobadas!!.toDouble())
        if (total < 0) total = 0.0

        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1, {
            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this.toInt())
            tvPdCorregido.text =
                String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            //Calculate desviation
            tvDesviacionCalculada.text =
                Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            //Calculate percentile
            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(
                        this,
                        true
                    )
                    else -> progressBar.progress = this
                }
                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    override fun calculatePercentile(pdTotal: Int): Int {

        //Limite superior
        when {
            pdTotal > perc[0][0] as Int -> return perc[0][1] as Int
            pdTotal < perc[perc.size - 1][0] as Int -> return perc[perc.size - 1][1] as Int
            else -> perc.forEach { item ->
                if (pdTotal == item[0]) return item[1] as Int
            }
        }
        //Percentil no encontrado
        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {

        when {
            pdActual < 0 -> return 0
            pdActual > perc[0][0] as Int -> return perc[0][0] as Int
            pdActual < perc[perc.size - 1][0] as Int -> return perc[perc.size - 1][0] as Int
            else -> perc.forEach { item ->
                when {
                    pdActual == item[0] -> return item[0] as Int
                    pdActual - 1 == item[0] -> return item[0] as Int
                    pdActual - 2 == item[0] -> return item[0] as Int
                }
            }
        }
        logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return -1
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}