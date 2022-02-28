/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:20
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo2

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityRazonamientoEspacialE9M2Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo2.RazonamientoEspacialE9M2Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class RazonamientoEspacialE9M2 : AppCompatActivity() {

    private lateinit var binding: ActivityRazonamientoEspacialE9M2Binding

    //TAREA 1
    private lateinit var etApprovedT11: TextInputEditText
    private lateinit var etReprobateT11: TextInputEditText
    private lateinit var etApprovedT12: TextInputEditText
    private lateinit var etReprobateT12: TextInputEditText
    private var approvedT11 = 0
    private var reprobateT11 = 0
    private var approvedT12 = 0
    private var reprobateT12 = 0
    private var subTotalPdT11 = 0.0
    private var subTotalPdT12 = 0.0

    //TAREA 2
    private lateinit var etApprovedT2: TextInputEditText
    private lateinit var etReprobateT2: TextInputEditText
    private var approvedT2 = 0
    private var reprobateT2 = 0

    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView

    //TOTALES
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        RazonamientoEspacialE9M2Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRazonamientoEspacialE9M2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_RAZON_ESPACIAL, binding.includeToolbar.materialToolbar)

        initResources()
    }

    private fun initResources() {

        with(binding) {
            cardViewConstantes.tvMediaValue.text = MEAN.toString()
            cardViewConstantes.tvDesviacionValue.text = DEVIATION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@RazonamientoEspacialE9M2.etApprovedT11 = etAprobadasT11
            this@RazonamientoEspacialE9M2.etReprobateT11 = etReprobadasT11
            this@RazonamientoEspacialE9M2.etApprovedT12 = etAprobadasT12
            this@RazonamientoEspacialE9M2.etReprobateT12 = etReprobadasT12

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@RazonamientoEspacialE9M2.etApprovedT2 = etAprobadasT2
            this@RazonamientoEspacialE9M2.etReprobateT2 = etReprobadasT2

            //TOTAL
            this@RazonamientoEspacialE9M2.tvPdTotal = tvPdTotalValue
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
                getString(R.string.TOOLBAR_RAZON_ESPACIAL)
            )
        }.also {
            textWatcherTask1(getString(R.string.TAREA_1))
            textWatcherTask2(getString(R.string.TAREA_2))
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

                    subTotalPdT11 = calculateSubTask(11, approvedT11, reprobateT11)

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

        etReprobateT11.run {
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
                        s.isEmpty() -> reprobateT11 = 0
                        s.isNotEmpty() -> reprobateT11 = text.toString().toInt()
                    }

                    subTotalPdT11 = calculateSubTask(11, approvedT11, reprobateT11)

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

                    subTotalPdT12 = calculateSubTask(12, approvedT12, reprobateT12)

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

        etReprobateT12.run {
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
                        s.isEmpty() -> reprobateT12 = 0
                        s.isNotEmpty() -> reprobateT12 = text.toString().toInt()
                    }

                    subTotalPdT12 = calculateSubTask(12, approvedT12, reprobateT12)

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

    private fun calculateSubTask(subTask: Int, approved: Int, reprobate: Int): Double {
        return when (subTask) {
            //TAREA 1_1 items 1-7
            11 -> approved - reprobate / 5.0

            //TAREA 1_2 items 8-9
            12 -> approved - reprobate / 10.0
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

}