/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 20:51
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralCognitivoE2M1Binding
import cl.figonzal.evaluatool.domain.IndiceValorInterface
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.formatResult
import cl.figonzal.evaluatool.utils.setIndexAnimation
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.roundToInt

class IndiceGeneralCognitivoE2M1 : AppCompatActivity(), IndiceValorInterface {

    private lateinit var binding: ActivityIndiceGeneralCognitivoE2M1Binding

    //TAREA 1
    private lateinit var etTotalsT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    //TAREA 2
    private lateinit var etTotalsT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var subTotalT2 = 0.0

    //TAREA 3
    private lateinit var etTotalsT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var subTotalT3 = 0.0
    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityIndiceGeneralCognitivoE2M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_INDICE_GENERAL_COGNITIVO,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {
            this@IndiceGeneralCognitivoE2M1.etTotalsT1 = etTotalesT1
            this@IndiceGeneralCognitivoE2M1.etTotalsT2 = etTotalesT2
            this@IndiceGeneralCognitivoE2M1.etTotalsT3 = etTotalesT3

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            tvSubTotalT2 = tvPdSubtotalT2
            tvSubTotalT3 = tvPdSubtotalT3
            //TOTAL
            this@IndiceGeneralCognitivoE2M1.tvPdTotal = tvPdTotalValue
        }.also {
            textWatcherTask1()
        }
    }

    private fun textWatcherTask1() {

        etTotalsT1.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalT1 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //Not used
                }

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT1 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT1 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT1.text = formatResult(R.string.POINTS_FORMAT, "PA:", subTotalT1)
                    calculateResult()
                }
            })
        }

        etTotalsT2.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalT2 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //Not used
                }

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT2 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT2 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT2.text = formatResult(R.string.POINTS_FORMAT, "CA:", subTotalT2)
                    calculateResult()
                }
            })
        }

        etTotalsT3.run {
            addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    subTotalT3 = 0.0
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //Not used
                }

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT3 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT3 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT3.text = formatResult(R.string.POINTS_FORMAT, "OP:", subTotalT3)
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

    override fun calculateResult() {
        var totalPd = (subTotalT1 + subTotalT2 + subTotalT3) / 3.0
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, totalPd)

        binding.tvPdTotalValue.background = setIndexAnimation(totalPd)
    }
}