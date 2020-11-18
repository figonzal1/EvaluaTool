/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 18-11-20 1:23
 */
package cl.figonzal.evaluatool.evalua.evalua5.modulo4.velocidadFragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.evalua.evalua7.modulo4.velocidadFragments.FragmentStateAdapterE7M4

class FragmentStateAdapterE5M4(context: Context, fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        var f = Fragment()
        when (position) {
            0 -> f = VelocidadFragmentE5M4.newInstance()
            1 -> f = ComprensionFragmentE5M4.newInstance()
        }
        return f
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = arrayOfNulls<String>(2)
    }

    init {
        FragmentStateAdapterE7M4.tabs[0] = context.getString(R.string.TOOLBAR_VELOCIDAD)
        FragmentStateAdapterE7M4.tabs[1] = context.getString(R.string.TOOLBAR_COMPRENSION)
    }
}