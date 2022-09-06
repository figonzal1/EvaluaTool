/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 06-09-22 17:37
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3.adaptacionFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utils.EvaluaUtils

class FragmentStateAdapterE9M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AdaptacionPersonalFragmentE9M3.newInstance()
            1 -> AdaptacionFamiliarFragmentE9M3.newInstance()
            2 -> AdaptacionEscolarFragmentE9M3.newInstance()
            else -> HabilidadesSocialesFragmentE9M3.newInstance()
        }
    }

    override fun getItemCount() = tabsArray.size

    companion object {
        val tabsArray = listOf(
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_PERSONAL),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_FAMILIAR),
            EvaluaUtils.get(R.string.TOOLBAR_ADAP_ESCOLAR),
            EvaluaUtils.get(R.string.TOOLBAR_HAB_SOCIALES)
        )
    }
}