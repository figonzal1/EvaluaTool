/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:06
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE1M3Binding
import cl.figonzal.evaluatool.evalua.evalua1.modulo3.adaptacionFragments.FragmentStateAdapterE1M3
import cl.figonzal.evaluatool.utilities.configureActionBar
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE1M3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityNivelesAdaptacionE1M3Binding.inflate(layoutInflater)) {

            setContentView(root)

            configureActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, includeToolbar.materialToolbar)

            //View pager
            viewPagerNivelesAdaptacion.apply {
                adapter = FragmentStateAdapterE1M3(this@NivelesAdaptacionE1M3)

                //TabLayout
                TabLayoutMediator(includeTablayout.tabsNivelesAdaptacion, this) { tab, position ->
                    tab.text = FragmentStateAdapterE1M3.tabs[position]
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