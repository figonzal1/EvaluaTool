/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 25-05-22 23:57
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE6M3Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo3.adaptacionFragments.FragmentStateAdapterE6M3
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.setTabWidthAsWrapContent
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE6M3 : AppCompatActivity() {

    private lateinit var binding: ActivityNivelesAdaptacionE6M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityNivelesAdaptacionE6M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(
            R.string.TOOLBAR_NIVELES_ADAPTACION,
            binding.includeToolbar.materialToolbar
        )

        //View pager
        binding.viewPagerNivelesAdaptacion.adapter =
            FragmentStateAdapterE6M3(this@NivelesAdaptacionE6M3)
        setTabs()
    }

    private fun setTabs() {

        with(binding) {
            //TabLayout
            TabLayoutMediator(
                includeTablayout.tabsLayoutNivelesAdaptacion,
                viewPagerNivelesAdaptacion
            ) { tab, position ->
                tab.text = FragmentStateAdapterE6M3.tabsArray[position]

                when (position) {
                    0 -> tab.setIcon(R.drawable.ic_round_campaign_24)
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