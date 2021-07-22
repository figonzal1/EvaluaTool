/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:53
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilities.EvaluaUtils

class FragmentStateAdapterE8M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AdaptacionPersonalFragmentE8M3.newInstance()
            1 -> AdaptacionFamiliarFragmentE8M3.newInstance()
            2 -> AdaptacionEscolarFragmentE8M3.newInstance()
            3 -> HabilidadesSocialesFragmentE8M3.newInstance()
            else -> HabilidadesSocialesFragmentE8M3.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_PERSONAL),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_FAMILIAR),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_ESCOLAR),
            EvaluaUtils.get(R.string.TOOLBAR_HAB_SOCIALES)
        )
    }
}