/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 02-05-21 12:36
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo3

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityHabilidadesFonologicasE0M3Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class HabilidadesFonologicasE0M3 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 10.07
        private const val MEDIA = 44.73
    }

    private lateinit var binding: ActivityHabilidadesFonologicasE0M3Binding

    //PD,PC CHILE
    private val perc = listOf(
            62 to 99,
            61 to 99,
            60 to 99,
            59 to 95,
            58 to 95,
            57 to 95,
            56 to 90,
            55 to 90,
            54 to 80,
            53 to 80,
            52 to 70,
            51 to 70,
            50 to 65,
            49 to 65,
            48 to 60,
            47 to 60,
            46 to 55,
            45 to 55,
            44 to 50,
            43 to 50,
            42 to 40,
            41 to 40,
            40 to 30,
            39 to 30,
            38 to 20,
            37 to 20,
            36 to 20,
            35 to 15,
            34 to 15,
            33 to 10,
            32 to 10,
            31 to 10,
            30 to 7,
            29 to 7,
            28 to 7,
            27 to 7,
            26 to 7,
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
            6 to 1,
            5 to 1
    )

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var aprobadasT1 = 0
    private var subtotalPdT1 = 0.0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var aprobadasT2 = 0
    private var subtotalPdT2 = 0.0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var aprobadasT3 = 0
    private var subtotalPdT3 = 0.0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var tvSubTotalT4: TextView
    private var aprobadasT4 = 0
    private var subtotalPdT4 = 0.0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHabilidadesFonologicasE0M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_HABILIDADES_FONOLOGICAS, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@HabilidadesFonologicasE0M3.etAprobadasT1 = etAprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@HabilidadesFonologicasE0M3.etAprobadasT2 = etAprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@HabilidadesFonologicasE0M3.etAprobadasT3 = etAprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@HabilidadesFonologicasE0M3.etAprobadasT4 = etAprobadasT4

            //TOTAL
            this@HabilidadesFonologicasE0M3.tvPdTotal = tvPdTotalValue
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
            Utils.configurarTextoBaremo(supportFragmentManager, tablaBaremo.tvBaremo, perc, getString(R.string.TOOLBAR_HABILIDADES_FONOLOGICAS))
        }).apply {
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
                    subtotalPdT1 = calculateTask(null, tvSubTotalT1, context.getString(R.string.TAREA_1), aprobadasT1, null, null)
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
                    subtotalPdT2 = calculateTask(null, tvSubTotalT2, context.getString(R.string.TAREA_2), aprobadasT2, null, null)
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
                    subtotalPdT3 = calculateTask(null, tvSubTotalT3, context.getString(R.string.TAREA_3), aprobadasT3, null, null)
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
                    subtotalPdT4 = calculateTask(null, tvSubTotalT4, context.getString(R.string.TAREA_4), aprobadasT4, null, null)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(nTarea: Int?, tvSubTotal: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double {

        var total = floor(aprobadas!!.toDouble())

        when {
            total < 0 -> total = 0.0
        }
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4, {

            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this)
            tvPdCorregido.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            //Calculate desviation
            tvDesviacionCalculada.text = Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

            //Calculate percentile
            with(calculatePercentile(pdCorregido), {
                tvPercentil.text = this.toString()

                when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgress(this, true)
                    else -> progressBar.progress = this
                }

                //Calculate level student
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