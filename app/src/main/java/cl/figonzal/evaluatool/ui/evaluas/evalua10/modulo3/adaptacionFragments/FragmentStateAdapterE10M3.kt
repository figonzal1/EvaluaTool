/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 00:57
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.ui.AdMobFragment
import cl.figonzal.evaluatool.utils.EvaluaUtils

class FragmentStateAdapterE10M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AdMobFragment.newInstance()
            1 -> AdaptacionPersonalFragmentE10M3.newInstance()
            2 -> AdaptacionFamiliarFragmentE10M3.newInstance()
            3 -> AdaptacionEscolarFragmentE10M3.newInstance()
            4 -> HabilidadesSocialesFragmentE10M3.newInstance()
            else -> AdMobFragment.newInstance()
        }
    }

    override fun getItemCount() = tabsArray.size

    companion object {
        val tabsArray = listOf(
            "",
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_PERSONAL),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_FAMILIAR),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_ESCOLAR),
            EvaluaUtils.get(R.string.TOOLBAR_HAB_SOCIALES)
        )
    }
}