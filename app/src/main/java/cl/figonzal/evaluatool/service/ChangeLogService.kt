/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 01-03-23 23:19
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import android.widget.TextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import cl.figonzal.evaluatool.utils.printChangeLogList
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import timber.log.Timber

class ChangeLogService(
        private val activity: Activity,
        private val sharedPrefUtil: SharedPrefUtil
) : DefaultLifecycleObserver {

    private var versionCode: Int = BuildConfig.VERSION_CODE
    private val version = activity.getString(R.string.version) + BuildConfig.VERSION_NAME
    private val listImprovements = emptyList<String>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        checkChangeLogVersion()
    }

    private fun checkChangeLogVersion() {
        configChangeLog()
    }

    private fun configChangeLog() {

        //GET STORED VERSION CODE
        val sharedVersionCode = sharedPrefUtil.getData(
                activity.getString(R.string.SHARED_PREF_ACTUAL_VERSION_CODE),
                0
        ) as Int

        Timber.d("${activity.getString(R.string.SHARED_VERSION_CODE_APP)}$sharedVersionCode")
        Timber.d("${activity.getString(R.string.VERSION_CODE_APP)}$versionCode")

        when {
            sharedVersionCode < versionCode && sharedVersionCode != 0 -> {

                showBottomDialog()
                Timber.d(activity.getString(R.string.NEW_VERSION_DETECTED))
            }
            else -> Timber.d(activity.getString(R.string.NO_VERSION_DETECTED))
        }
    }

    private fun showBottomDialog() {

        with(BottomSheetDialog(activity)) {

            setContentView(R.layout.changelog_dialog)
            setCancelable(false)

            findViewById<TextView>(R.id.tv_version)?.text = version
            findViewById<TextView>(R.id.tv_changes_list)?.text =
                    listImprovements.printChangeLogList()
            findViewById<MaterialButton>(R.id.btn_change_log)?.setOnClickListener {
                sharedPrefUtil.saveData(
                        context.getString(R.string.SHARED_PREF_ACTUAL_VERSION_CODE), versionCode
                )
                dismiss()
            }

            show()
        }
    }
}