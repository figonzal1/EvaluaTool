/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2024

 Last modified 09-11-24, 20:50
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua3

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
import timber.log.Timber

class Evalua3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEvaluaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityEvaluaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_3, binding.includeToolbar.materialToolbar)

        val headers = listOf(
            Header(getString(R.string.EVALUA_3_MODULO_1)),
            Header(getString(R.string.EVALUA_3_MODULO_2)),
            Header(getString(R.string.EVALUA_3_MODULO_3)),
            Header(getString(R.string.EVALUA_3_MODULO_4)),
            Header(getString(R.string.EVALUA_3_MODULO_5)),
            Header(getString(R.string.EVALUA_3_MODULO_6))
        )

        val subItemsList = listOf(
            listOf(
                Child(getString(R.string.EVALUA_3_M1_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_3_M2_SI_1)),
                Child(getString(R.string.EVALUA_3_M2_SI_2)),
                Child(getString(R.string.EVALUA_3_M2_SI_3)),
                Child(getString(R.string.EVALUA_3_VALORACION_GLOBAL_RAZONAMIENTO))
            ),
            listOf(
                Child(getString(R.string.EVALUA_3_M3_SI_1))
            ),
            listOf(
                Child(getString(R.string.EVALUA_3_M4_SI_1)),
                Child(getString(R.string.EVALUA_3_M4_SI_2)),
                Child(getString(R.string.EVALUA_3_VALORACION_GLOBAL_LECTURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_3_M5_SI_1)),
                Child(getString(R.string.EVALUA_3_M5_SI_2)),
                Child(getString(R.string.EVALUA_2_VALORACION_GLOBAL_ESCRITURA))
            ),
            listOf(
                Child(getString(R.string.EVALUA_3_M6_SI_1)),
                Child(getString(R.string.EVALUA_3_M6_SI_2)),
                Child(getString(R.string.EVALUA_3_VALORACION_GLOBAL_MATEMATICA))
            )
        )

        binding.rv.apply {
            adapter = HeaderAdapter(
                getString(R.string.routeMapEvalua3),
                headers,
                subItemsList,
                this@Evalua3Activity
            )
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@Evalua3Activity)
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