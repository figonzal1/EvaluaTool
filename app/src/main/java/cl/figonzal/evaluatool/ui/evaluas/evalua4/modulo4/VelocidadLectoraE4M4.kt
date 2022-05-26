/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26-05-22 00:00
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE4M4Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo4.velodadFragments.FragmentStateAdapterE4M4
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.setTabWidthAsWrapContent
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class VelocidadLectoraE4M4 : AppCompatActivity() {

    private lateinit var binding: ActivityVelocidadLectoraE4M4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityVelocidadLectoraE4M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            configureActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.adapter = FragmentStateAdapterE4M4(this@VelocidadLectoraE4M4)
            setTabs()
        }
    }

    private fun setTabs() {
        with(binding) {

            //TabLayout
            TabLayoutMediator(
                includeTablayout.tabsVelocidad,
                viewPagerVelocidad
            ) { tab, position ->
                tab.text = FragmentStateAdapterE4M4.tabsArray[position]

                when (position) {
                    0 -> tab.setIcon(R.drawable.ic_round_campaign_24)
                }
            }.attach()

            includeTablayout.tabsVelocidad.setTabWidthAsWrapContent(0)
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