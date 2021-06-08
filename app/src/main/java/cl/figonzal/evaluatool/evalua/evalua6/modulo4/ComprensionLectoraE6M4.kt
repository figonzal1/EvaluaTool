/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 16:58
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.baremosTables.comprensionLectoraE6M4Baremo
import cl.figonzal.evaluatool.databinding.ActivityComprensionLectoraE6M4Binding
import cl.figonzal.evaluatool.interfaces.EvaluaInterface
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.floor

class ComprensionLectoraE6M4 : AppCompatActivity(), EvaluaInterface {
    companion object {
        private const val DESVIACION = 5.21
        private const val MEDIA = 13.10
    }


    private lateinit var binding: ActivityComprensionLectoraE6M4Binding
    private val perc = comprensionLectoraE6M4Baremo()

    //TAREA 1
    private lateinit var etAprobadasT1: TextInputEditText
    private lateinit var etReprobadasT1: TextInputEditText
    private var aprobadasT1 = 0
    private var reprobadasT1 = 0

    //TAREA 2
    private lateinit var etAprobadasT21: TextInputEditText
    private lateinit var etReprobadasT21: TextInputEditText
    private lateinit var etAprobadasT22: TextInputEditText
    private lateinit var etReprobadasT22: TextInputEditText
    private var aprobadasT21 = 0
    private var reprobadasT21 = 0
    private var aprobadasT22 = 0
    private var reprobadasT22 = 0

    //TAREA 3
    private lateinit var etAprobadasT31: TextInputEditText
    private lateinit var etReprobadasT31: TextInputEditText
    private lateinit var etAprobadasT32: TextInputEditText
    private lateinit var etReprobadasT32: TextInputEditText
    private var aprobadasT31 = 0
    private var reprobadasT31 = 0
    private var aprobadasT32 = 0
    private var reprobadasT32 = 0


    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private var subtotalPdT1 = 0.0
    private var subtotalPdT2 = 0.0
    private var subTotalPdT21 = 0.0
    private var subTotalPdT22 = 0.0
    private var subtotalPdT3 = 0.0
    private var subTotalPdT31 = 0.0
    private var subTotalPdT32 = 0.0

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprensionLectoraE6M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_COMPREN_LECTORA, binding.include.materialToolbar)

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
            this@ComprensionLectoraE6M4.etAprobadasT1 = etAprobadasT1
            this@ComprensionLectoraE6M4.etReprobadasT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@ComprensionLectoraE6M4.etAprobadasT21 = etAprobadasT21
            this@ComprensionLectoraE6M4.etReprobadasT21 = etReprobadasT21
            this@ComprensionLectoraE6M4.etAprobadasT22 = etAprobadasT22
            this@ComprensionLectoraE6M4.etReprobadasT22 = etReprobadasT22

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@ComprensionLectoraE6M4.etAprobadasT31 = etAprobadasT31
            this@ComprensionLectoraE6M4.etReprobadasT31 = etReprobadasT31
            this@ComprensionLectoraE6M4.etAprobadasT32 = etAprobadasT32
            this@ComprensionLectoraE6M4.etReprobadasT32 = etReprobadasT32

            //TOTAL
            this@ComprensionLectoraE6M4.tvPdTotal = tvPdTotalValue
            tvPdCorregido = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentil = cardViewFinal.tvPercentilValue
            tvNivel = cardViewFinal.tvNivelObtenidoValue
            tvDesviacionCalculada = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = perc.first()[1] as Int

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
                        1,
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
                        1,
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

        with(etAprobadasT21) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT21 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT21 = 0
                        s.isNotEmpty() -> aprobadasT21 = text.toString().toInt()
                    }

                    subTotalPdT21 = calcularSubTarea(21, aprobadasT21, reprobadasT21)

                    subtotalPdT2 = calculateTask(
                        2,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
        with(etReprobadasT21) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT21 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT21 = 0
                        s.isNotEmpty() -> reprobadasT21 = text.toString().toInt()
                    }
                    subTotalPdT21 = calcularSubTarea(21, aprobadasT21, reprobadasT21)

                    subtotalPdT2 = calculateTask(
                        2,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }

        with(etAprobadasT22) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT22 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT22 = 0
                        s.isNotEmpty() -> aprobadasT22 = text.toString().toInt()
                    }

                    subTotalPdT22 = calcularSubTarea(22, aprobadasT22, reprobadasT22)

                    subtotalPdT2 = calculateTask(
                        2,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
        with(etReprobadasT22) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT22 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT22 = 0
                        s.isNotEmpty() -> reprobadasT22 = text.toString().toInt()
                    }
                    subTotalPdT22 = calcularSubTarea(22, aprobadasT22, reprobadasT22)

                    subtotalPdT2 = calculateTask(
                        2,
                        tvSubTotalT2,
                        context.getString(R.string.TAREA_2),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3() {

        with(etAprobadasT31) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT31 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT31 = 0
                        s.isNotEmpty() -> aprobadasT31 = text.toString().toInt()
                    }

                    subTotalPdT31 = calcularSubTarea(31, aprobadasT31, reprobadasT31)

                    subtotalPdT3 = calculateTask(
                        3,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
        with(etReprobadasT31) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT31 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT31 = 0
                        s.isNotEmpty() -> reprobadasT31 = text.toString().toInt()
                    }
                    subTotalPdT31 = calcularSubTarea(31, aprobadasT31, reprobadasT31)

                    subtotalPdT3 = calculateTask(
                        3,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }

        with(etAprobadasT32) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT32 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT32 = 0
                        s.isNotEmpty() -> aprobadasT32 = text.toString().toInt()
                    }

                    subTotalPdT32 = calcularSubTarea(32, aprobadasT32, reprobadasT32)

                    subtotalPdT3 = calculateTask(
                        3,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
        with(etReprobadasT32) {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT32 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT32 = 0
                        s.isNotEmpty() -> reprobadasT32 = text.toString().toInt()
                    }
                    subTotalPdT32 = calcularSubTarea(32, aprobadasT32, reprobadasT32)

                    subtotalPdT3 = calculateTask(
                        3,
                        tvSubTotalT3,
                        context.getString(R.string.TAREA_3),
                        0,
                        0,
                        0
                    )
                    calculateResult()
                }
            })
        }
    }

    /**
     * Calculate SubTask for task 2 & 3
     */
    private fun calcularSubTarea(
        subTarea: Int,
        aprobadas: Int,
        reprobadas: Int
    ): Double {
        return when (subTarea) {
            //Tarea 2_1 items 1-5
            21 -> (aprobadas - reprobadas).toDouble()

            //Tarea 2_2 items 6-9
            22 -> aprobadas - (reprobadas / 2.0)

            //Tarea 3_1 items 1-9
            31 -> aprobadas - (reprobadas / 3.0)

            //Tarea 3_1 items 10-14
            32 -> (aprobadas - reprobadas).toDouble()
            else -> 0.0
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
        var total = floor(
            when (nTarea) {
                1 -> aprobadas - (reprobadas / 2.0)
                2 -> subTotalPdT21 + subTotalPdT22
                3 -> subTotalPdT31 + subTotalPdT32
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0

        tvSubTotal.text = setSubTotalPoints(tarea, total)
        return total
    }

    override fun calculateResult() {

        //TOTALES
        with(subtotalPdT1 + subtotalPdT2 + subtotalPdT3, {
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