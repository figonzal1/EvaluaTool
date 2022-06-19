/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 22:32
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo6

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityResolucionProblemasE7M6Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo6.ResolucionProblemasE7M6Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class ResolucionProblemasE7M6 : AppCompatActivity() {

    private lateinit var binding: ActivityResolucionProblemasE7M6Binding

    //TAREA 1
    private lateinit var etApprovedT11: TextInputEditText
    private var approvedT11 = 0
    private lateinit var etApprovedT12: TextInputEditText
    private var approvedT12 = 0

    private var subTotalPdT11 = 0.0
    private var subTotalPdT12 = 0.0

    private lateinit var tvSubTotalT1: TextView

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ResolucionProblemasE7M6Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityResolucionProblemasE7M6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_RESOLUCION_PROBLEMAS,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //SUBTOTALES
            tvSubTotalT1 = tvPdSubtotalT1
            this@ResolucionProblemasE7M6.etApprovedT11 = etAprobadasT1
            this@ResolucionProblemasE7M6.etApprovedT12 = etAprobadasT2

            //TOTALES
            this@ResolucionProblemasE7M6.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.percentile.first()[1].toInt()

            cardViewFinal.ivHelpPdCorregido.setAlertDialogCorregido()

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_RESOLUCION_PROBLEMAS)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
        }
    }

    private fun textWatcherTask1(task: String) {

        etApprovedT11.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT11 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT11 = 0
                        s.isNotEmpty() -> approvedT11 = text.toString().toInt()
                    }
                    subTotalPdT11 = calculateSubTask(11, approvedT11)
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = subTotalPdT11.toInt(),
                            reprobate = subTotalPdT12.toInt()
                        )
                    ) {
                        resolver.totalPdTask1 = this
                        tvSubTotalT1.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etApprovedT12.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalPdT12 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> approvedT12 = 0
                        s.isNotEmpty() -> approvedT12 = text.toString().toInt()
                    }
                    subTotalPdT12 = calculateSubTask(12, approvedT12)
                    with(
                        resolver.calculateTask(
                            nTask = 1,
                            approved = subTotalPdT11.toInt(),
                            reprobate = subTotalPdT12.toInt()
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

    private fun calculateSubTask(subTask: Int, approved: Int): Double {
        return when (subTask) {
            11 -> approved.toDouble()
            12 -> 4 * approved.toDouble()
            else -> 0.0
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

            tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, getTotalPD())

            //Correct total pd based on Baremo Table
            val pdCorrected = correctPD(percentile, getTotalPD().toInt())
            tvPdCorrected.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorrected.toDouble())

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEAN, DEVIATION, pdCorrected)

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
            tvLevel.text = EvaluaUtils.calcularNivel(percentile)
        }
    }
}