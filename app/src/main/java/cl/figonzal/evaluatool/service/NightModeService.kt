/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26-05-22 16:57
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import timber.log.Timber

class NightModeService(
    private val activity: Activity,
    private val sharedPrefUtil: SharedPrefUtil
) : DefaultLifecycleObserver {


    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        checkNightMode()
    }

    private fun checkNightMode() {

        val manualNightMode =
            sharedPrefUtil.getData(activity.getString(R.string.NIGHT_MODE_KEY), false) as Boolean

        //MANUAL MODE
        //manual mode activated
        when {
            manualNightMode -> {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                Timber.d(activity.getString(R.string.TAG_NIGHT_MODE) + ": ON")
            }

            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                Timber.d(activity.getString(R.string.TAG_NIGHT_MODE) + ": OFF")
            }
        }
    }
}