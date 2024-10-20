/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2024

 Last modified 01-09-24 16:42
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import android.content.IntentSender.SendIntentException
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber


private const val FIREBASE_EVALUATOOL_UPDATER_STATUS = "evaluatool_updater_status"

class UpdaterService(
    activity: Activity,
    private val activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>
) {

    private var manager = AppUpdateManagerFactory.create(activity)
    private var crashlytics = Firebase.crashlytics

    fun checkAvailability() {

        val appUpdateInfoTask = manager.appUpdateInfo

        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            when {
                appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                        && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE) -> {
                    Timber.d("Update available")
                    crashlytics.setCustomKey(FIREBASE_EVALUATOOL_UPDATER_STATUS, "Update available")

                    try {
                        manager.startUpdateFlowForResult(
                            appUpdateInfo,
                            activityResultLauncher,
                            AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                        )
                    } catch (e: SendIntentException) {
                        Timber.e("Update intent failed")
                        crashlytics.setCustomKey(
                            FIREBASE_EVALUATOOL_UPDATER_STATUS,
                            "Update intent failed"
                        )
                    }
                }

                else -> {
                    Timber.d("No new updates available")
                    crashlytics.setCustomKey(
                        FIREBASE_EVALUATOOL_UPDATER_STATUS,
                        "No new updates available"
                    )
                }
            }
        }
    }


    fun resumeUpdater() {

        val crashlytics = Firebase.crashlytics

        manager
            .appUpdateInfo
            .addOnSuccessListener { appUpdateInfo ->

                if (appUpdateInfo.updateAvailability()
                    == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
                ) {
                    try {
                        manager.startUpdateFlowForResult(
                            appUpdateInfo,
                            activityResultLauncher,
                            AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                        )
                    } catch (e: SendIntentException) {
                        Timber.e(e, "onResume updater failed")
                        crashlytics.setCustomKey(
                            FIREBASE_EVALUATOOL_UPDATER_STATUS,
                            "onResume updater failed"
                        )

                    }
                }
            }
    }

    companion object {
        const val UPDATE_CODE = 305
    }

}