/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 06-09-22 17:37
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo4.velocidadFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utils.EvaluaUtils

class FragmentStateAdapterE8M4(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VelocidadFragmentE8M4.newInstance()
            else -> ComprensionFragmentE8M4.newInstance()
        }
    }

    override fun getItemCount() = tabsArray.size

    companion object {
        val tabsArray = listOf(
            EvaluaUtils.get(R.string.TOOLBAR_VELOCIDAD),
            EvaluaUtils.get(R.string.TOOLBAR_COMPRENSION)
        )
    }
}