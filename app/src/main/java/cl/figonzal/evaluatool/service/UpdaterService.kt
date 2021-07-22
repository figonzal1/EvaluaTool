/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 22-07-21 19:38
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilities.logInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability


class UpdaterService(
    val activity: Activity,
    val appUpdateManager: AppUpdateManager,
    val UPDATE_CODE: Int
) {

    init {
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener {

                if (it.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                    it.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
                ) {

                    activity.logInfo(R.string.UPDATE_AVAILABLE)

                    appUpdateManager.startUpdateFlowForResult(
                        // Pass the intent that is returned by 'getAppUpdateInfo()'.
                        it,
                        // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                        AppUpdateType.IMMEDIATE,
                        // The current activity making the update request.
                        activity,
                        // Include a request code to later monitor this update request.
                        UPDATE_CODE
                    )
                } else {
                    activity.logInfo(R.string.UPDATE_NOT_AVAILABLE)
                }
            }
    }

    fun resumeUpdater() {
        appUpdateManager.appUpdateInfo
            .addOnSuccessListener { appUpdateInfo ->

                if (appUpdateInfo.updateAvailability()
                    == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
                ) {
                    // If an in-app update is already running, resume the update.
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE,
                        activity,
                        UPDATE_CODE
                    )
                }
            }
    }
}