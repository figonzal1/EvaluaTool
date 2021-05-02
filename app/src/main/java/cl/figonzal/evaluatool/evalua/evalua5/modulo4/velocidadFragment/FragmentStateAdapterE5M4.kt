/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-05-21 16:07
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4.velocidadFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.Utils

class FragmentStateAdapterE5M4(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VelocidadFragmentE5M4.newInstance()
            else -> ComprensionFragmentE5M4.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
                Utils.get(R.string.TOOLBAR_VELOCIDAD),
                Utils.get(R.string.TOOLBAR_COMPRENSION)
        )
    }
}