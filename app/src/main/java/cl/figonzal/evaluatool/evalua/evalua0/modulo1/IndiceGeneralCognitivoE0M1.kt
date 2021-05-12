/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12-05-21 01:13
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralCognitivoE0M1Binding
import cl.figonzal.evaluatool.interfaces.IndiceValorInterface
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.math.roundToInt

class IndiceGeneralCognitivoE0M1 : AppCompatActivity(), IndiceValorInterface {

    private lateinit var binding: ActivityIndiceGeneralCognitivoE0M1Binding

    //TAREA 1
    private lateinit var etTotalesT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    //TAREA 2
    private lateinit var etTotalesT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var subTotalT2 = 0.0

    //TAREA 3
    private lateinit var etTotalesT3: TextInputEditText
    private lateinit var tvSubTotalT3: TextView
    private var subTotalT3 = 0.0

    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndiceGeneralCognitivoE0M1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_INDICE_GENERAL_COGNITIVO, binding.include.toolbar)

        initResources()
    }

    private fun initResources() {

        with(binding, {
            this@IndiceGeneralCognitivoE0M1.etTotalesT1 = etTotalesT1
            this@IndiceGeneralCognitivoE0M1.etTotalesT2 = etTotalesT2
            this@IndiceGeneralCognitivoE0M1.etTotalesT3 = etTotalesT3

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            tvSubTotalT2 = tvPdSubtotalT2
            tvSubTotalT3 = tvPdSubtotalT3

            //TOTAL
            this@IndiceGeneralCognitivoE0M1.tvPdTotal = tvPdTotalValue
        }).also {
            textWatcherTarea1()
        }
    }

    private fun textWatcherTarea1() {

        with(etTotalesT1) {
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
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." -> {
                            subTotalT1 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT1.text =
                        String.format(getString(R.string.POINTS_FORMAT), "CA: ", subTotalT1)
                    calculateResult()
                }
            })
        }

        with(etTotalesT2) {
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
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." -> {
                            subTotalT2 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT2.text =
                        String.format(getString(R.string.POINTS_FORMAT), "SE: ", subTotalT2)
                    calculateResult()
                }
            })
        }

        with(etTotalesT3) {
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
                        s.isNotEmpty() && s.toString() != "-" && s.toString() != "." -> {
                            subTotalT3 = text.toString().toDouble()
                        }
                    }
                    tvSubTotalT3.text = String.format(
                        Locale.US,
                        getString(R.string.POINTS_FORMAT),
                        "OP: ",
                        subTotalT3
                    )
                    calculateResult()
                }
            })
        }
    }

    override fun calculateResult() {
        //TOTALES
        var totalPd = (subTotalT1 + subTotalT2 + subTotalT3) / 3.0
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = String.format(getString(R.string.POINTS_FORMAT), totalPd)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}