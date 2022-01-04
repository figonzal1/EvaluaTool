/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 16:23
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import android.content.Context
import android.widget.TextView
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilities.printChangeLogList
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import timber.log.Timber


class ChangeLogService(
    val activity: Activity,
    val context: Context,
    private val sharedPrefService: SharedPrefService
) {

    private val version = context.getString(R.string.version) + BuildConfig.VERSION_NAME
    private val listImprovements = listOf(
        "- Se agrega menu de configuración",
        "- Actualizaciones internas necesarias"

    )
    private val showChangeLog = true

    fun checkChangeLogVersion() {
        if (showChangeLog) configChangeLog()
    }

    private fun configChangeLog() {

        //GET PACKAGE VERSION
        val versionCode = BuildConfig.VERSION_CODE

        //GET SHARED PREF VERSION SAVED
        val sharedVersionCode = sharedPrefService.getData(
            context.getString(R.string.SHARED_PREF_ACTUAL_VERSION_CODE),
            0
        ) as Int

        Timber.d("${activity.getString(R.string.SHARED_VERSION_CODE_APP)}$sharedVersionCode")
        Timber.d("${activity.getString(R.string.VERSION_CODE_APP)}$versionCode")

        when {
            sharedVersionCode < versionCode -> {
                showBottomSheetDialog()
                sharedPrefService.saveData(
                    context.getString(R.string.SHARED_PREF_ACTUAL_VERSION_CODE),
                    versionCode
                )

                Timber.d(activity.getString(R.string.NEW_VERSION_DETECTED))
            }
            else -> Timber.d(activity.getString(R.string.NO_VERSION_DETECTED))
        }

    }

    private fun showBottomSheetDialog() {

        with(BottomSheetDialog(context), {

            setContentView(R.layout.changelog_dialog)
            setCancelable(false)

            findViewById<TextView>(R.id.tv_version)?.text = version
            findViewById<TextView>(R.id.tv_changes_list)?.text =
                printChangeLogList(listImprovements)

            findViewById<MaterialButton>(R.id.btn_change_log)
                ?.setOnClickListener { this.dismiss() }

            show()
        })
    }
}