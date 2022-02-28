/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 23:54
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua0

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityEvalua0Binding
import cl.figonzal.evaluatool.domain.model.Child
import cl.figonzal.evaluatool.domain.model.Header
import cl.figonzal.evaluatool.ui.adapter.HeaderAdapter
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.configureFABWsp
import timber.log.Timber

class Evalua0Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua0Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_0, binding.includeToolbar.materialToolbar)
        configureFABWsp(binding.fabWsp)

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

        binding.rv0.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua0),
                headers,
                subItemsList,
                this@Evalua0Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua0Activity)
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