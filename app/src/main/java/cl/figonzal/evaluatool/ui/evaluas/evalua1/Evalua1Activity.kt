/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 28/2/22 1:40
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityEvalua1Binding
import cl.figonzal.evaluatool.domain.model.Child
import cl.figonzal.evaluatool.domain.model.Header
import cl.figonzal.evaluatool.ui.adapter.HeaderAdapter
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.configureFABWsp
import timber.log.Timber

class Evalua1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvalua1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityEvalua1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_1, binding.includeToolbar.materialToolbar)
        configureFABWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_1_MODULO_1)),
            Header(getString(R.string.EVALUA_1_MODULO_2)),
            Header(getString(R.string.EVALUA_1_MODULO_3)),
            Header(getString(R.string.EVALUA_1_MODULO_4)),
            Header(getString(R.string.EVALUA_1_MODULO_5)),
            Header(getString(R.string.EVALUA_1_MODULO_6))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_1_M1_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_1_M2_SI_1)),
                Child(getString(R.string.EVALUA_1_M2_SI_2)),
                Child(getString(R.string.EVALUA_1_M2_SI_3)),
                Child(getString(R.string.EVALUA_1_VALORACION_BASES_RAZONAMIENTO))
            ),
            listOf(
                Child(getString(R.string.EVALUA_1_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_1_M4_SI_1)),
                Child(getString(R.string.EVALUA_1_M4_SI_2)),
                Child(getString(R.string.EVALUA_1_VALORACION_LECTURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_1_M5_SI_1)),
                Child(getString(R.string.EVALUA_1_M5_SI_2)),
                Child(getString(R.string.EVALUA_1_VALORACION_ESCRITURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_1_M6_SI_1))
            )
        )

        binding.rv1.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua1),
                headers,
                subItemsList,
                this@Evalua1Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua1Activity)
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