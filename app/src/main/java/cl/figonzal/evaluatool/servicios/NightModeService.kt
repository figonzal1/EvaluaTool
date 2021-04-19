/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-04-21 23:39
 */

package cl.figonzal.evaluatool.servicios

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo

/**
 * Funcion in charge to handle the night mode
 *
 * @param activity Activity that need to change night mode
 * @param lifecycle Used to handle onStart events
 * @param sharedPrefService Used to save night mode in shared preferences
 * @version 17-04-2021
 */
class NightModeService(
        private val activity: Activity,
        lifecycle: Lifecycle,
        private val sharedPrefService: SharedPrefService,
) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    /**
     * Function that allows you to check and set the night mode from Shared Preference Settings
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun checkNightMode() {

        when (sharedPrefService.getData(Utils.get(R.string.NIGHT_MODE_KEY), false)) {
            true -> {
                activity.logInfo(R.string.TAG_NIGHT_MODE, R.string.TAG_NIGHT_MODE_STATUS_ON)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {
                activity.logInfo(R.string.TAG_NIGHT_MODE, R.string.TAG_NIGHT_MODE_STATUS_OFF)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}