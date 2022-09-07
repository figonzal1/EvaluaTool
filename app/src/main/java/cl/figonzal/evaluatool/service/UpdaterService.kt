/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-09-22 17:02
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import cl.figonzal.evaluatool.R
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import timber.log.Timber


class UpdaterService(
    val activity: Activity,
    private val appUpdateManager: AppUpdateManager,
    private val updateCode: Int
) {

    init {
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener {

                if (it.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
                    it.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
                ) {

                    Timber.d(activity.getString(R.string.UPDATE_AVAILABLE))

                    appUpdateManager.startUpdateFlowForResult(
                        // Pass the intent that is returned by 'getAppUpdateInfo()'.
                        it,
                        // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                        AppUpdateType.IMMEDIATE,
                        // The current activity making the update request.
                        activity,
                        // Include a request code to later monitor this update request.
                        updateCode
                    )
                } else {
                    Timber.d(activity.getString(R.string.UPDATE_NOT_AVAILABLE))
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
                        updateCode
                    )
                }
            }
    }
}