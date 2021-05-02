/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 02-05-21 12:36
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivitySeriesE0M1Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class SeriesE0M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 9.68
        private const val MEDIA = 37.7
    }

    private lateinit var binding: ActivitySeriesE0M1Binding

    //PD,PC CHILE
    private val perc = listOf(
            48 to 95,
            47 to 90,
            46 to 85,
            44 to 80,
            42 to 70,
            40 to 60,
            38 to 50,
            36 to 45,
            34 to 35,
            32 to 30,
            30 to 25,
            28 to 20,
            26 to 15,
            24 to 12,
            22 to 10,
            20 to 9,
            18 to 7,
            16 to 5,
            14 to 3,
            10 to 1
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var aprobadasT1 = 0
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var aprobadasT2 = 0
    private var reprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var etReprobadasT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var aprobadasT3 = 0
    private var reprobadasT3 = 0
    private var subtotalPdT3 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeriesE0M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_SERIES, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@SeriesE0M1.etAprobadasT1 = etAprobadasT1
            this@SeriesE0M1.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@SeriesE0M1.etAprobadasT2 = etAprobadasT2
            this@SeriesE0M1.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@SeriesE0M1.etAprobadasT3 = etAprobadasT3
            this@SeriesE0M1.etReprobadasT3 = etReprobadasT3

            //TOTAL
            this@SeriesE0M1.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)
            }
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_SERIES))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
            textWatcherTarea3()
        }
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, null, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, null, reprobadasT1)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2() {

        with(etAprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT2 = 0
                        s.isNotEmpty() -> aprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, null, reprobadasT2)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = Objects.requireNonNull(text).toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, null, reprobadasT2)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3() {

        with(etAprobadasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT3 = 0
                        s.isNotEmpty() -> aprobadasT3 = Objects.requireNonNull(text).toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, null, reprobadasT3)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT3 = 0
                        s.isNotEmpty() -> reprobadasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, null, reprobadasT3)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {

        var total = floor(aprobadas!! - (reprobadas!! / 3.0))

        when {
            total < 0 -> total = 0.0
        }
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3, {

            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            //Correct total pd based on Baremo Table
            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            //Calculate desviation
            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            //Calculate desviation
            with(calculatePercentile(pdCorregido), {

                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(this, true)
                    else -> progressBar.progress = this
                }

                //Calculate student level
                tvNivel.text = Utils.calcularNivel(this)
            })
        })

    }

    override fun calculatePercentile(pdTotal: Double): Int {

        //Limite superior
        when {
            pdTotal > perc[0].first -> return perc[0].second
            pdTotal < perc[perc.size - 1].first -> return perc[perc.size - 1].second
            else -> perc.forEach { item ->
                if (pdTotal.toInt() == item.first) return item.second
            }
        }

        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: List<Pair<Int, Int>>, pdActual: Double): Double {
        //Verificar si pd_actual esta en la lista
        when {
            pdActual < 0 -> return 0.0
            pdActual > perc[0].first -> return perc[0].first.toDouble()
            pdActual < perc[perc.size - 1].first -> return perc[perc.size - 1].first.toDouble()
            else -> perc.forEach { item ->
                when {
                    pdActual == item.first.toDouble() -> return item.first.toDouble()
                    pdActual - 1 == item.first.toDouble() -> return item.first.toDouble()
                    pdActual - 2 == item.first.toDouble() -> return item.first.toDouble()
                    pdActual - 3 == item.first.toDouble() -> return item.first.toDouble()
                }
            }
        }

        logInfo(R.string.TAG_PD_CORREGIDO, R.string.PD_NULO)
        return (-1).toDouble()
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