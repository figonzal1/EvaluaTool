/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-02-21 19:46
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
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
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

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.setTitle(R.string.TOOLBAR_INDICE_GENERAL_COGNITIVO)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
    }

    private fun instanciarRecursosInterfaz() {
        etTotalesT1 = binding.etTotalesT1
        etTotalesT2 = binding.etTotalesT2
        etTotalesT3 = binding.etTotalesT3

        //SUBTOTAL
        tvSubTotalT1 = binding.tvPdSubtotalT1
        tvSubTotalT2 = binding.tvPdSubtotalT2
        tvSubTotalT3 = binding.tvPdSubtotalT3

        //TOTAL
        tvPdTotal = binding.tvPdTotalValue
    }

    private fun textWatcherTarea1() {

        etTotalesT1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subTotalT1 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    subTotalT1 = 0.0
                } else if (s.isNotEmpty() && s.toString() != "-" && s.toString() != ".") {
                    subTotalT1 = etTotalesT1.text.toString().toDouble()
                }
                tvSubTotalT1.text = String.format(Locale.US, "%s: %s pts", "CA", subTotalT1)
                calcularResultado()
            }
        })

        etTotalesT2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subTotalT2 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    subTotalT2 = 0.0
                } else if (s.isNotEmpty() && s.toString() != "-" && s.toString() != ".") {
                    subTotalT2 = etTotalesT2.text.toString().toDouble()
                }
                tvSubTotalT2.text = String.format(Locale.US, "%s: %s pts", "SE", subTotalT2)
                calcularResultado()
            }
        })

        etTotalesT3.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                subTotalT3 = 0.0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                if (s.isEmpty()) {
                    subTotalT3 = 0.0
                } else if (s.isNotEmpty() && s.toString() != "-" && s.toString() != ".") {
                    subTotalT3 = etTotalesT3.text.toString().toDouble()
                }
                tvSubTotalT3.text = String.format(Locale.US, "%s: %s pts", "OP", subTotalT3)
                calcularResultado()
            }
        })
    }

    override fun calcularResultado() {
        //TOTALES
        var totalPd = subTotalT1 + subTotalT2 + subTotalT3
        totalPd /= 3.0
        totalPd = (totalPd * 100.0).roundToInt() / 100.0
        tvPdTotal.text = String.format(Locale.US, "%s pts", totalPd)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}