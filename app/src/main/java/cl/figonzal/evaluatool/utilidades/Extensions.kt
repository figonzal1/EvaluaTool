/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 15-07-21 20:42
 */

package cl.figonzal.evaluatool.utilidades

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.servicios.AdsService
import cl.figonzal.evaluatool.servicios.SharedPrefService
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import timber.log.Timber
import java.util.*

/**
 *  Function that set Action Bar title, home indicator & toolbar
 *
 *  @param title Title of activity actionbar
 *  @param materialToolbar Toolbar that is set for action bar
 *  @version 08-06-2021
 */
fun AppCompatActivity.configActionBar(title: Int, materialToolbar: MaterialToolbar) {
    setSupportActionBar(materialToolbar)

    with(supportActionBar, {
        this?.setDisplayHomeAsUpEnabled(true)
        this?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        this?.title = getString(title)
    })
}

/**
 * Function that provide logs with a Id String
 *
 * @param msgId  The id for String
 * @return Unit
 * @version 17-04-2021
 */
fun Activity.logInfo(msgId: Int) = Timber.i(getString(msgId))

/**
 * Function that provide logs with a Tag ID & String ID
 *
 * @param idMsg Id used for message logs
 * @param idTag Id used for TAG
 * @return Unit
 * @version 17-04-2021
 */
fun Activity.logInfo(idTag: Int, idMsg: Int) = Timber.i("%s%s", getString(idTag), getString(idMsg))

/**
 * Function that provide logs with a Tag ID & String
 *
 * @param msg Message for logs
 * @param idTag Id used for TAG
 * @return Unit
 * @version 17-04-2021
 */
fun Activity.logInfo(idTag: Int, msg: String) = Timber.i("%s%s", getString(idTag), msg)

/**
 * Function to show toast easily
 *
 * @param msg Message that will be show in Toast
 * @return Unit
 * @version 17-04-2021
 */
fun Activity.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

/**
 * Function that set sub totals textViews
 *
 * @param tarea task to be written
 * @param total Direct score
 * @version 03-04-2021
 * @return String
 *
 */
@Deprecated("Use formatSubTotalPoints")
fun Activity.setSubTotalPoints(tarea: String, total: Double): String {
    return String.format(Locale.US, getString(R.string.POINTS_FORMAT), tarea, total)
}

fun Activity.formatSubTotalPoints(tarea: String, total: Double): String {
    return String.format(Locale.US, getString(R.string.POINTS_FORMAT), tarea, total)
}

/**
 * ALERT DIALOG
 * Class that handle CorrectedDialogFragment for directPoints (PD) of a any student.
 * This is only a simple dialog fragment (Informative fragment with static information)
 *
 * @version 10-06-2021
 */
fun Activity.alertDialogPdCorregido() {
    MaterialAlertDialogBuilder(this)
        .setTitle(getString(R.string.pd_corregido))
        .setMessage(getString(R.string.descripcion_corregido_dialog))
        .setPositiveButton(getString(R.string.dialogo_boton_cerrar)) { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}

/**
 * CONFIRMATION DIALOG
 * Confirmation dialog that allows the user to remove the ads by watching a reward video
 *
 * @version 10-06-2021
 */
fun Activity.confirmationDialogReward(adsService: AdsService) {
    MaterialAlertDialogBuilder(this)
        .setTitle(getString(R.string.DIALOG_TITLE))
        .setMessage(getString(R.string.DIALOG_MESSAGE))
        .setNegativeButton(getString(R.string.DIALOG_NEGATIVE_BUTTON)) { _, _ ->
            this.logInfo(R.string.TAG_REWARD_DIALOG_BTN_CANCEL)
        }
        .setPositiveButton(getString(R.string.DIALOG_POSITIVE_BUTTON)) { _, _ ->
            when {
                adsService.getIntersitial() != null -> {
                    adsService.showRewardVideo()
                    this.logInfo(R.string.TAG_REWARD_DIALOG_BTN_VER_VIDEO)
                }
            }
        }
        .show()
}

/**
 * Check if the ads can be shown in the app.
 *
 * @param sharedPrefService PreferenceService
 */
fun Activity.isAdsAllowed(sharedPrefService: SharedPrefService): Boolean {
    val nowDate = Date()
    val rewardDate = Date(
        sharedPrefService.getData(
            getString(R.string.SHARED_PREF_END_REWARD_TIME),
            0L
        ) as Long
    )

    logInfo(R.string.TAG_BTN_REWARD_DATE, DateHandler.dateToString(rewardDate))
    return nowDate.after(rewardDate)
}

/**
 * Format any result given a String and Numeric result
 * @param idString String resource
 */
fun Activity.formatResult(idString: Int, vararg args: Any): String {

    return when (args.size) {
        1 -> String.format(getString(idString), args[0])
        2 -> String.format(getString(idString), args[0], args[1])
        3 -> String.format(getString(idString), args[0], args[1], args[2])
        else -> ""
    }
}

/**
 * Pretty print for change log items
 */
fun printChangeLogList(changeList: List<String>): String {
    var changes = ""

    changeList.indices.forEach { i ->
        val ch: String = changeList[i]
        changes = when {
            i > 0 -> changes.plus("\n" + ch)
            else -> changes.plus(ch)
        }
    }

    return changes
}

