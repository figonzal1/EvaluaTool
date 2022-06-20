/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 00:51
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4.velocidadFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.ui.AdMobFragment
import cl.figonzal.evaluatool.utils.EvaluaUtils

class FragmentStateAdapterE9M4(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AdMobFragment.newInstance()
            1 -> VelocidadFragmentE9M4.newInstance()
            2 -> ComprensionFragmentE9M4.newInstance()
            else -> AdMobFragment.newInstance()
        }
    }

    override fun getItemCount() = tabsArray.size

    companion object {
        val tabsArray = listOf(
            "",
            EvaluaUtils.get(R.string.TOOLBAR_VELOCIDAD),
            EvaluaUtils.get(R.string.TOOLBAR_COMPRENSION)
        )
    }
}