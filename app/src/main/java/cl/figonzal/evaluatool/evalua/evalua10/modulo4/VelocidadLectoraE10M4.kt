/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 22:23
 */

package cl.figonzal.evaluatool.evalua.evalua10.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE10M4Binding
import cl.figonzal.evaluatool.evalua.evalua10.modulo4.velocidadFragments.FragmentStateAdapterE10M4
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class VelocidadLectoraE10M4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityVelocidadLectoraE10M4Binding.inflate(layoutInflater), {

            //Setcontent
            setContentView(root)

            //Config Action Bar
            configActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.apply {
                adapter = FragmentStateAdapterE10M4(this@VelocidadLectoraE10M4)

                TabLayoutMediator(
                    includeTablayout.tabsVelocidad,
                    this
                ) { tab: TabLayout.Tab, position: Int ->
                    tab.text = FragmentStateAdapterE10M4.tabs[position]
                }.attach()
            }
        })
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