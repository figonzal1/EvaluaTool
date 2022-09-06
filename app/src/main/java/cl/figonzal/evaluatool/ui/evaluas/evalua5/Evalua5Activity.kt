/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 06-09-22 17:37
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua5

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityEvaluaBinding
import cl.figonzal.evaluatool.domain.model.Child
import cl.figonzal.evaluatool.domain.model.Header
import cl.figonzal.evaluatool.ui.adapter.HeaderAdapter
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.configureFABWsp
import timber.log.Timber

class Evalua5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvaluaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityEvaluaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_5, binding.includeToolbar.materialToolbar)
        configureFABWsp(binding.fabWsp)

        val headers = listOf(
            Header(getString(R.string.EVALUA_5_MODULO_1)),
            Header(getString(R.string.EVALUA_5_MODULO_2)),
            Header(getString(R.string.EVALUA_5_MODULO_3)),
            Header(getString(R.string.EVALUA_5_MODULO_4)),
            Header(getString(R.string.EVALUA_5_MODULO_5)),
            Header(getString(R.string.EVALUA_5_MODULO_6))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_5_M1_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_5_M2_SI_1)),
                Child(getString(R.string.EVALUA_5_M2_SI_2)),
                Child(getString(R.string.EVALUA_5_M2_SI_3)),
                Child(getString(R.string.EVALUA_5_VALORACION_GLOBAL_RAZONAMIENTO))
            ),
            listOf(
                Child(getString(R.string.EVALUA_5_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_5_M4_SI_1)),
                Child(getString(R.string.EVALUA_5_M4_SI_2)),
                Child(getString(R.string.EVALUA_5_M4_SI_3)),
                Child(getString(R.string.EVALUA_5_VALORACION_GLOBAL_LECTURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_5_M5_SI_1)),
                Child(getString(R.string.EVALUA_5_M5_SI_2)),
                Child(getString(R.string.EVALUA_5_VALORACION_GLOBAL_ESCRITURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_5_M6_SI_1)),
                Child(getString(R.string.EVALUA_5_M6_SI_2)),
                Child(getString(R.string.EVALUA_5_VALORACION_GLOBAL_MATEMATICA))
            )
        )

        binding.rv.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua5),
                headers,
                subItemsList,
                this@Evalua5Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua5Activity)
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