/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-04-21 17:31
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.Utils

class FragmentStateAdapterE1M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> MotivacionFragmentE1M3.newInstance()
            1 -> AutoControlFragmentE1M3.newInstance()
            2 -> ConductaProSocialE1M3.newInstance()
            else -> AutoEstimaFragmentE1M3.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
                Utils.get(R.string.TOOLBAR_MOTIVACION),
                Utils.get(R.string.TOOLBAR_AUTOCONTROL),
                Utils.get(R.string.TOOLBAR_CONDUCTAS_PROSOCIALES),
                Utils.get(R.string.TOOLBAR_AUTOESTIMA)
        )
    }
}