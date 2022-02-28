/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:16
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMemoriaAtencionE2M2Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua2.modulo2.MemoriaAtencionE2M2Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class MemoriaAtencionE2M2 : AppCompatActivity() {

    private lateinit var binding: ActivityMemoriaAtencionE2M2Binding

    //TAREA 1
    private lateinit var etApprovedT1: TextInputEditText
    private lateinit var etOmittedT1: TextInputEditText
    private lateinit var etReprobateT1: TextInputEditText
    private var approvedT1 = 0
    private var omittedT1 = 0
    private var reprobateT1 = 0

    //TAREA 2
    private lateinit var etApprovedT2: TextInputEditText
    private lateinit var etOmittedT2: TextInputEditText
    private lateinit var etReprobateT2: TextInputEditText
    private var approvedT2 = 0
    private var omittedT2 = 0
    private var reprobateT2 = 0

    //TAREA 3
    private lateinit var etApprovedT3: TextInputEditText
    private lateinit var etOmittedT3: TextInputEditText
    private lateinit var etReprobateT3: TextInputEditText
    private var approvedT3 = 0
    private var omittedT3 = 0
    private var reprobateT3 = 0

    //TAREA 4
    private lateinit var etApprovedT4: TextInputEditText
    private lateinit var etOmittedT4: TextInputEditText
    private lateinit var etReprobateT4: TextInputEditText
    private var approved = 0
    private var omittedT4 = 0
    private var reprobateT4 = 0

    //TAREA 5
    private lateinit var etApprovedT5: TextInputEditText
    private lateinit var etOmittedT5: TextInputEditText
    private lateinit var etReprobateT5: TextInputEditText
    private var approvedT5 = 0
    private var omittedT5 = 0
    private var reprobateT5 = 0

    //TAREA 6
    private lateinit var etApprovedT6: TextInputEditText
    private lateinit var etOmittedT6: TextInputEditText
    private lateinit var etReprobateT6: TextInputEditText
    private var approvedT6 = 0
    private var omittedT6 = 0
    private var reprobateT6 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private lateinit var tvSubTotalT5: TextView
    private lateinit var tvSubTotalT6: TextView

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
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

        with(binding) {

            //Promedio y desviacion
            //TetView desviacion y media
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@MemoriaAtencionE2M2.etApprovedT1 = etAprobadasT1
            this@MemoriaAtencionE2M2.etOmittedT1 = etOmitidasT1
            this@MemoriaAtencionE2M2.etReprobateT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@MemoriaAtencionE2M2.etApprovedT2 = etAprobadasT2
            this@MemoriaAtencionE2M2.etOmittedT2 = etOmitidasT2
            this@MemoriaAtencionE2M2.etReprobateT2 = etReprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@MemoriaAtencionE2M2.etApprovedT3 = etAprobadasT3
            this@MemoriaAtencionE2M2.etOmittedT3 = etOmitidasT3
            this@MemoriaAtencionE2M2.etReprobateT3 = etReprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@MemoriaAtencionE2M2.etApprovedT4 = etAprobadasT4
            this@MemoriaAtencionE2M2.etOmittedT4 = etOmitidasT4
            this@MemoriaAtencionE2M2.etReprobateT4 = etReprobadasT4

            //TAREA 5
            tvSubTotalT5 = tvPdSubtotalT5
            this@MemoriaAtencionE2M2.etApprovedT5 = etAprobadasT5
            this@MemoriaAtencionE2M2.etOmittedT5 = etOmitidasT5
            this@MemoriaAtencionE2M2.etReprobateT5 = etReprobadasT5

            //TAREA 6
            tvSubTotalT6 = tvPdSubtotalT6
            this@MemoriaAtencionE2M2.etApprovedT6 = etAprobadasT6
            this@MemoriaAtencionE2M2.etOmittedT6 = etOmitidasT6
            this@MemoriaAtencionE2M2.etReprobateT6 = etReprobadasT6

            //TOTAL
            this@MemoriaAtencionE2M2.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = binding.cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_MEMORIA_ATENCION)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
            textWatcherTask2(getString(R.string.TAREA_2))
            textWatcherTask3(getString(R.string.TAREA_3))
            textWatcherTask4(getString(R.string.TAREA_4))
            textWatcherTask5(getString(R.string.TAREA_5))
            textWatcherTask6(getString(R.string.TAREA_6))
        }

    }

    private fun textWatcherTask1(task: String) {

        etApprovedT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT1 = 0
                        s.isNotEmpty() -> approvedT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT1 = 0
                        s.isNotEmpty() -> omittedT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT1 = 0
                        s.isNotEmpty() -> reprobateT1 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = approvedT1,
                            omitted = omittedT1,
                            reprobate = reprobateT1
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTask2(task: String) {

        etApprovedT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT2 = 0
                        s.isNotEmpty() -> approvedT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = approvedT2,
                            omitted = omittedT2,
                            reprobate = reprobateT2
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT2 = 0
                        s.isNotEmpty() -> omittedT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = approvedT2,
                            omitted = omittedT2,
                            reprobate = reprobateT2
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT2 = 0
                        s.isNotEmpty() -> reprobateT2 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = approvedT2,
                            omitted = omittedT2,
                            reprobate = reprobateT2
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTask3(task: String) {

        etApprovedT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT3 = 0
                        s.isNotEmpty() -> approvedT3 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = approvedT3,
                            omitted = omittedT3,
                            reprobate = reprobateT3
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT3 = 0
                        s.isNotEmpty() -> {
                            omittedT3 = text.toString().toInt()
                        }
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = approvedT3,
                            omitted = omittedT3,
                            reprobate = reprobateT3
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT3 = 0
                        s.isNotEmpty() -> reprobateT3 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = approvedT3,
                            omitted = omittedT3,
                            reprobate = reprobateT3
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTask4(task: String) {

        etApprovedT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approved = 0
                        s.isNotEmpty() -> approved = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 4,
                            approved = approved,
                            omitted = omittedT4,
                            reprobate = reprobateT4
                        )
                    ) {
                        resolver.totalPdTask4 = this
                        tvSubTotalT4.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT4 = 0
                        s.isNotEmpty() -> omittedT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 4,
                            approved = approved,
                            omitted = omittedT4,
                            reprobate = reprobateT4
                        )
                    ) {
                        resolver.totalPdTask4 = this
                        tvSubTotalT4.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT4.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask4 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT4 = 0
                        s.isNotEmpty() -> reprobateT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 4,
                            approved = approved,
                            omitted = omittedT4,
                            reprobate = reprobateT4
                        )
                    ) {
                        resolver.totalPdTask4 = this
                        tvSubTotalT4.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTask5(task: String) {

        etApprovedT5.run {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT5 = 0
                        s.isNotEmpty() -> approvedT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 5,
                            approved = approvedT5,
                            omitted = omittedT5,
                            reprobate = reprobateT5
                        )
                    ) {
                        resolver.totalPdTask5 = this
                        tvSubTotalT5.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT5.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT5 = 0
                        s.isNotEmpty() -> omittedT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 5,
                            approved = approvedT5,
                            omitted = omittedT5,
                            reprobate = reprobateT5
                        )
                    ) {
                        resolver.totalPdTask5 = this
                        tvSubTotalT5.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT5.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask5 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT5 = 0
                        s.isNotEmpty() -> reprobateT5 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 5,
                            approved = approvedT5,
                            omitted = omittedT5,
                            reprobate = reprobateT5
                        )
                    ) {
                        resolver.totalPdTask5 = this
                        tvSubTotalT5.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }
    }

    private fun textWatcherTask6(task: String) {

        etApprovedT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT6 = 0
                        s.isNotEmpty() -> approvedT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 6,
                            approved = approvedT6,
                            omitted = omittedT6,
                            reprobate = reprobateT6
                        )
                    ) {
                        resolver.totalPdTask6 = this
                        tvSubTotalT6.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etOmittedT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> omittedT6 = 0
                        s.isNotEmpty() -> omittedT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 6,
                            approved = approvedT6,
                            omitted = omittedT6,
                            reprobate = reprobateT6
                        )
                    ) {
                        resolver.totalPdTask6 = this
                        tvSubTotalT6.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT6.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    resolver.totalPdTask6 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> reprobateT6 = 0
                        s.isNotEmpty() -> reprobateT6 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 6,
                            approved = approvedT6,
                            omitted = omittedT6,
                            reprobate = reprobateT6
                        )
                    ) {
                        resolver.totalPdTask6 = this
                        tvSubTotalT6.text = formatSubTotalPoints(task, this)
                    }
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
            val pdCorrected = correctPD(perc, getTotal().toInt())
            tvPdCorrected.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorrected.toDouble())

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEAN, DEVIATION, pdCorrected)

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(perc, pdCorrected)
            tvPercentile.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvLevel.text = EvaluaUtils.calcularNivel(percentile)
        }
    }
}