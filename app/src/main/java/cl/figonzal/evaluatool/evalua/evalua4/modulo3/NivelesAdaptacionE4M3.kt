/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:07
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE4M3Binding
import cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments.FragmentStateAdapterE4M3
import cl.figonzal.evaluatool.utilities.configureActionBar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE4M3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityNivelesAdaptacionE4M3Binding.inflate(layoutInflater)) {

            setContentView(root)

            configureActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, includeToolbar.materialToolbar)

            //View pager
            viewPagerNivelesAdaptacion.apply {
                adapter = FragmentStateAdapterE4M3(this@NivelesAdaptacionE4M3)

                TabLayoutMediator(
                    includeTablayout.tabsNivelesAdaptacion,
                    this
                ) { tab: TabLayout.Tab, position: Int ->
                    tab.text = FragmentStateAdapterE4M3.tabs[position]
                }.attach()
            }
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