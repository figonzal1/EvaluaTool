/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12-05-21 01:13
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.comprensionLectoraE5M4Baremo
import cl.figonzal.evaluatool.databinding.ActivityComprensionLectoraE5M4Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.floor

class ComprensionLectoraE5M4 : AppCompatActivity(), EvaluaInterface {

    companion object {
        private const val DESVIACION = 7.14
        private const val MEDIA = 18.65
    }

    private lateinit var binding: ActivityComprensionLectoraE5M4Binding
    private val perc = comprensionLectoraE5M4Baremo()

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
        binding = ActivityComprensionLectoraE5M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_COMPREN_LECTORA, binding.include.toolbar)

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
            this@ComprensionLectoraE5M4.etAprobadasT1 = etAprobadasT1
            this@ComprensionLectoraE5M4.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@ComprensionLectoraE5M4.etAprobadasT2 = etAprobadasT2
            this@ComprensionLectoraE5M4.etReprobadasT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@ComprensionLectoraE5M4.etAprobadasT3 = etAprobadasT3
            this@ComprensionLectoraE5M4.etReprobadasT3 = etReprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@ComprensionLectoraE5M4.etAprobadasT4 = etAprobadasT4
            this@ComprensionLectoraE5M4.etReprobadasT4 = etReprobadasT4

            //TOTAL
            this@ComprensionLectoraE5M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = perc[0][1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                showHelperDialog(supportFragmentManager)

            }
            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                perc,
                getString(R.string.TOOLBAR_COMPREN_LECTORA)
            )
        }).also {
            textWatcherTarea1()
            textWatcherTarea2()
            textWatcherTarea3()
            textWatcherTarea4()
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
                        null,
                        tvSubTotalT1,
                        context.getString(R.string.TAREA_1),
                        aprobadasT1,
                        null,
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
                        null,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        aprobadasT2,
                        null,
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
                        null,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        aprobadasT2,
                        null,
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
                        null,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        aprobadasT3,
                        null,
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
                        null,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        aprobadasT3,
                        null,
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
                        null,
                        tvSubTotalT4,
                        context.getString(R.string.TAREA_4),
                        aprobadasT4,
                        null,
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
                        null,
                        tvSubTotalT4,
                        context.getString(R.string.TAREA_4),
                        aprobadasT4,
                        null,
                        reprobadasT4
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
        var total = floor(aprobadas!! - (reprobadas!! / 3.0))
        if (total < 0) {
            total = 0.0
        }
        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        //TOTALES
        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3 + subtotalPdT4, {
            tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), this)

            val pdCorregido = correctPD(perc, this.toInt())
            tvPdCorregido.text =
                String.format(getString(R.string.POINTS_SIMPLE_FORMAT), pdCorregido)

            tvDesviacionCalculada.text =
                Utils.calcularDesviacion(MEDIA, DESVIACION, pdCorregido, false).toString()

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