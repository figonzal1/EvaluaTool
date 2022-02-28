/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:16
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityExactitudLectoraE1M4Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo4.ExactitudLectoraE1M4Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class ExactitudLectoraE1M4 : AppCompatActivity() {

    private lateinit var binding: ActivityExactitudLectoraE1M4Binding

    //TAREA 1
    private lateinit var etApprovedT1: TextInputEditText
    private var approvedT1 = 0

    //TAREA 2
    private lateinit var etApprovedT2: TextInputEditText
    private var approvedT2 = 0

    //TAREA 3
    private lateinit var etApprovedT3: TextInputEditText
    private var approvedT3 = 0

    //TAREA 4
    private lateinit var etApprovedT4: TextInputEditText
    private var approvedT4 = 0

    //TAREA 5
    private lateinit var etApprovedT5: TextInputEditText
    private var approvedT5 = 0

    //TAREA 6
    private lateinit var etApprovedT6: TextInputEditText
    private var approvedT6 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView
    private lateinit var tvSubTotalT4: TextView
    private lateinit var tvSubTotalT5: TextView
    private lateinit var tvSubTotalT6: TextView

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ExactitudLectoraE1M4Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExactitudLectoraE1M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_EXACTITUD_LECTORA,
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
            this@ExactitudLectoraE1M4.etApprovedT1 = etAprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@ExactitudLectoraE1M4.etApprovedT2 = etAprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@ExactitudLectoraE1M4.etApprovedT3 = etAprobadasT3

            //TAREA 4
            tvSubTotalT4 = tvPdSubtotalT4
            this@ExactitudLectoraE1M4.etApprovedT4 = etAprobadasT4

            //TAREA 5
            tvSubTotalT5 = tvPdSubtotalT5
            this@ExactitudLectoraE1M4.etApprovedT5 = etAprobadasT5

            //TAREA 6
            tvSubTotalT6 = tvPdSubtotalT6
            this@ExactitudLectoraE1M4.etApprovedT6 = etAprobadasT6

            //TOTAL
            this@ExactitudLectoraE1M4.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_EXACTITUD_LECTORA)
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
                            approved = approvedT1
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
                            approved = approvedT2
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
                            approved = approvedT3
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
                        s.isEmpty() -> approvedT4 = 0
                        s.isNotEmpty() -> approvedT4 = text.toString().toInt()
                    }
                    with(
                        resolver.calculateTask(
                            nTask = 4,
                            approved = approvedT4
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
                            approved = approvedT5
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
                            approved = approvedT6
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.d(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}