/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:18
 */
package cl.figonzal.evaluatool.evalua.evalua7

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.HeaderAdapter
import cl.figonzal.evaluatool.databinding.ActivityEvalua7Binding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.model.Header
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.configureFabWsp
import timber.log.Timber

class Evalua7Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_7, binding.includeToolbar.materialToolbar)
        configureFabWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_7_MODULO_1)),
            Header(getString(R.string.EVALUA_7_MODULO_2)),
            Header(getString(R.string.EVALUA_7_MODULO_3)),
            Header(getString(R.string.EVALUA_7_MODULO_4)),
            Header(getString(R.string.EVALUA_7_MODULO_5)),
            Header(getString(R.string.EVALUA_7_MODULO_6))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_7_M1_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_7_M2_SI_1)),
                Child(getString(R.string.EVALUA_7_M2_SI_2)),
                Child(getString(R.string.EVALUA_7_M2_SI_3))
            ),
            listOf(
                Child(getString(R.string.EVALUA_7_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_7_M4_SI_1)),
                Child(getString(R.string.EVALUA_7_M4_SI_2)),
                Child(getString(R.string.EVALUA_7_M4_SI_3))
            ),
            listOf(
                Child(getString(R.string.EVALUA_7_M5_SI_1)),
                Child(getString(R.string.EVALUA_7_M5_SI_2)),
                Child(getString(R.string.EVALUA_7_M5_SI_3))
            ),
            listOf(
                Child(getString(R.string.EVALUA_7_M6_SI_1)),
                Child(getString(R.string.EVALUA_7_M6_SI_2))
            )
        )

        binding.rv7.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua7),
                headers,
                subItemsList,
                this@Evalua7Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua7Activity)
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
}