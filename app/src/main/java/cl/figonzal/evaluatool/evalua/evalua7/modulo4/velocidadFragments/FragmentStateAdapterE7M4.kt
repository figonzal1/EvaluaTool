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
 * Last modified 16-11-20 20:01
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo4.velocidadFragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R

class FragmentStateAdapterE7M4(context: Context, fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        var f = Fragment()
        when (position) {
            0 -> f = VelocidadFragmentE7M4.newInstance()
            1 -> f = ComprensionFragmentE7M4.newInstance()
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
        tabs[0] = context.getString(R.string.TOOLBAR_VELOCIDAD)
        tabs[1] = context.getString(R.string.TOOLBAR_COMPRENSION)
    }
}