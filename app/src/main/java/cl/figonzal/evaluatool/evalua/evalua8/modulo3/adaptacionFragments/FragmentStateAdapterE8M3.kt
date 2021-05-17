/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-05-21 02:31
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.Utils

class FragmentStateAdapterE8M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
            }
            1
            -> {
            }
            2
            -> {
            }
            3
            -> {
            }
            else -> {
            }
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
            Utils.get(R.string.TOOLBAR_ADAP_PERSONAL),
            Utils.get(R.string.TOOLBAR_ADAP_FAMILIAR),
            Utils.get(R.string.TOOLBAR_ADAP_ESCOLAR),
            Utils.get(R.string.TOOLBAR_HAB_SOCIALES)
        )
    }
}