/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-07-21 15:33
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.preference.PreferenceManager
import cl.figonzal.evaluatool.R
import timber.log.Timber

class NightModeService(
    private val activity: Activity
) : DefaultLifecycleObserver {


    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        checkNightMode()
    }

    private fun checkNightMode() {

        //Leer preference settings
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val manualNightMode =
            sharedPreferences.getBoolean(activity.getString(R.string.NIGHT_MODE_KEY), false)

        //MANUAL MODE
        //manual mode activated
        when {
            manualNightMode -> {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                Timber.i(
                    activity.getString(R.string.TAG_NIGHT_MODE) + ": ON"
                )
            }

            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                Timber.i(
                    activity.getString(R.string.TAG_NIGHT_MODE) + ": OFF"
                )
            }
        }
    }
}