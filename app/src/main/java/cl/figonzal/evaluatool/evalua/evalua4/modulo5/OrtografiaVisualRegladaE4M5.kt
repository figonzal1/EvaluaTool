/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 30-04-21 22:11
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo5

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityOrtografiaVisualRegladaE4M5Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class OrtografiaVisualRegladaE4M5 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 16.04
        private const val MEDIA = 40.62
    }

    private lateinit var binding: ActivityOrtografiaVisualRegladaE4M5Binding
    private val perc = listOf(

            80 to 99,
            79 to 99,
            78 to 99,

            77 to 98,
            76 to 98,
            75 to 98,

            74 to 97,
            73 to 97,
            72 to 97,

            71 to 96,
            70 to 96,
            69 to 96,

            68 to 94,
            67 to 94,
            66 to 94,

            65 to 92,
            64 to 92,
            63 to 92,

            62 to 90,
            61 to 90,
            60 to 90,

            59 to 85,
            58 to 85,
            57 to 85,

            56 to 80,
            55 to 80,
            54 to 80,

            53 to 75,
            52 to 75,
            51 to 75,

            50 to 70,
            49 to 70,
            48 to 70,

            47 to 60,
            46 to 60,
            45 to 60,

            44 to 55,
            43 to 55,
            42 to 55,

            41 to 50,
            40 to 50,
            39 to 50,

            38 to 40,
            37 to 40,
            36 to 40,

            35 to 35,
            34 to 35,
            33 to 35,

            32 to 30,
            31 to 30,
            30 to 30,

            29 to 25,
            28 to 25,
            27 to 25,

            26 to 20,
            25 to 20,
            24 to 20,

            23 to 17,
            22 to 17,
            21 to 17,

            20 to 15,
            19 to 15,
            18 to 15,

            17 to 10,
            16 to 10,
            15 to 10,

            14 to 5,
            13 to 5,
            12 to 5,

            11 to 1,
            10 to 1,
            9 to 1
    )

    //TAREA 1
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var reprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etOmitidasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var aprobadasT2 = 0
    private var omitidasT2 = 0
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
        binding = ActivityOrtografiaVisualRegladaE4M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_ORT_VIS_REGLADA, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {

            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@OrtografiaVisualRegladaE4M5.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@OrtografiaVisualRegladaE4M5.etAprobadasT2 = etAprobadasT2
            this@OrtografiaVisualRegladaE4M5.etOmitidasT2 = etOmitidasT2
            this@OrtografiaVisualRegladaE4M5.etReprobadasT2 = etReprobadasT2

            //TOTAL
            this@OrtografiaVisualRegladaE4M5.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)

                CorregidoDialogFragment().apply {
                    isCancelable = false
                    show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
                }

            }
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_ORT_VIS_REGLADA))
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
                    subtotalPdT2 = calculateTask(2, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT2 = 0
                        s.isNotEmpty() -> omitidasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(2, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
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
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(2, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        val total = floor(when (nTarea) {
            1 -> 20 - reprobadas!!.toDouble()
            2 -> aprobadas!! - (reprobadas!! + omitidas!!).toDouble()
            else -> 0.0
        })
        tvSubTotal.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2, {
            tvPdTotal.text = String.format(Locale.US, "%s pts", this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format("%s pts", pdCorregido)

            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(this, true)
                    else -> progressBar.progress = this
                }

                tvNivel.text = Utils.calcularNivel(this)
            })
        })
    }

    override fun calculatePercentile(pdTotal: Double): Int {
        when {
            pdTotal > perc[0].first -> return perc[0].second
            pdTotal < perc[perc.size - 1].first -> return perc[perc.size - 1].second
            else -> perc.forEach { item ->
                if (pdTotal.toInt() == item.first) return item.second
            }
        }
        //Percentil no encontrado
        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: List<Pair<Int, Int>>, pdActual: Double): Double {
        when {
            pdActual < 0 -> return 0.0
            pdActual > perc[0].first -> return perc[0].first.toDouble()
            pdActual < perc[perc.size - 1].first -> return perc[perc.size - 1].first.toDouble()
            else -> perc.forEach { item ->
                when (pdActual) {
                    item.first.toDouble() -> return item.first.toDouble()
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