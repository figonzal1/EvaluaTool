/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:07
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityComprensionLectoraE5M4Binding
import cl.figonzal.evaluatool.resolvers.evalua5.modulo4.ComprensionLectoraE5M4Resolver
import cl.figonzal.evaluatool.resolvers.evalua5.modulo4.ComprensionLectoraE5M4Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua5.modulo4.ComprensionLectoraE5M4Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilities.*
import cl.figonzal.evaluatool.utilities.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class ComprensionLectoraE5M4 : AppCompatActivity() {

    private lateinit var binding: ActivityComprensionLectoraE5M4Binding

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

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ComprensionLectoraE5M4Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprensionLectoraE5M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_COMPREN_LECTORA, binding.includeToolbar.materialToolbar)

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
            progressBar.max = resolver.perc.first()[1] as Int

            setAlertDialogCorregido(cardViewFinal.ivHelpPdCorregido)

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_COMPREN_LECTORA)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
            textWatcherTarea2(getString(R.string.TAREA_2))
            textWatcherTarea3(getString(R.string.TAREA_3))
            textWatcherTarea4(getString(R.string.TAREA_4))
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

        etAprobadasT2.run {
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
                        s.isEmpty() -> aprobadasT2 = 0
                        s.isNotEmpty() -> aprobadasT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = aprobadasT2,
                            reprobadas = reprobadasT2
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT2.run {
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
                        s.isEmpty() -> reprobadasT2 = 0
                        s.isNotEmpty() -> reprobadasT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = aprobadasT2,
                            reprobadas = reprobadasT2
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

        etAprobadasT3.run {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT3 = 0
                        s.isNotEmpty() -> aprobadasT3 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = aprobadasT3,
                            reprobadas = reprobadasT3
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT3 = 0
                        s.isNotEmpty() -> reprobadasT3 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = aprobadasT3,
                            reprobadas = reprobadasT3
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea4(tarea: String) {

        etAprobadasT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT4 = 0
                        s.isNotEmpty() -> aprobadasT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 4,
                            aprobadas = aprobadasT4,
                            reprobadas = reprobadasT4
                        ), {
                            resolver.totalPdTarea4 = this
                            tvSubTotalT4.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT4 = 0
                        s.isNotEmpty() -> reprobadasT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 4,
                            aprobadas = aprobadasT4,
                            reprobadas = reprobadasT4
                        ), {
                            resolver.totalPdTarea4 = this
                            tvSubTotalT4.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
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
                EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pdCorregido)

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(perc, pdCorregido)
            tvPercentil.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvNivel.text = EvaluaUtils.calcularNivel(percentile)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.d(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}