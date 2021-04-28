/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 28-04-21 15:26
 */
package cl.figonzal.evaluatool.evalua.evalua3.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMemoriaAtencionE3M1Binding
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class MemoriaAtencionE3M1 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 18.78
        private const val MEDIA = 84.36
    }

    private lateinit var binding: ActivityMemoriaAtencionE3M1Binding
    private val perc = listOf(
            125 to 99,
            122 to 97,
            119 to 95,
            116 to 93,
            113 to 90,
            110 to 87,
            107 to 85,
            104 to 80,
            101 to 75,
            98 to 70,
            95 to 67,
            92 to 62,
            89 to 60,
            86 to 55,
            83 to 50,
            80 to 45,
            77 to 42,
            74 to 40,
            71 to 35,
            68 to 30,
            65 to 25,
            62 to 20,
            59 to 17,
            56 to 15,
            53 to 12,
            50 to 10,
            47 to 7,
            44 to 5,
            41 to 3
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etOmitidasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var omitidasT1 = 0
    private var reprobadasT1 = 0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etOmitidasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private var aprobadasT2 = 0
    private var omitidasT2 = 0
    private var reprobadasT2 = 0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var etOmitidasT3: TextInputEditText
    private lateinit var etReprobadasT3: TextInputEditText
    private var aprobadasT3 = 0
    private var omitidasT3 = 0
    private var reprobadasT3 = 0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var etOmitidasT4: TextInputEditText
    private lateinit var etReprobadasT4: TextInputEditText
    private var aprobadasT4 = 0
    private var omitidasT4 = 0
    private var reprobadasT4 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private var subtotalPdT1 = 0.0
    private var subtotalPdT2 = 0.0
    private var subtotalPdT3 = 0.0
    private var subtotalPdT4 = 0.0

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoriaAtencionE3M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_MEMORIA_ATENCION, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@MemoriaAtencionE3M1.etAprobadasT1 = etAprobadasT1
            this@MemoriaAtencionE3M1.etOmitidasT1 = etOmitidasT1
            this@MemoriaAtencionE3M1.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@MemoriaAtencionE3M1.etAprobadasT2 = etAprobadasT2
            this@MemoriaAtencionE3M1.etOmitidasT2 = etOmitidasT2
            this@MemoriaAtencionE3M1.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@MemoriaAtencionE3M1.etAprobadasT3 = etAprobadasT3
            this@MemoriaAtencionE3M1.etOmitidasT3 = etOmitidasT3
            this@MemoriaAtencionE3M1.etReprobadasT3 = etReprobadasT3

            //TAREA 3
            tvSubTotalT4 = tvPdSubtotalT4
            this@MemoriaAtencionE3M1.etAprobadasT4 = etAprobadasT4
            this@MemoriaAtencionE3M1.etOmitidasT4 = etOmitidasT4
            this@MemoriaAtencionE3M1.etReprobadasT4 = etReprobadasT4

            //TOTAL
            this@MemoriaAtencionE3M1.tvPdTotal = tvPdTotalValue
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
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_MEMORIA_ATENCION))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
            textWatcherTarea3()
            textWatcherTarea4()
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
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT1) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
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
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, omitidasT1, reprobadasT1)
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
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
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
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
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
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, omitidasT2, reprobadasT2)
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
                        s.isNotEmpty() -> aprobadasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, omitidasT3, reprobadasT3)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT3 = 0
                        s.isNotEmpty() -> omitidasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, omitidasT3, reprobadasT3)
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
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, omitidasT3, reprobadasT3)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea4() {

        with(etAprobadasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT4 = 0
                        s.isNotEmpty() -> aprobadasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(null, tvSubTotalT4, context.getString(R.string.TAREA_4), aprobadasT4, omitidasT4, reprobadasT4)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT4 = 0
                        s.isNotEmpty() -> omitidasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(null, tvSubTotalT4, context.getString(R.string.TAREA_4), aprobadasT4, omitidasT4, reprobadasT4)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT4 = 0
                        s.isNotEmpty() -> reprobadasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(null, tvSubTotalT4, context.getString(R.string.TAREA_4), aprobadasT4, omitidasT4, reprobadasT4)
                    calculateResult()
                }
            })
        }
    }

    override fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total: Double
        total = aprobadas!! - (reprobadas!! + omitidas!!).toDouble()
        total = floor(total)
        if (total < 0) {
            total = 0.0
        }
        tv_sub_total.text = String.format(Locale.US, "%s%s pts", tarea, total)
        return total
    }

    override fun calcularResultado() {

        //TOTALES
        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4, {
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

    override fun calcularPercentil(pd_total: Double): Int {
        when {
            pd_total > perc[0][0] -> {
                return perc[0][1]
            }
            pd_total < perc[perc.size - 1][0] -> {
                return perc[perc.size - 1][1]
            }
            else -> {
                for (item in perc) {
                    if (pd_total.toInt() == item[0]) {
                        return item[1]
                    }
                }
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