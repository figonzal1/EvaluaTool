/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 02-05-21 18:12
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMemoriaAtencionE2M2Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class MemoriaAtencionE2M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 13.04
        private const val MEDIA = 59.35
    }

    private lateinit var binding: ActivityMemoriaAtencionE2M2Binding
    private val perc = listOf(
            88 to 99,
            87 to 99,
            86 to 99,
            85 to 99,
            84 to 99,
            83 to 99,
            82 to 99,
            81 to 99,
            80 to 95,
            79 to 95,
            78 to 95,
            77 to 95,
            76 to 95,
            75 to 85,
            74 to 85,
            73 to 85,
            72 to 85,
            71 to 85,
            70 to 75,
            69 to 75,
            68 to 75,
            67 to 75,
            66 to 75,
            65 to 65,
            64 to 65,
            63 to 65,
            62 to 65,
            61 to 65,
            60 to 50,
            59 to 50,
            58 to 50,
            57 to 50,
            56 to 50,
            55 to 45,
            54 to 45,
            53 to 45,
            52 to 45,
            51 to 45,
            50 to 35,
            49 to 35,
            48 to 35,
            47 to 35,
            46 to 35,
            45 to 30,
            44 to 30,
            43 to 30,
            42 to 30,
            41 to 30,
            40 to 20,
            39 to 20,
            38 to 20,
            37 to 20,
            36 to 20,
            35 to 15,
            34 to 15,
            33 to 15,
            32 to 15,
            31 to 15,
            30 to 10,
            29 to 10,
            27 to 10,
            26 to 10,
            25 to 7,
            24 to 7,
            23 to 7,
            22 to 7,
            21 to 7,
            20 to 5,
            19 to 5,
            18 to 5,
            17 to 5,
            16 to 5,
            15 to 3,
            14 to 3,
            13 to 3,
            12 to 3,
            11 to 3,
            10 to 1,
            9 to 1,
            8 to 1,
            7 to 1,
            6 to 1
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

    //TAREA 5
    private lateinit var etAprobadasT5: TextInputEditText
    private lateinit var etOmitidasT5: TextInputEditText
    private lateinit var etReprobadasT5: TextInputEditText
    private var aprobadasT5 = 0
    private var omitidasT5 = 0
    private var reprobadasT5 = 0

    //TAREA 6
    private lateinit var etAprobadasT6: TextInputEditText
    private lateinit var etOmitidasT6: TextInputEditText
    private lateinit var etReprobadasT6: TextInputEditText
    private var aprobadasT6 = 0
    private var omitidasT6 = 0
    private var reprobadasT6 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private lateinit var tvSubTotalT5: TextView
    private lateinit var tvSubTotalT6: TextView
    private var subtotalPdT1 = 0.0
    private var subtotalPdT2 = 0.0
    private var subtotalPdT3 = 0.0
    private var subtotalPdT4 = 0.0
    private var subtotalPdT5 = 0.0
    private var subtotalPdT6 = 0.0

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoriaAtencionE2M2Binding.inflate(layoutInflater)
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
            this@MemoriaAtencionE2M2.etAprobadasT1 = etAprobadasT1
            this@MemoriaAtencionE2M2.etOmitidasT1 = etOmitidasT1
            this@MemoriaAtencionE2M2.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@MemoriaAtencionE2M2.etAprobadasT2 = etAprobadasT2
            this@MemoriaAtencionE2M2.etOmitidasT2 = etOmitidasT2
            this@MemoriaAtencionE2M2.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@MemoriaAtencionE2M2.etAprobadasT3 = etAprobadasT3
            this@MemoriaAtencionE2M2.etOmitidasT3 = etOmitidasT3
            this@MemoriaAtencionE2M2.etReprobadasT3 = etReprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@MemoriaAtencionE2M2.etAprobadasT4 = etAprobadasT4
            this@MemoriaAtencionE2M2.etOmitidasT4 = etOmitidasT4
            this@MemoriaAtencionE2M2.etReprobadasT4 = etReprobadasT4

            //TAREA 5
            tvSubTotalT5 = tvPdSubtotalT5
            this@MemoriaAtencionE2M2.etAprobadasT5 = etAprobadasT5
            this@MemoriaAtencionE2M2.etOmitidasT5 = etOmitidasT5
            this@MemoriaAtencionE2M2.etReprobadasT5 = etReprobadasT5

            //TAREA 6
            tvSubTotalT6 = tvPdSubtotalT6
            this@MemoriaAtencionE2M2.etAprobadasT6 = etAprobadasT6
            this@MemoriaAtencionE2M2.etOmitidasT6 = etOmitidasT6
            this@MemoriaAtencionE2M2.etReprobadasT6 = etReprobadasT6

            //TOTAL
            this@MemoriaAtencionE2M2.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = perc[0].second

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)
            }
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_MEMORIA_ATENCION))
        }).run {
            textWatcherTarea1()
            textWatcherTarea2()
            textWatcherTarea3()
            textWatcherTarea4()
            textWatcherTarea5()
            textWatcherTarea6()
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
                        s.isNotEmpty() -> {
                            omitidasT3 = text.toString().toInt()
                        }
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

    private fun textWatcherTarea5() {

        with(etAprobadasT5) {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT5 = 0
                        s.isNotEmpty() -> aprobadasT5 = text.toString().toInt()
                    }
                    subtotalPdT5 = calculateTask(null, tvSubTotalT5, context.getString(R.string.TAREA_5), aprobadasT5, omitidasT5, reprobadasT5)
                    calculateResult()
                }
            })
        }

        with(etOmitidasT5) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT5 = 0
                        s.isNotEmpty() -> omitidasT5 = text.toString().toInt()
                    }
                    subtotalPdT5 = calculateTask(null, tvSubTotalT5, context.getString(R.string.TAREA_5), aprobadasT5, omitidasT5, reprobadasT5)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT5) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT5 = 0
                        s.isNotEmpty() -> reprobadasT5 = text.toString().toInt()
                    }
                    subtotalPdT5 = calculateTask(null, tvSubTotalT5, context.getString(R.string.TAREA_5), aprobadasT5, omitidasT5, reprobadasT5)
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea6() {

        with(etAprobadasT6) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT6 = 0
                        s.isNotEmpty() -> aprobadasT6 = text.toString().toInt()
                    }
                    subtotalPdT6 = calculateTask(null, tvSubTotalT6, context.getString(R.string.TAREA_6), aprobadasT6, omitidasT6, reprobadasT6)
                    calculateResult()
                }
            })
        }
        with(etOmitidasT6) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT6 = 0
                        s.isNotEmpty() -> omitidasT6 = text.toString().toInt()
                    }
                    subtotalPdT6 = calculateTask(null, tvSubTotalT6, context.getString(R.string.TAREA_6), aprobadasT6, omitidasT6, reprobadasT6)
                    calculateResult()
                }
            })
        }

        with(etReprobadasT6) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    subtotalPdT6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT6 = 0
                        s.isNotEmpty() -> reprobadasT6 = text.toString().toInt()
                    }
                    subtotalPdT6 = calculateTask(null, tvSubTotalT6, context.getString(R.string.TAREA_6), aprobadasT6, omitidasT6, reprobadasT6)
                    calculateResult()
                }
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {
        var total = floor(aprobadas!! - (reprobadas!! + omitidas!!).toDouble())
        if (total < 0) {
            total = 0.0
        }
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4 + subtotalPdT5 + subtotalPdT6, {
            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

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
}