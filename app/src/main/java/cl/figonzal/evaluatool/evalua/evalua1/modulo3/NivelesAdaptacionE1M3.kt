/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-04-21 17:31
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE1M3Binding
import cl.figonzal.evaluatool.evalua.evalua1.modulo3.adaptacionFragments.FragmentStateAdapterE1M3
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayoutMediator

class NivelesAdaptacionE1M3 : AppCompatActivity() {

    private lateinit var binding: ActivityNivelesAdaptacionE1M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNivelesAdaptacionE1M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        configActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, binding.include.toolbar)

        //View pager
        binding.viewPagerNivelesAdaptacion.apply {
            adapter = FragmentStateAdapterE1M3(this@NivelesAdaptacionE1M3)

            //TabLayout
            TabLayoutMediator(binding.tabsNivelesAdaptacion, this) { tab, position ->
                tab.text = FragmentStateAdapterE1M3.tabs[position]
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