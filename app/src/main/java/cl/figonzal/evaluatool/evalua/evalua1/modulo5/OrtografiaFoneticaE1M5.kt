/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:07
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo5

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityOrtografiaFoneticaE1M5Binding
import cl.figonzal.evaluatool.resolvers.evalua1.modulo5.OrtografiaFoneticaE1M5Resolver
import cl.figonzal.evaluatool.resolvers.evalua1.modulo5.OrtografiaFoneticaE1M5Resolver.Companion.DESVIACION
import cl.figonzal.evaluatool.resolvers.evalua1.modulo5.OrtografiaFoneticaE1M5Resolver.Companion.MEDIA
import cl.figonzal.evaluatool.utilities.*
import cl.figonzal.evaluatool.utilities.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*

class OrtografiaFoneticaE1M5 : AppCompatActivity() {

    private lateinit var binding: ActivityOrtografiaFoneticaE1M5Binding

    //TAREA 1
    private lateinit var etApprovedT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var approvedT1 = 0

    //TAREA 2
    private lateinit var etApprovedT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var approvedT2 = 0

    //TAREA 3
    private lateinit var etApprovedT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var approvedT3 = 0

    //Tetview para total
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        OrtografiaFoneticaE1M5Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrtografiaFoneticaE1M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_ORTOGRAFIA_FONETICA,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding, {
            //Promedio y desviacion
            cardViewConstantes.tvMediaValue.text = MEDIA.toString()
            cardViewConstantes.tvDesviacionValue.text = DESVIACION.toString()

            //TAREA 1
            tvSubTotalT1 = tvPdSubtotalT1
            this@OrtografiaFoneticaE1M5.etApprovedT1 = etAprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@OrtografiaFoneticaE1M5.etApprovedT2 = etAprobadasT2

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@OrtografiaFoneticaE1M5.etApprovedT3 = etAprobadasT3

            //TOTAL
            this@OrtografiaFoneticaE1M5.tvPdTotal = tvPdTotalValue
            tvPdCorrected = cardViewFinal.tvPdTotalCorregidoValue
            tvPercentile = cardViewFinal.tvPercentilValue
            tvLevel = cardViewFinal.tvNivelObtenidoValue
            tvCalculatedDeviation = cardViewFinal.tvDesviacionCalculadaValue

            progressBar = cardViewFinal.progressBar
            progressBar.max = resolver.perc.first()[1] as Int

            setAlertDialogCorregido(cardViewFinal.ivHelpPdCorregido)

            configurarTextoBaremo(
                supportFragmentManager,
                tablaBaremo.tvBaremo,
                resolver,
                getString(R.string.TOOLBAR_ORTOGRAFIA_FONETICA)
            )
        }).also {
            textWatcherTask1(getString(R.string.TAREA_1))
            textWatcherTask2(getString(R.string.TAREA_2))
            textWatcherTask3(getString(R.string.TAREA_3))
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
                        ), {
                            resolver.totalPdTask1 = this
                            tvSubTotalT1.text = formatSubTotalPoints(task, this)
                        })
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
                        ), {
                            resolver.totalPdTask2 = this
                            tvSubTotalT2.text = formatSubTotalPoints(task, this)
                        })
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
                        ), {
                            resolver.totalPdTask3 = this
                            tvSubTotalT3.text = formatSubTotalPoints(task, this)
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
            val pdCorrected = correctPD(perc, getTotal().toInt())
            tvPdCorrected.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, pdCorrected.toDouble())

            //Calculate desviation
            tvCalculatedDeviation.text =
                EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pdCorrected)

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