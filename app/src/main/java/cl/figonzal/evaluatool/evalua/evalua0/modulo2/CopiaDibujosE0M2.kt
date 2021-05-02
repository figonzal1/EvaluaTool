/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 02-05-21 12:36
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityCopiaDibujosE0M2Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class CopiaDibujosE0M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 12.65
        private const val MEDIA = 42.22
    }

    private lateinit var binding: ActivityCopiaDibujosE0M2Binding
    private val perc = listOf(
            65 to 99,
            64 to 99,
            63 to 97,
            62 to 97,
            61 to 95,
            60 to 95,
            59 to 90,
            58 to 90,
            57 to 90,
            56 to 85,
            55 to 85,
            54 to 85,
            53 to 75,
            52 to 75,
            51 to 75,
            50 to 70,
            49 to 70,
            48 to 70,
            47 to 65,
            46 to 65,
            45 to 65,
            44 to 55,
            43 to 55,
            42 to 55,
            41 to 50,
            40 to 50,
            39 to 50,
            38 to 40,
            37 to 40,
            36 to 40,
            35 to 30,
            34 to 30,
            33 to 30,
            32 to 20,
            31 to 20,
            30 to 20,
            29 to 15,
            28 to 15,
            27 to 15,
            26 to 12,
            25 to 12,
            24 to 12,
            23 to 10,
            22 to 10,
            21 to 10,
            20 to 9,
            19 to 9,
            18 to 9,
            17 to 6,
            16 to 6,
            15 to 6,
            14 to 3,
            13 to 3,
            12 to 3,
            11 to 3,
            10 to 1,
            9 to 1,
            8 to 1,
            7 to 1,
            6 to 1,
            5 to 1,
            4 to 1,
            3 to 1,
            2 to 1,
            1 to 1
    )

    //TAREA 1
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etReprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var reprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCopiaDibujosE0M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_COPIA_DIBUJOS, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@CopiaDibujosE0M2.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@CopiaDibujosE0M2.etReprobadasT2 = etReprobadasT2

            //TOTAL
            this@CopiaDibujosE0M2.tvPdTotal = tvPdTotalValue
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
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_COPIA_DIBUJOS))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
        }
    }

    private fun textWatcherTarea1() {

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
                    subtotalPdT1 = calculateTask(1, tvSubTotalT1, context.getString(R.string.TAREA_1), null, null, reprobadasT1)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2() {

        with(etReprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(2, tvSubTotalT2, context.getString(R.string.TAREA_2), null, null, reprobadasT2)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {

        val total = floor(when (nTarea) {
            1 -> 17 - reprobadas!!.toDouble()
            2 -> 48 - reprobadas!!.toDouble()
            else -> 0.0
        })
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2, {

            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            //Correct total pd based on Baremo Table
            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            //calculate desviation
            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            //Calculate percentile
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
                if (pdTotal == item.first.toDouble()) return item.second
            }
        }
        //Percentil no encontrado
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
                if (pdActual == item.first.toDouble()) return item.first.toDouble()
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