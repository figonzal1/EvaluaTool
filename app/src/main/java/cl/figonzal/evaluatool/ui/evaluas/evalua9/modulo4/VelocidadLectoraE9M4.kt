/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 25-05-22 23:57
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE9M4Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.velocidadFragments.FragmentStateAdapterE9M4
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.setTabWidthAsWrapContent
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class VelocidadLectoraE9M4 : AppCompatActivity() {

    private lateinit var binding: ActivityVelocidadLectoraE9M4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityVelocidadLectoraE9M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            configureActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.adapter = FragmentStateAdapterE9M4(this@VelocidadLectoraE9M4)
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
                tab.text = FragmentStateAdapterE9M4.tabsArray[position]

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