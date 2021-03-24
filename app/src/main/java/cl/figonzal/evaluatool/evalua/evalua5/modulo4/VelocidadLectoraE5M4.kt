/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-03-21 0:23
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE5M4Binding
import cl.figonzal.evaluatool.evalua.evalua5.modulo4.velocidadFragment.FragmentStateAdapterE5M4
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class VelocidadLectoraE5M4 : AppCompatActivity() {

    private lateinit var binding: ActivityVelocidadLectoraE5M4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVelocidadLectoraE5M4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_VELOCIDAD_LECTORA)

        //View pager
        val viewPager2 = binding.viewPagerVelocidad
        viewPager2.adapter = FragmentStateAdapterE5M4(this, this)

        //TabLayout
        val tabLayout = binding.tabsVelocidad
        TabLayoutMediator(tabLayout, viewPager2) { tab: TabLayout.Tab, position: Int -> tab.text = FragmentStateAdapterE5M4.tabs[position] }.attach()
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