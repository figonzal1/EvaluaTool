/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 30-04-21 19:58
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE4M4Binding
import cl.figonzal.evaluatool.evalua.evalua4.modulo4.velodadFragments.FragmentStateAdapterE4M4
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class VelocidadLectoraE4M4 : AppCompatActivity() {

    private lateinit var binding: ActivityVelocidadLectoraE4M4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVelocidadLectoraE4M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, binding.include.toolbar)

        //View pager
        binding.viewPagerVelocidad.apply {
            adapter = FragmentStateAdapterE4M4(this@VelocidadLectoraE4M4)

            TabLayoutMediator(binding.tabsVelocidad, this) { tab: TabLayout.Tab, position: Int ->
                tab.text = FragmentStateAdapterE4M4.tabs[position]
            }.attach()

        }
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