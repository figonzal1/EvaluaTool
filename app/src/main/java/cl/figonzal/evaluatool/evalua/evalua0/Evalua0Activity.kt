/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:17
 */
package cl.figonzal.evaluatool.evalua.evalua0

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.HeaderAdapter
import cl.figonzal.evaluatool.databinding.ActivityEvalua0Binding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.model.Header
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.configureFabWsp
import timber.log.Timber

class Evalua0Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua0Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_0, binding.includeToolbar.materialToolbar)
        configureFabWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_0_MODULO_1)),
            Header(getString(R.string.EVALUA_0_MODULO_2)),
            Header(getString(R.string.EVALUA_0_MODULO_3))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_0_M1_SI_1)),
                Child(getString(R.string.EVALUA_0_M1_SI_2)),
                Child(getString(R.string.EVALUA_0_M1_SI_3)),
                Child(getString(R.string.EVALUA_0_M1_SI_4)),
                Child(getString(R.string.EVALUA_0_M1_SI_5)),
                Child(getString(R.string.EVALUA_0_M1_SI_6))
            ), listOf(
                Child(getString(R.string.EVALUA_0_M2_SI_1)),
                Child(getString(R.string.EVALUA_0_M2_SI_2)),
                Child(getString(R.string.EVALUA_0_M2_SI_3))
            ), listOf(
                Child(getString(R.string.EVALUA_0_M3_SI_1)),
                Child(getString(R.string.EVALUA_0_M3_SI_2)),
                Child(getString(R.string.EVALUA_0_M3_SI_3)),
                Child(getString(R.string.EVALUA_0_M3_SI_4)),
            )
        )

        binding.rv0.adapter = HeaderAdapter(headers, subItemsList, applicationContext, this)
        binding.rv0.setHasFixedSize(true)
        binding.rv0.layoutManager = LinearLayoutManager(this)
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