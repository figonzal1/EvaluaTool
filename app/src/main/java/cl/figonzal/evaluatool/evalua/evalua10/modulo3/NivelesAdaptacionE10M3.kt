/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 16:59
 */

package cl.figonzal.evaluatool.evalua.evalua10.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE10M3Binding
import cl.figonzal.evaluatool.evalua.evalua10.modulo3.adaptacionFragments.FragmentStateAdapterE10M3
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NivelesAdaptacionE10M3 : AppCompatActivity() {
    private lateinit var binding: ActivityNivelesAdaptacionE10M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNivelesAdaptacionE10M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_NIVELES_ADAPTACION, binding.include.materialToolbar)

        //View pager
        binding.viewPagerNivelesAdaptacion.apply {
            adapter = FragmentStateAdapterE10M3(this@NivelesAdaptacionE10M3)

            TabLayoutMediator(
                binding.tabsNivelesAdaptacion,
                this
            ) { tab: TabLayout.Tab, position: Int ->
                tab.text = FragmentStateAdapterE10M3.tabs[position]
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
