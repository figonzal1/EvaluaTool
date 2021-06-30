/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 13-06-21 16:33
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE9M4Binding
import cl.figonzal.evaluatool.evalua.evalua10.modulo4.velocidadFragments.FragmentStateAdapterE10M4
import cl.figonzal.evaluatool.evalua.evalua9.modulo4.velocidadFragments.FragmentStateAdapterE9M4
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class VelocidadLectoraE9M4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityVelocidadLectoraE9M4Binding.inflate(layoutInflater), {

            //Setcontent
            setContentView(root)

            //Config Action Bar
            configActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.apply {
                adapter = FragmentStateAdapterE9M4(this@VelocidadLectoraE9M4)

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