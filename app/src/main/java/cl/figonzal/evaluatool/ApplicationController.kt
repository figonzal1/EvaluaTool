/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 05-03-22 10:40
 */

package cl.figonzal.evaluatool

import android.app.Application
import cl.figonzal.evaluatool.service.AppOpenService
import com.google.android.gms.ads.MobileAds
import timber.log.Timber

class ApplicationController : Application() {

    companion object {
        lateinit var instance: ApplicationController private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        //Use Crashlytics for production & Timber for debug
        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(CrashlyticsTree())
        }

        MobileAds.initialize(this) {}
        AppOpenService(this)
    }
}