/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 28/2/22 1:24
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua2.modulo5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityValoracionGlobalEscrituraE2M5Binding
import cl.figonzal.evaluatool.domain.IndiceValorInterface
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.formatResult
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.roundToInt

class ValoracionGlobalEscrituraE2M5 : AppCompatActivity(), IndiceValorInterface {

    private lateinit var binding: ActivityValoracionGlobalEscrituraE2M5Binding

    //TAREA 1
    private lateinit var etTotalsT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    //TAREA 2
    private lateinit var etTotalsT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var subTotalT2 = 0.0

    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityValoracionGlobalEscrituraE2M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_VALORACION_GLOBAL,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {
            this@ValoracionGlobalEscrituraE2M5.etTotalsT1 = etTotalesT1
            this@ValoracionGlobalEscrituraE2M5.etTotalsT2 = etTotalesT2

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            tvSubTotalT2 = tvPdSubtotalT2
            //TOTAL
            this@ValoracionGlobalEscrituraE2M5.tvPdTotal = tvPdTotalValue
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

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT1 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT1 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT1.text = formatResult(R.string.POINTS_FORMAT, "GR:", subTotalT1)
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

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT2 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT2 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT2.text = formatResult(R.string.POINTS_FORMAT, "OR:", subTotalT2)
                    calculateResult()
                }
            })
        }

    }

    override fun calculateResult() {
        //TOTALES
        var totalPd = (subTotalT1 + subTotalT2) / 2.0
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, totalPd)
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