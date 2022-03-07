/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 05-03-22 22:12
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE1M3Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo3.adaptacionFragments.FragmentStateAdapterE1M3
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.setTabWidthAsWrapContent
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE1M3 : AppCompatActivity() {

    private lateinit var binding: ActivityNivelesAdaptacionE1M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityNivelesAdaptacionE1M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            configureActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, includeToolbar.materialToolbar)

            //View pager
            viewPagerNivelesAdaptacion.adapter =
                FragmentStateAdapterE1M3(this@NivelesAdaptacionE1M3)
            setTabs()
        }
    }

    private fun setTabs() {

        with(binding) {

            //TabLayout
            TabLayoutMediator(
                includeTablayout.tabsLayoutNivelesAdaptacion,
                viewPagerNivelesAdaptacion
            ) { tab, position ->
                tab.text = FragmentStateAdapterE1M3.tabsArray[position]

                when (position) {
                    0 -> tab.setIcon(R.drawable.ic_baseline_campaign_24)
                }
            }.attach()

            includeTablayout.tabsLayoutNivelesAdaptacion.setTabWidthAsWrapContent(0)
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