/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 23:32
 */

package cl.figonzal.evaluatool.evalua.evalua4.modulo5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityIndiceGeneralEscrituraE4M5Binding
import cl.figonzal.evaluatool.interfaces.IndiceValorInterface
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt

class IndiceGeneralEscrituraE4M5 : AppCompatActivity(), IndiceValorInterface {
    private lateinit var binding: ActivityIndiceGeneralEscrituraE4M5Binding

    //TAREA 1
    private lateinit var etTotalesT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndiceGeneralEscrituraE4M5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(
            R.string.TOOLBAR_INDICE_GENERAL_ESCRITURA,
            binding.includeToolbar.materialToolbar
        )

        initResources()
    }

    private fun initResources() {

        with(binding, {
            this@IndiceGeneralEscrituraE4M5.etTotalesT1 = etTotalesT1

            //SUBTOTAL
            tvSubTotalT1 = tvPdSubtotalT1
            //TOTAL
            this@IndiceGeneralEscrituraE4M5.tvPdTotal = tvPdTotalValue
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
                        String.format(getString(R.string.POINTS_FORMAT), "OR: ", subTotalT1)
                    calculateResult()
                }
            })
        }

    }

    override fun calculateResult() {
        //TOTALES
        var totalPd = subTotalT1
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = String.format(getString(R.string.POINTS_SIMPLE_FORMAT), totalPd)
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