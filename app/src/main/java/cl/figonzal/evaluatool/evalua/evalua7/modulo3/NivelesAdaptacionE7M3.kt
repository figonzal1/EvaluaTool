/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 22:23
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE7M3Binding
import cl.figonzal.evaluatool.evalua.evalua7.modulo3.adaptacionFragments.FragmentStateAdapterE7M3
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NivelesAdaptacionE7M3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityNivelesAdaptacionE7M3Binding.inflate(layoutInflater), {
            setContentView(root)

            configActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, includeToolbar.materialToolbar)

            //View pager
            viewPagerNivelesAdaptacion.apply {
                adapter = FragmentStateAdapterE7M3(this@NivelesAdaptacionE7M3)

                TabLayoutMediator(
                    includeTablayout.tabsNivelesAdaptacion,
                    this
                ) { tab: TabLayout.Tab, position: Int ->
                    tab.text = FragmentStateAdapterE7M3.tabs[position]
                }.attach()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}