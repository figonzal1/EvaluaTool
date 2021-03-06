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
 * Last modified 16-11-20 19:10
 */
package cl.figonzal.evaluatool.evalua.evalua2.modulo3.adaptacionFragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cl.figonzal.evaluatool.R

class FragmentStateAdapterE2M3(context: Context, fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        var f = Fragment()
        when (position) {
            0 -> f = MotivacionFragmentE2M3.newInstance()
            1 -> f = AutoControlFragmentE2M3.newInstance()
            2 -> f = ConductaProSocialFragmentE2M3.newInstance()
            3 -> f = AutoEstimaFragmentE2M3.newInstance()
        }
        return f
    }

    override fun getItemCount(): Int {
        return tabs.size
    }

    companion object {
        val tabs = arrayOfNulls<String>(4)
    }

    init {
        tabs[0] = context.getString(R.string.TOOLBAR_MOTIVACION)
        tabs[1] = context.getString(R.string.TOOLBAR_AUTOCONTROL)
        tabs[2] = context.getString(R.string.TOOLBAR_CONDUCTAS_PROSOCIALES)
        tabs[3] = context.getString(R.string.TOOLBAR_AUTOESTIMA)
    }
}