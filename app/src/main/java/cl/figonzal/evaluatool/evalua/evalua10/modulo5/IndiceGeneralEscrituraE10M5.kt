/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:06
 */

package cl.figonzal.evaluatool.evalua.evalua10.modulo5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralEscrituraE10M5Binding
import cl.figonzal.evaluatool.interfaces.IndiceValorInterface
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.formatResult
import cl.figonzal.evaluatool.utilities.setIndexAnimation
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.roundToInt

class IndiceGeneralEscrituraE10M5 : AppCompatActivity(), IndiceValorInterface {
    private lateinit var binding: ActivityIndiceGeneralEscrituraE10M5Binding

    //TAREA 1
    private lateinit var etTotalsT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndiceGeneralEscrituraE10M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_INDICE_GENERAL_ESCRITURA,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {
            this@IndiceGeneralEscrituraE10M5.etTotalsT1 = etTotalesT1

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            //TOTAL
            this@IndiceGeneralEscrituraE10M5.tvPdTotal = tvPdTotalValue
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
                    tvSubTotalT1.text = formatResult(R.string.POINTS_FORMAT, "OR:", subTotalT1)
                    calculateResult()
                }
            })
        }

    }

    override fun calculateResult() {
        //TOTALES
        var totalPd = subTotalT1
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