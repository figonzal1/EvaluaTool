/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 16:35
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMemoriaAtencionE2M2Binding
import cl.figonzal.evaluatool.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver
import cl.figonzal.evaluatool.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilities.*
import cl.figonzal.evaluatool.utilities.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class MemoriaAtencionE2M2 : AppCompatActivity() {

    private lateinit var binding: ActivityMemoriaAtencionE2M2Binding

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

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorregido: TextView
    private lateinit var tvPercentil: TextView
    private lateinit var tvNivel: TextView
    private lateinit var tvDesviacionCalculada: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        MemoriaAtencionE2M2Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoriaAtencionE2M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_MEMORIA_ATENCION,
            binding.includeToolbar.materialToolbar
        )

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
            progressBar.max = resolver.perc.first()[1] as Int

            setAlertDialogCorregido(cardViewFinal.ivHelpPdCorregido)

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_MEMORIA_ATENCION)
            )
        }).also {
            textWatcherTarea1(getString(R.string.TAREA_1))
            textWatcherTarea2(getString(R.string.TAREA_2))
            textWatcherTarea3(getString(R.string.TAREA_3))
            textWatcherTarea4(getString(R.string.TAREA_4))
            textWatcherTarea5(getString(R.string.TAREA_5))
            textWatcherTarea6(getString(R.string.TAREA_6))
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
                            omitidas = omitidasT1,
                            reprobadas = reprobadasT1
                        ), {
                            resolver.totalPdTarea1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT1.run {
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
                        s.isEmpty() -> omitidasT1 = 0
                        s.isNotEmpty() -> omitidasT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 1,
                            aprobadas = aprobadasT1,
                            omitidas = omitidasT1,
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
                            omitidas = omitidasT1,
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
                            omitidas = omitidasT2,
                            reprobadas = reprobadasT2
                        ), {
                            resolver.totalPdTarea2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT2.run {
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
                        s.isEmpty() -> omitidasT2 = 0
                        s.isNotEmpty() -> omitidasT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 2,
                            aprobadas = aprobadasT2,
                            omitidas = omitidasT2,
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
                            omitidas = omitidasT2,
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
                            omitidas = omitidasT3,
                            reprobadas = reprobadasT3
                        ), {
                            resolver.totalPdTarea3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT3.run {
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
                        s.isEmpty() -> omitidasT3 = 0
                        s.isNotEmpty() -> {
                            omitidasT3 = text.toString().toInt()
                        }
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 3,
                            aprobadas = aprobadasT3,
                            omitidas = omitidasT3,
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
                            omitidas = omitidasT3,
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
                            omitidas = omitidasT4,
                            reprobadas = reprobadasT4
                        ), {
                            resolver.totalPdTarea4 = this
                            tvSubTotalT4.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT4.run {
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
                        s.isEmpty() -> omitidasT4 = 0
                        s.isNotEmpty() -> omitidasT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 4,
                            aprobadas = aprobadasT4,
                            omitidas = omitidasT4,
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
                            omitidas = omitidasT4,
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

    private fun textWatcherTarea5(tarea: String) {

        etAprobadasT5.run {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT5 = 0
                        s.isNotEmpty() -> aprobadasT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 5,
                            aprobadas = aprobadasT5,
                            omitidas = omitidasT5,
                            reprobadas = reprobadasT5
                        ), {
                            resolver.totalPdTarea5 = this
                            tvSubTotalT5.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT5.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT5 = 0
                        s.isNotEmpty() -> omitidasT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 5,
                            aprobadas = aprobadasT5,
                            omitidas = omitidasT5,
                            reprobadas = reprobadasT5
                        ), {
                            resolver.totalPdTarea5 = this
                            tvSubTotalT5.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT5.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT5 = 0
                        s.isNotEmpty() -> reprobadasT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 5,
                            aprobadas = aprobadasT5,
                            omitidas = omitidasT5,
                            reprobadas = reprobadasT5
                        ), {
                            resolver.totalPdTarea5 = this
                            tvSubTotalT5.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTarea6(tarea: String) {

        etAprobadasT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> aprobadasT6 = 0
                        s.isNotEmpty() -> aprobadasT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 6,
                            aprobadas = aprobadasT6,
                            omitidas = omitidasT6,
                            reprobadas = reprobadasT6
                        ), {
                            resolver.totalPdTarea6 = this
                            tvSubTotalT6.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etOmitidasT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omitidasT6 = 0
                        s.isNotEmpty() -> omitidasT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 6,
                            aprobadas = aprobadasT6,
                            omitidas = omitidasT6,
                            reprobadas = reprobadasT6
                        ), {
                            resolver.totalPdTarea6 = this
                            tvSubTotalT6.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
        }

        etReprobadasT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTarea6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobadasT6 = 0
                        s.isNotEmpty() -> reprobadasT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTarea = 6,
                            aprobadas = aprobadasT6,
                            omitidas = omitidasT6,
                            reprobadas = reprobadasT6
                        ), {
                            resolver.totalPdTarea6 = this
                            tvSubTotalT6.text = formatSubTotalPoints(tarea, this)
                        })
                    calculateResult()
                }
            })
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
}