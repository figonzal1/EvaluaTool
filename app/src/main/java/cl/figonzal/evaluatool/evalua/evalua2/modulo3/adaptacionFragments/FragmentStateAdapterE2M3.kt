/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:53
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilities.EvaluaUtils

class FragmentStateAdapterE2M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> MotivacionFragmentE2M3.newInstance()
            1 -> AutoControlFragmentE2M3.newInstance()
            2 -> ConductaProSocialFragmentE2M3.newInstance()
            else -> AutoEstimaFragmentE2M3.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
            EvaluaUtils.get(R.string.TOOLBAR_MOTIVACION),
            EvaluaUtils.get(R.string.TOOLBAR_AUTOCONTROL),
            EvaluaUtils.get(R.string.TOOLBAR_CONDUCTAS_PROSOCIALES),
            EvaluaUtils.get(R.string.TOOLBAR_AUTOESTIMA)
        )
    }
}