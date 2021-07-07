/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-07-21 16:48
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityComprensionLectoraE6M4Binding
import cl.figonzal.evaluatool.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver
import cl.figonzal.evaluatool.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText

class ComprensionLectoraE6M4 : AppCompatActivity() {

    private lateinit var binding: ActivityComprensionLectoraE6M4Binding

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
    private var subTotalPdT21 = 0.0
    private var subTotalPdT22 = 0.0


    //TAREA 3
    private lateinit var etAprobadasT31: TextInputEditText
    private lateinit var etReprobadasT31: TextInputEditText
    private lateinit var etAprobadasT32: TextInputEditText
    private lateinit var etReprobadasT32: TextInputEditText
    private var aprobadasT31 = 0
    private var reprobadasT31 = 0
    private var aprobadasT32 = 0
    private var reprobadasT32 = 0
    private var subTotalPdT31 = 0.0
    private var subTotalPdT32 = 0.0


    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ComprensionLectoraE6M4Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprensionLectoraE6M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_COMPREN_LECTORA, binding.includeToolbar.materialToolbar)

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
            progressBar.max = resolver.perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setOnClickListener {

                logInfo(R.string.DIALOGO_AYUDA_MSG_ABIERTO)
                alertDialogPdCorregido()

            }
            Utils.configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver.perc,
                getString(R.string.TOOLBAR_COMPREN_LECTORA)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
            textWatcherTarea2(getString(R.string.TAREA_2))
            textWatcherTarea3(getString(R.string.TAREA_3))
        }
    }


    private fun textWatcherTarea1(tarea: String) {

        etAprobadasT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT1 = 0
                        s.isNotEmpty() -> aprobadasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT1 = 0
                        s.isNotEmpty() -> reprobadasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea2(tarea: String) {

        etAprobadasT21.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT21 = 0
                        s.isNotEmpty() -> aprobadasT21 = text.toString().toInt()
                    }

                    subTotalPdT21 = calcularSubTarea(21, aprobadasT21, reprobadasT21)

                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = subTotalPdT21.toInt(),
                            reprobadas = subTotalPdT22.toInt()
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT21.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = subTotalPdT21.toInt(),
                            reprobadas = subTotalPdT22.toInt()
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etAprobadasT22.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = subTotalPdT21.toInt(),
                            reprobadas = subTotalPdT22.toInt()
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT22.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = subTotalPdT21.toInt(),
                            reprobadas = subTotalPdT22.toInt()
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea3(tarea: String) {

        etAprobadasT31.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = subTotalPdT31.toInt(),
                            reprobadas = subTotalPdT32.toInt()
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT31.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = subTotalPdT31.toInt(),
                            reprobadas = subTotalPdT32.toInt()
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etAprobadasT32.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = subTotalPdT31.toInt(),
                            reprobadas = subTotalPdT32.toInt()
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT32.run {
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

                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = subTotalPdT31.toInt(),
                            reprobadas = subTotalPdT32.toInt()
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
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

    private fun calculateResult() {

        //Calculate Total PD
        resolver.run {

            tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotal())

            //Correct total pd based on Baremo Table
            val pdCorregido = correctPD(perc, getTotal().toInt())
            tvPdCorregido.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorregido.toDouble())

            //Calculate desviation
            tvDesviacionCalculada.text =
                Utils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido)

            //Calculate Percentile
            val percentile = Utils.calculatePercentile(perc, pdCorregido)
            tvPercentil.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvNivel.text = Utils.calcularNivel(percentile)
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
}