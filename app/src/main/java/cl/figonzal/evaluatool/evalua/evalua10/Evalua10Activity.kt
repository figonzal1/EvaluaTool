/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:21
 */

package cl.figonzal.evaluatool.evalua.evalua10

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.HeaderAdapter
import cl.figonzal.evaluatool.databinding.ActivityEvalua10Binding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.model.Header
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.configureFabWsp
import timber.log.Timber

class Evalua10Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_10, binding.includeToolbar.materialToolbar)
        configureFabWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_10_MODULO_1)),
            Header(getString(R.string.EVALUA_10_MODULO_2)),
            Header(getString(R.string.EVALUA_10_MODULO_3)),
            Header(getString(R.string.EVALUA_10_MODULO_4)),
            Header(getString(R.string.EVALUA_10_MODULO_5)),
            Header(getString(R.string.EVALUA_10_MODULO_6))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_10_M1_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_10_M2_SI_1)),
                Child(getString(R.string.EVALUA_10_M2_SI_2)),
                Child(getString(R.string.EVALUA_10_M2_SI_3)),
                Child(getString(R.string.EVALUA_10_VALORACION_GLOBAL_RAZONAMIENTO)),
                Child(getString(R.string.EVALUA_10_INDICE_GENERAL_COGNITIVO))
            ),
            listOf(
                Child(getString(R.string.EVALUA_10_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_10_M4_SI_1)),
                Child(getString(R.string.EVALUA_10_M4_SI_2)),
                Child(getString(R.string.EVALUA_10_INDICE_GENERAL_LECTURA)),
            ),
            listOf(
                Child(getString(R.string.EVALUA_10_M5_SI_1)),
                Child(getString(R.string.EVALUA_10_INDICE_GENERAL_ESCRITURA)),
            ),
            listOf(
                Child(getString(R.string.EVALUA_10_M6_SI_1)),
                Child(getString(R.string.EVALUA_10_M6_SI_2)),
                Child(getString(R.string.EVALUA_10_VALORACION_GLOBAL_MATEMATICAS)),
                Child(getString(R.string.EVALUA_10_INDICE_GENERAL_MATEMATICAS)),
            )
        )

        binding.rv10.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua10),
                headers,
                subItemsList,
                this@Evalua10Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua10Activity)
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