/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-04-21 16:12
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityAtencionConcentracionE7M1Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class AtencionConcentracionE7M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 28.04
        private const val MEDIA = 115.68
    }

    private lateinit var binding: ActivityAtencionConcentracionE7M1Binding
    private val perc = listOf(
            191 to 99,
            190 to 99,
            189 to 99,
            188 to 99,
            187 to 99,
            186 to 99,
            185 to 99,

            184 to 95,
            183 to 95,
            182 to 95,
            181 to 95,
            180 to 95,

            179 to 90,
            178 to 90,
            177 to 90,
            176 to 90,
            175 to 90,

            174 to 87,
            173 to 87,
            172 to 87,
            171 to 87,
            170 to 87,

            169 to 85,
            168 to 85,
            167 to 85,
            166 to 85,
            165 to 85,

            164 to 80,
            163 to 80,
            162 to 80,
            161 to 80,
            160 to 80,

            159 to 78,
            158 to 78,
            157 to 78,
            156 to 78,
            155 to 78,

            154 to 75,
            153 to 75,
            152 to 75,
            151 to 75,
            150 to 75,

            149 to 72,
            148 to 72,
            147 to 72,
            146 to 72,
            145 to 72,

            144 to 70,
            143 to 70,
            142 to 70,
            141 to 70,
            140 to 70,

            139 to 65,
            138 to 65,
            137 to 65,
            136 to 65,
            135 to 65,

            134 to 63,
            133 to 63,
            132 to 63,
            131 to 63,
            130 to 63,

            129 to 60,
            128 to 60,
            127 to 60,
            126 to 60,
            125 to 60,

            124 to 55,
            123 to 55,
            122 to 55,
            121 to 55,
            120 to 55,

            119 to 50,
            118 to 50,
            117 to 50,
            116 to 50,
            115 to 50,

            114 to 45,
            113 to 45,
            112 to 45,
            111 to 45,
            110 to 45,

            109 to 40,
            108 to 40,
            107 to 40,
            106 to 40,
            105 to 40,

            104 to 35,
            103 to 35,
            102 to 35,
            101 to 35,
            100 to 35,

            99 to 30,
            98 to 30,
            97 to 30,
            96 to 30,
            95 to 30,

            94 to 25,
            93 to 25,
            92 to 25,
            91 to 25,
            90 to 25,

            89 to 18,
            88 to 18,
            87 to 18,
            86 to 18,
            85 to 18,

            84 to 15,
            83 to 15,
            82 to 15,
            81 to 15,
            80 to 15,

            79 to 12,
            78 to 12,
            77 to 12,
            76 to 12,
            75 to 12,

            74 to 10,
            73 to 10,
            72 to 10,
            71 to 10,
            70 to 10,

            69 to 9,
            68 to 9,
            67 to 9,
            66 to 9,
            65 to 9,

            64 to 7,
            63 to 7,
            62 to 7,
            61 to 7,
            60 to 7,

            59 to 5,
            58 to 5,
            57 to 5,
            56 to 5,
            55 to 5,

            54 to 3,
            53 to 3,
            52 to 3,
            51 to 3,
            50 to 3,

            49 to 1,
            48 to 1,
            47 to 1,
            46 to 1,
            45 to 1
    )

    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etOmitidasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView

    //Parciales Tarea 1
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0

    //Parciales para Tarea 2
    private var aprobadasT2 = 0
    private var omitidasT2 = 0
    private var reprobadasT2 = 0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDesviacionCalculada: TextView

    private var totalPdTarea1 = 0.0
    private var totalPdTarea2 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtencionConcentracionE7M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_ATENCION_CONCENTRACION, binding.include.toolbar)

        initResources()
    }

    private fun textWatcherTarea1() {

        with(etAprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    totalPdTarea1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    totalPdTarea1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    totalPdTarea1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2() {

        with(etAprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT2 = 0
                        s.isNotEmpty() -> aprobadasT2 = text.toString().toInt()
                    }
                    totalPdTarea2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT2 = 0
                        s.isNotEmpty() -> omitidasT2 = text.toString().toInt()
                    }
                    totalPdTarea2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
                    calculateResult()
                }
            })
        }
        with(etReprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    totalPdTarea2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
                    calculateResult()
                }
            })
        }
    }

    private fun initResources() {

        with(binding, {


            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AtencionConcentracionE7M1.etAprobadasT1 = etAprobadasT1
            this@AtencionConcentracionE7M1.etOmitidasT1 = etOmitidasT1
            this@AtencionConcentracionE7M1.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@AtencionConcentracionE7M1.etAprobadasT2 = etAprobadasT2
            this@AtencionConcentracionE7M1.etOmitidasT2 = etOmitidasT2
            this@AtencionConcentracionE7M1.etReprobadasT2 = etReprobadasT2

            //TOTAL
            this@AtencionConcentracionE7M1.tvPdTotal = tvPdTotalValue
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
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_ATENCION_CONCENTRACION))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
        }

    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = aprobadas!! - (omitidas!! + reprobadas!!)
        if (total < 0) {
            total = 0
        }
        tvSubTotal.text = String.format(Locale.US, "%s%d pts", tarea, total)
        return total.toDouble()
    }

    override fun calculateResult() {

        with(totalPdTarea1 + totalPdTarea2, {

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
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}