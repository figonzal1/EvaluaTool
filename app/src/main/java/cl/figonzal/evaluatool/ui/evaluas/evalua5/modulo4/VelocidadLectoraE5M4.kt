/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 06-09-22 17:37
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE5M4Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua5.modulo4.velocidadFragment.FragmentStateAdapterE5M4
import cl.figonzal.evaluatool.utils.configureActionBar
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class VelocidadLectoraE5M4 : AppCompatActivity() {

    private lateinit var binding: ActivityVelocidadLectoraE5M4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityVelocidadLectoraE5M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            configureActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.adapter = FragmentStateAdapterE5M4(this@VelocidadLectoraE5M4)
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
                tab.text = FragmentStateAdapterE5M4.tabsArray[position]
            }.attach()
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