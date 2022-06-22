/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 22-06-22 10:12
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityAtencionConcentracionE8M1Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo1.AtencionConcentracionE8M1Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo1.AtencionConcentracionE8M1Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo1.AtencionConcentracionE8M1Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configBaremoText
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject
import timber.log.Timber

class AtencionConcentracionE8M1 : AppCompatActivity() {

    private lateinit var binding: ActivityAtencionConcentracionE8M1Binding

    //TAREA 1
    private lateinit var etApprovedT1: TextInputEditText
    private lateinit var etOmittedT1: TextInputEditText
    private lateinit var etReprobateT1: TextInputEditText

    //TAREA2
    private lateinit var etApprovedT2: TextInputEditText
    private lateinit var etOmittedT2: TextInputEditText
    private lateinit var etReprobateT2: TextInputEditText

    //TextView para Subtotales
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView

    //Parciales Tarea 1
    private var approvedT1 = 0
    private var omittedT1 = 0
    private var reprobateT1 = 0

    //Parciales para Tarea 2
    private var approvedT2 = 0
    private var omittedT2 = 0
    private var reprobateT2 = 0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var progressBar: LinearProgressIndicator
    private lateinit var tvCalculatedDeviation: TextView

    private val resolver: AtencionConcentracionE8M1Resolver by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityAtencionConcentracionE8M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_ATENCION_CONCENTRACION,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {


            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@AtencionConcentracionE8M1.etApprovedT1 = etAprobadasT1
            this@AtencionConcentracionE8M1.etOmittedT1 = etOmitidasT1
            this@AtencionConcentracionE8M1.etReprobateT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@AtencionConcentracionE8M1.etApprovedT2 = etAprobadasT2
            this@AtencionConcentracionE8M1.etOmittedT2 = etOmitidasT2
            this@AtencionConcentracionE8M1.etReprobateT2 = etReprobadasT2

            //TOTAL
            this@AtencionConcentracionE8M1.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.percentile.first()[1].toInt()

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configBaremoText(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_ATENCION_CONCENTRACION)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
            textWatcherTask2(getString(R.string.TAREA_2))
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

    private fun calculateResult() {

        //Calculate Total PD
        resolver.run {

            tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotalPD())

            //Correct total pd based on Baremo Table
            val pdCorrected = correctPD(percentile, getTotalPD().toInt())
            tvPdCorrected.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorrected.toDouble())

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calculateDeviation(MEAN, DEVIATION, pdCorrected)

            //Calculate Percentile
            val percentile = EvaluaUtils.calculatePercentile(percentile, pdCorrected)
            tvPercentile.text = percentile.toString()

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> progressBar.setProgressCompat(
                    percentile,
                    true
                )
                else -> progressBar.progress = percentile
            }

            //Calculate student level
            tvLevel.text = EvaluaUtils.calculateStudentLevel(percentile)
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