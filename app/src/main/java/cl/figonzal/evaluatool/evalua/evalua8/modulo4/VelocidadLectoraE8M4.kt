/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:06
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityVelocidadLectoraE8M4Binding
import cl.figonzal.evaluatool.evalua.evalua8.modulo4.velocidadFragments.FragmentStateAdapterE8M4
import cl.figonzal.evaluatool.utilities.configureActionBar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber

class VelocidadLectoraE8M4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityVelocidadLectoraE8M4Binding.inflate(layoutInflater)) {

            //Setcontent
            setContentView(root)

            //Config Action Bar
            configureActionBar(R.string.TOOLBAR_VELOCIDAD_LECTORA, includeToolbar.materialToolbar)

            //View pager
            viewPagerVelocidad.apply {
                adapter = FragmentStateAdapterE8M4(this@VelocidadLectoraE8M4)

                TabLayoutMediator(
                    includeTablayout.tabsVelocidad,
                    this
                ) { tab: TabLayout.Tab, position: Int ->
                    tab.text = FragmentStateAdapterE8M4.tabs[position]
                }.attach()
            }
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