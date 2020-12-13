/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 29-11-20 14:47
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo6

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.interfaces.IndiceValorInterface
import com.google.android.material.textfield.TextInputEditText
import timber.log.Timber
import java.util.*
import kotlin.math.roundToInt

class IndiceGeneralMatematicoE2M6 : AppCompatActivity(), IndiceValorInterface {

    //TAREA 1
    private lateinit var etTotalesT1: TextInputEditText
    private lateinit var tvSubTotalT1: TextView
    private var subTotalT1 = 0.0

    //TAREA 2
    private lateinit var etTotalesT2: TextInputEditText
    private lateinit var tvSubTotalT2: TextView
    private var subTotalT2 = 0.0
    private lateinit var tvPdTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indice_general_matematica_e2_m6)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.setTitle(R.string.TOOLBAR_INDICE_GENERAL_MATEMATICO)

        instanciarRecursosInterfaz()
        textWatcherTarea1()
    }

    private fun instanciarRecursosInterfaz() {
        etTotalesT1 = findViewById(R.id.et_totales_t1)
        etTotalesT2 = findViewById(R.id.et_totales_t2)

        //SUBTOTAL
        tvSubTotalT1 = findViewById(R.id.tv_pd_subtotal_t1)
        tvSubTotalT2 = findViewById(R.id.tv_pd_subtotal_t2)
        //TOTAL
        tvPdTotal = findViewById(R.id.tv_pd_total_value)
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
                tvSubTotalT1.text = String.format(Locale.US, "%s: %s pts", "CN", subTotalT1)
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
                tvSubTotalT2.text = String.format(Locale.US, "%s: %s pts", "RP", subTotalT2)
                calcularResultado()
            }
        })
    }

    override fun calcularResultado() {
        //TOTALES
        var totalPd = subTotalT1 + subTotalT2
        totalPd /= 2.0
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