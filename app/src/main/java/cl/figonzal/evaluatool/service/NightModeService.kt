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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilities.EvaluaUtils
import timber.log.Timber

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

        when (sharedPrefService.getData(EvaluaUtils.get(R.string.NIGHT_MODE_KEY), false)) {
            true -> {
                Timber.d(activity.getString(R.string.NIGHT_MODE_STATUS_ON))
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {
                Timber.d(activity.getString(R.string.NIGHT_MODE_STATUS_OFF))
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}