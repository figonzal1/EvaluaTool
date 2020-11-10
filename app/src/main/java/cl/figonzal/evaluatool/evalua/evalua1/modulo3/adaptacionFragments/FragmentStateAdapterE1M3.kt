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
 * Last modified 10-11-20 17:28
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo3.adaptacionFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentStateAdapterE1M3(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {

        var f = Fragment()
        when (position) {
            0 -> f = MotivacionFragmentE1M3.newInstance()
            1 -> f = AutoControlFragmentE1M3.newInstance()
            2 -> f = ConductaProSocialE1M3.newInstance()
            3 -> f = AutoEstimaFragmentE1M3.newInstance()
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
        tabs[0] = "Motivación"
        tabs[1] = "Autocontrol"
        tabs[2] = "Conductas Pro-sociales"
        tabs[3] = "Autoestima"
    }
}