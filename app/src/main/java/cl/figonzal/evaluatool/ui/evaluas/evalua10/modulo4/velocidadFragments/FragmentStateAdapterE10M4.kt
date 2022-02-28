/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26/2/22 23:19
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo4.velocidadFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utils.EvaluaUtils

class FragmentStateAdapterE10M4(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VelocidadFragmentE10M4.newInstance()
            1 -> ComprensionFragmentE10M4.newInstance()
            else -> ComprensionFragmentE10M4.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = listOf(
            EvaluaUtils.get(R.string.TOOLBAR_VELOCIDAD),
            EvaluaUtils.get(R.string.TOOLBAR_COMPRENSION)
        )
    }
}