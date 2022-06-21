/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 21-06-22 00:54
 */

package cl.figonzal.evaluatool

import android.app.Application
import cl.figonzal.evaluatool.di.appModule
import cl.figonzal.evaluatool.service.AppOpenService
import com.google.android.gms.ads.MobileAds
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class ApplicationController : Application() {

    companion object {
        lateinit var instance: ApplicationController private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {

            androidLogger(
                when {
                    BuildConfig.DEBUG -> Level.ERROR
                    else -> Level.NONE
                }
            )

            androidContext(this@ApplicationController)

            modules(appModule)
        }

        //Use Crashlytics for production & Timber for debug
        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(CrashlyticsTree())
        }

        MobileAds.initialize(this) {}

        AppOpenService(this)
    }
}