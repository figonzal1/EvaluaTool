/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 06-09-22 17:37
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE9M3Binding
import cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3.adaptacionFragment.FragmentStateAdapterE9M3
import cl.figonzal.evaluatool.utils.configureActionBar
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE9M3 : AppCompatActivity() {

    private lateinit var binding: ActivityNivelesAdaptacionE9M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityNivelesAdaptacionE9M3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        configureActionBar(
            R.string.TOOLBAR_NIVELES_ADAPTACION,
            binding.includeToolbar.materialToolbar
        )

        //View pager
        binding.viewPagerNivelesAdaptacion.adapter =
            FragmentStateAdapterE9M3(this@NivelesAdaptacionE9M3)
        setTabs()

    }

    private fun setTabs() {

        with(binding) {

            //TabLayout
            TabLayoutMediator(
                includeTablayout.tabsLayoutNivelesAdaptacion,
                viewPagerNivelesAdaptacion
            ) { tab, position ->
                tab.text = FragmentStateAdapterE9M3.tabsArray[position]
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