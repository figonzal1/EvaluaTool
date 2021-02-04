/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 04-02-21 0:33
 */

package cl.figonzal.evaluatool.servicios

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cl.figonzal.evaluatool.R
import timber.log.Timber


class NightModeService(private val activity: Activity, lifecycle: Lifecycle, private val sharedPrefService: SharedPrefService) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    /**
     * Funcion que permite revisar y establecer el modo noche desde Shared Preference Settings
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun checkNightMode() {

        //Leer preference settings
        val nightMode = sharedPrefService.getData(activity.getString(R.string.NIGHT_MODE_KEY), false) as Boolean

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Timber.i("%s: %s", activity.getString(R.string.TAG_NIGHT_MODE), activity.getString(R.string.TAG_NIGHT_MODE_STATUS_ON))
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Timber.i("%s: %s", activity.getString(R.string.TAG_NIGHT_MODE), activity.getString(R.string.TAG_NIGHT_MODE_STATUS_OFF))
        }
    }
}