/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:17
 */
package cl.figonzal.evaluatool.evalua.evalua2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.HeaderAdapter
import cl.figonzal.evaluatool.databinding.ActivityEvalua2Binding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.model.Header
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.configureFabWsp
import timber.log.Timber
import java.util.*

class Evalua2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_2, binding.includeToolbar.materialToolbar)
        configureFabWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_2_MODULO_1)),
            Header(getString(R.string.EVALUA_2_MODULO_2)),
            Header(getString(R.string.EVALUA_2_MODULO_3)),
            Header(getString(R.string.EVALUA_2_MODULO_4)),
            Header(getString(R.string.EVALUA_2_MODULO_5)),
            Header(getString(R.string.EVALUA_2_MODULO_6)),
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_2_M1_SI_1)),
                Child(getString(R.string.EVALUA_2_M1_SI_2)),
                Child(getString(R.string.EVALUA_2_M1_SI_3)),
                Child(getString(R.string.EVALUA_2_VALORACION_GLOBAL_RAZONAMIENTO)),
                Child(getString(R.string.EVALUA_2_INDICE_GENERAL_COGNITIVO))
            ),
            listOf(
                Child(getString(R.string.EVALUA_2_M2_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_2_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_2_M4_SI_1)),
                Child(getString(R.string.EVALUA_2_VALORACION_GLOBAL_LECTURA)),
                Child(getString(R.string.EVALUA_2_INDICE_GENERAL_LECTURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_2_M5_SI_1)),
                Child(getString(R.string.EVALUA_2_VALORACION_GLOBAL_ESCRITURA)),
                Child(getString(R.string.EVALUA_2_INDICE_GENERAL_ESCRITURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_2_M6_SI_1)),
                Child(getString(R.string.EVALUA_2_M6_SI_2)),
                Child(getString(R.string.EVALUA_2_VALORACION_GLOBAL_MATEMATICA)),
                Child(getString(R.string.EVALUA_2_INDICE_GENERAL_MATEMATICO))
            )
        )

        //Recycler view
        binding.rv2.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua2),
                headers,
                subItemsList,
                applicationContext,
                this@Evalua2Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua2Activity)
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