/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 16:59
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.seriesE1M2Baremo
import cl.figonzal.evaluatool.databinding.ActivitySeriesE1M2Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class SeriesE1M2 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 8.00
        private const val MEDIA = 14.50
    }

    private lateinit var binding: ActivitySeriesE1M2Binding
    private val perc = seriesE1M2Baremo()

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var reprobadasT1 = 0

    //TAREA 2
    private lateinit var etAprobadasT2: TextInputEditText
    private lateinit var etReprobadasT2: TextInputEditText
    private var aprobadasT2 = 0
    private var reprobadasT2 = 0

    //TAREA 3
    private lateinit var etAprobadasT3: TextInputEditText
    private lateinit var etReprobadasT3: TextInputEditText
    private var aprobadasT3 = 0
    private var reprobadasT3 = 0

    //TAREA 4
    private lateinit var etAprobadasT4: TextInputEditText
    private lateinit var etReprobadasT4: TextInputEditText
    private var aprobadasT4 = 0
    private var reprobadasT4 = 0

    //TAREA 5
    private lateinit var etAprobadasT5: TextInputEditText
    private lateinit var etReprobadasT5: TextInputEditText
    private var aprobadasT5 = 0
    private var reprobadasT5 = 0

    //TAREA 6
    private lateinit var etAprobadasT6: TextInputEditText
    private lateinit var etReprobadasT6: TextInputEditText
    private var aprobadasT6 = 0
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

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeriesE1M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_SERIES, binding.include.materialToolbar)

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
            this@SeriesE1M2.etAprobadasT1 = etAprobadasT1
            this@SeriesE1M2.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@SeriesE1M2.etAprobadasT2 = etAprobadasT2
            this@SeriesE1M2.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@SeriesE1M2.etAprobadasT3 = etAprobadasT3
            this@SeriesE1M2.etReprobadasT3 = etReprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@SeriesE1M2.etAprobadasT4 = etAprobadasT4
            this@SeriesE1M2.etReprobadasT4 = etReprobadasT4

            //TAREA 5
            tvSubTotalT5 = tvPdSubtotalT5
            this@SeriesE1M2.etAprobadasT5 = etAprobadasT5
            this@SeriesE1M2.etReprobadasT5 = etReprobadasT5

            //TAREA 6
            tvSubTotalT6 = tvPdSubtotalT6
            this@SeriesE1M2.etAprobadasT6 = etAprobadasT6
            this@SeriesE1M2.etReprobadasT6 = etReprobadasT6

            //TOTAL
            this@SeriesE1M2.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = perc.first()[1] as Int

            binding.cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)
            }
            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_SERIES)
            )
        }).also {
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
                        0,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        0,
                        reprobadasT1
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT1) {
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
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    subtotalPdT1 = calculateTask(
                        0,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        0,
                        reprobadasT1
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2() {

        with(etAprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT2 = 0
                        s.isNotEmpty() -> aprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(
                        0,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        aprobadasT2,
                        0,
                        reprobadasT2
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT2) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    subtotalPdT2 = calculateTask(
                        0,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        aprobadasT2,
                        0,
                        reprobadasT2
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3() {

        with(etAprobadasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT3 = 0
                        s.isNotEmpty() -> aprobadasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(
                        0,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        aprobadasT3,
                        0,
                        reprobadasT3
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT3) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT3 = 0
                        s.isNotEmpty() -> reprobadasT3 = text.toString().toInt()
                    }
                    subtotalPdT3 = calculateTask(
                        0,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        aprobadasT3,
                        0,
                        reprobadasT3
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea4() {

        with(etAprobadasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT4 = 0
                        s.isNotEmpty() -> aprobadasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(
                        0,
                        tvSubTotalT4,
                        context.getString(R.string.TAREA_4),
                        aprobadasT4,
                        0,
                        reprobadasT4
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT4) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT4 = 0
                        s.isNotEmpty() -> reprobadasT4 = text.toString().toInt()
                    }
                    subtotalPdT4 = calculateTask(
                        0,
                        tvSubTotalT4,
                        context.getString(R.string.TAREA_4),
                        aprobadasT4,
                        0,
                        reprobadasT4
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea5() {

        with(etAprobadasT5) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT5 = 0
                        s.isNotEmpty() -> aprobadasT5 = text.toString().toInt()
                    }
                    subtotalPdT5 = calculateTask(
                        0,
                        tvSubTotalT5,
                        context.getString(R.string.TAREA_5),
                        aprobadasT5,
                        0,
                        reprobadasT5
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT5) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT5 = 0
                        s.isNotEmpty() -> reprobadasT5 = text.toString().toInt()
                    }
                    subtotalPdT5 = calculateTask(
                        0,
                        tvSubTotalT5,
                        context.getString(R.string.TAREA_5),
                        aprobadasT5,
                        0,
                        reprobadasT5
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea6() {

        with(etAprobadasT6) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT6 = 0
                        s.isNotEmpty() -> aprobadasT6 = text.toString().toInt()
                    }
                    subtotalPdT6 = calculateTask(
                        0,
                        tvSubTotalT6,
                        context.getString(R.string.TAREA_6),
                        aprobadasT6,
                        0,
                        reprobadasT6
                    )
                    calculateResult()
                }
            })
        }

        with(etReprobadasT6) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subtotalPdT6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT6 = 0
                        s.isNotEmpty() -> reprobadasT6 = text.toString().toInt()
                    }
                    subtotalPdT6 = calculateTask(
                        0,
                        tvSubTotalT6,
                        context.getString(R.string.TAREA_6),
                        aprobadasT6,
                        0,
                        reprobadasT6
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateTask(
        nTarea: Int,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor((aprobadas - reprobadas).toDouble())
        if (total < 0) total = 0.0

        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        with(
            subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4 + subtotalPdT5 + subtotalPdT6,
            {

                tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

                val pdCorregido = correctPD(perc, this.toInt())
                tvPdCorregido.text =
                    String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

                //Calculate Desviation
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
        when {
            pdTotal > perc.first()[0] as Int -> return perc.first()[1] as Int
            pdTotal < perc.last()[0] as Int -> return perc.last()[1] as Int
            else -> perc.forEach { item ->
                if (pdTotal == item.first()) return item[1] as Int
            }
        }
        //Percentil no encontrado
        logInfo(R.string.TAG_PERCENTIL_CALCULADO, R.string.PERCENTIL_NULO)
        return -1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {

        when {
            pdActual < 0 -> return 0
            pdActual > perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual < perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                if (pdActual == item.first()) return item.first() as Int
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