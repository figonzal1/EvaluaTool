/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 28/2/22 1:32
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralLinguisticoE0M3Binding
import cl.figonzal.evaluatool.domain.IndiceValorInterface
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.formatResult
import cl.figonzal.evaluatool.utils.setIndexAnimation
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.roundToInt

class IndiceGeneralLinguisticoE0M3 : AppCompatActivity(), IndiceValorInterface {

    private lateinit var binding: ActivityIndiceGeneralLinguisticoE0M3Binding

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
        binding = ActivityIndiceGeneralLinguisticoE0M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_INDICE_GENERAL_LINGUISTICO,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {
        with(binding) {
            this@IndiceGeneralLinguisticoE0M3.etTotalsT1 = etTotalesT1
            this@IndiceGeneralLinguisticoE0M3.etTotalsT2 = etTotalesT2
            this@IndiceGeneralLinguisticoE0M3.etTotalsT3 = etTotalesT3

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            tvSubTotalT2 = tvPdSubtotalT2
            tvSubTotalT3 = tvPdSubtotalT3
            //TOTAL
            this@IndiceGeneralLinguisticoE0M3.tvPdTotal = tvPdTotalValue
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
                    tvSubTotalT1.text =
                        formatResult(R.string.POINTS_FORMAT, "PF:", subTotalT1)
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
                    tvSubTotalT2.text =
                        formatResult(R.string.POINTS_FORMAT, "RA:", subTotalT2)
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

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {

                    when {
                        s.isEmpty() -> subTotalT3 = 0.0
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." && s.toString() != "-." -> {
                            subTotalT3 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT3.text =
                        formatResult(R.string.POINTS_FORMAT, "HF:", subTotalT3)
                    calculateResult()
                }
            })
        }
    }

    override fun calculateResult() {
        //TOTALES
        var totalPd = (subTotalT1 + subTotalT2 + subTotalT3) / 3.0
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = formatResult(R.string.POINTS_SIMPLE_FORMAT, totalPd)

        binding.tvPdTotalValue.background = setIndexAnimation(totalPd)
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