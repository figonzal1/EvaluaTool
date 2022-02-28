/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:19
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo4

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityComprensionLectoraE6M4Binding
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver.Companion.DEVIATION
import cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4.ComprensionLectoraE6M4Resolver.Companion.MEAN
import cl.figonzal.evaluatool.utils.*
import cl.figonzal.evaluatool.utils.EvaluaUtils.configurarTextoBaremo
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber

class ComprensionLectoraE6M4 : AppCompatActivity() {

    private lateinit var binding: ActivityComprensionLectoraE6M4Binding

    //TAREA 1
    private lateinit var etApprovedT1: TextInputEditText
    private lateinit var etReprobateT1: TextInputEditText
    private var approvedT1 = 0
    private var reprobateT1 = 0

    //TAREA 2
    private lateinit var etApprovedT21: TextInputEditText
    private lateinit var etReprobateT21: TextInputEditText
    private lateinit var etApprovedT22: TextInputEditText
    private lateinit var etReprobateT22: TextInputEditText
    private var approvedT21 = 0
    private var reprobateT21 = 0
    private var approvedT22 = 0
    private var reprobateT22 = 0
    private var subTotalPdT21 = 0.0
    private var subTotalPdT22 = 0.0


    //TAREA 3
    private lateinit var etApprovedT31: TextInputEditText
    private lateinit var etReprobateT31: TextInputEditText
    private lateinit var etApprovedT32: TextInputEditText
    private lateinit var etReprobateT32: TextInputEditText
    private var approvedT31 = 0
    private var reprobateT31 = 0
    private var approvedT32 = 0
    private var reprobateT32 = 0
    private var subTotalPdT31 = 0.0
    private var subTotalPdT32 = 0.0


    //SUBTOTALES
    private lateinit var tvSubTotalT1: TextView
    private lateinit var tvSubTotalT2: TextView
    private lateinit var tvSubTotalT3: TextView

    //TOTAL
    private lateinit var tvPdTotal: TextView
    private lateinit var tvPdCorrected: TextView
    private lateinit var tvPercentile: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvCalculatedDeviation: TextView
    private lateinit var progressBar: LinearProgressIndicator

    private val resolver by lazy {
        ComprensionLectoraE6M4Resolver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprensionLectoraE6M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_COMPREN_LECTORA, binding.includeToolbar.materialToolbar)

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
            this@ComprensionLectoraE6M4.etApprovedT1 = etAprobadasT1
            this@ComprensionLectoraE6M4.etReprobateT1 = etReprobadasT1

            //TAREA 2
            tvSubTotalT2 = tvPdSubtotalT2
            this@ComprensionLectoraE6M4.etApprovedT21 = etAprobadasT21
            this@ComprensionLectoraE6M4.etReprobateT21 = etReprobadasT21
            this@ComprensionLectoraE6M4.etApprovedT22 = etAprobadasT22
            this@ComprensionLectoraE6M4.etReprobateT22 = etReprobadasT22

            //TAREA 3
            tvSubTotalT3 = tvPdSubtotalT3
            this@ComprensionLectoraE6M4.etApprovedT31 = etAprobadasT31
            this@ComprensionLectoraE6M4.etReprobateT31 = etReprobadasT31
            this@ComprensionLectoraE6M4.etApprovedT32 = etAprobadasT32
            this@ComprensionLectoraE6M4.etReprobateT32 = etReprobadasT32

            //TOTAL
            this@ComprensionLectoraE6M4.tvPdTotal = tvPdTotalValue
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
                getString(R.string.TOOLBAR_COMPREN_LECTORA)
            )
        }.also {
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
                            approved = approvedT1,
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

        etApprovedT21.run {
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
                        s.isEmpty() -> approvedT21 = 0
                        s.isNotEmpty() -> approvedT21 = text.toString().toInt()
                    }

                    subTotalPdT21 = calculateSubTask(21, approvedT21, reprobateT21)

                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = subTotalPdT21.toInt(),
                            reprobate = subTotalPdT22.toInt()
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT21.run {
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
                        s.isEmpty() -> reprobateT21 = 0
                        s.isNotEmpty() -> reprobateT21 = text.toString().toInt()
                    }
                    subTotalPdT21 = calculateSubTask(21, approvedT21, reprobateT21)

                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = subTotalPdT21.toInt(),
                            reprobate = subTotalPdT22.toInt()
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etApprovedT22.run {
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
                        s.isEmpty() -> approvedT22 = 0
                        s.isNotEmpty() -> approvedT22 = text.toString().toInt()
                    }

                    subTotalPdT22 = calculateSubTask(22, approvedT22, reprobateT22)

                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = subTotalPdT21.toInt(),
                            reprobate = subTotalPdT22.toInt()
                        )
                    ) {
                        resolver.totalPdTask2 = this
                        tvSubTotalT2.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT22.run {
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
                        s.isEmpty() -> reprobateT22 = 0
                        s.isNotEmpty() -> reprobateT22 = text.toString().toInt()
                    }
                    subTotalPdT22 = calculateSubTask(22, approvedT22, reprobateT22)

                    with(
                        resolver.calculateTask(
                            nTask = 2,
                            approved = subTotalPdT21.toInt(),
                            reprobate = subTotalPdT22.toInt()
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

        etApprovedT31.run {
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
                        s.isEmpty() -> approvedT31 = 0
                        s.isNotEmpty() -> approvedT31 = text.toString().toInt()
                    }

                    subTotalPdT31 = calculateSubTask(31, approvedT31, reprobateT31)

                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = subTotalPdT31.toInt(),
                            reprobate = subTotalPdT32.toInt()
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT31.run {
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
                        s.isEmpty() -> reprobateT31 = 0
                        s.isNotEmpty() -> reprobateT31 = text.toString().toInt()
                    }
                    subTotalPdT31 = calculateSubTask(31, approvedT31, reprobateT31)

                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = subTotalPdT31.toInt(),
                            reprobate = subTotalPdT32.toInt()
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etApprovedT32.run {
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
                        s.isEmpty() -> approvedT32 = 0
                        s.isNotEmpty() -> approvedT32 = text.toString().toInt()
                    }

                    subTotalPdT32 = calculateSubTask(32, approvedT32, reprobateT32)

                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = subTotalPdT31.toInt(),
                            reprobate = subTotalPdT32.toInt()
                        )
                    ) {
                        resolver.totalPdTask3 = this
                        tvSubTotalT3.text = formatSubTotalPoints(task, this)
                    }
                    calculateResult()
                }
            })
        }

        etReprobateT32.run {
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
                        s.isEmpty() -> reprobateT32 = 0
                        s.isNotEmpty() -> reprobateT32 = text.toString().toInt()
                    }
                    subTotalPdT32 = calculateSubTask(32, approvedT32, reprobateT32)

                    with(
                        resolver.calculateTask(
                            nTask = 3,
                            approved = subTotalPdT31.toInt(),
                            reprobate = subTotalPdT32.toInt()
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

    /**
     * Calculate SubTask for task 2 & 3
     */
    private fun calculateSubTask(
        subTask: Int,
        approved: Int,
        reprobate: Int
    ): Double {
        return when (subTask) {
            //Tarea 2_1 items 1-5
            21 -> (approved - reprobate).toDouble()

            //Tarea 2_2 items 6-9
            22 -> approved - reprobate / 2.0

            //Tarea 3_1 items 1-9
            31 -> approved - reprobate / 3.0

            //Tarea 3_1 items 10-14
            32 -> (approved - reprobate).toDouble()
            else -> 0.0
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