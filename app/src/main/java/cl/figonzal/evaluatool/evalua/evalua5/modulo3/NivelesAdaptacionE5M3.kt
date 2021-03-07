/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-03-21 0:23
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityNivelesAdaptacionE5M3Binding
import cl.figonzal.evaluatool.evalua.evalua5.modulo3.adaptacionFragments.FragmentStateAdapterE5M3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class NivelesAdaptacionE5M3 : AppCompatActivity() {
    private lateinit var binding: ActivityNivelesAdaptacionE5M3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNivelesAdaptacionE5M3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_NIVELES_ADAPTACION)

        //View pager
        val viewPager2 = binding.viewPagerNivelesAdaptacion
        viewPager2.adapter = FragmentStateAdapterE5M3(this, this)

        //TabLayout
        val tabLayout = binding.tabsNivelesAdaptacion
        TabLayoutMediator(tabLayout, viewPager2) { tab: TabLayout.Tab, position: Int -> tab.text = FragmentStateAdapterE5M3.tabs[position] }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}