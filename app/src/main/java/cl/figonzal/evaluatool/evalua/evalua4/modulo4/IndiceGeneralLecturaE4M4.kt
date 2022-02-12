/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:07
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralLecturaE4M4Binding
import cl.figonzal.evaluatool.interfaces.IndiceValorInterface
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.formatResult
import cl.figonzal.evaluatool.utilities.setIndexAnimation
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import kotlin.math.roundToInt

class IndiceGeneralLecturaE4M4 : AppCompatActivity(), IndiceValorInterface {
    private lateinit var binding: ActivityIndiceGeneralLecturaE4M4Binding

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
        binding = ActivityIndiceGeneralLecturaE4M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_INDICE_GENERAL_LECTURA,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding) {
            this@IndiceGeneralLecturaE4M4.etTotalsT1 = etTotalesT1
            this@IndiceGeneralLecturaE4M4.etTotalsT2 = etTotalesT2

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            tvSubTotalT2 = tvPdSubtotalT2
            //TOTAL
            this@IndiceGeneralLecturaE4M4.tvPdTotal = tvPdTotalValue
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
                    tvSubTotalT1.text = formatResult(R.string.POINTS_FORMAT, "CL:", subTotalT1)
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
                    tvSubTotalT2.text = formatResult(R.string.POINTS_FORMAT, "VL:", subTotalT2)
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