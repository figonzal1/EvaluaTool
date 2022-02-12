/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 15:10
 */

package cl.figonzal.evaluatool.utilities

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.activities.MathJaxWebView
import cl.figonzal.evaluatool.databinding.FabWhatsapLayoutBinding
import cl.figonzal.evaluatool.service.SharedPrefService
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView
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
fun AppCompatActivity.configureActionBar(title: Int, materialToolbar: MaterialToolbar) {
    setSupportActionBar(materialToolbar)

    with(supportActionBar) {
        this?.setDisplayHomeAsUpEnabled(true)
        this?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        this?.title = getString(title)
    }
}

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
 * @version 22-07-2021
 * @return String
 *
 */
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

    Timber.i(DateHandler.dateToString(rewardDate))
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

/**
 * Set latex string in webView & visibility
 */
fun Activity.setLatexText(
    cvFormula: MaterialCardView,
    mathJaxWebView: MathJaxWebView,
    formula: String
) {
    cvFormula.visibility = View.VISIBLE
    mathJaxWebView.setText(formula)
}

/**
 * Function to animate view
 */
fun Activity.setIndexAnimation(totalPd: Double): TransitionDrawable {
    val colorDrawables = arrayOf(
        ColorDrawable(Color.TRANSPARENT),
        ColorDrawable(resources.getColor(R.color.indexRed, theme))
    )
    val transitionDrawable = TransitionDrawable(colorDrawables)
    transitionDrawable.isCrossFadeEnabled = true

    when {
        totalPd <= -2.0 -> transitionDrawable.startTransition(500)
        else -> transitionDrawable.resetTransition()
    }

    return transitionDrawable
}

fun Activity.setAlertDialogCorregido(ivHelpPdCorregido: ImageView) {
    ivHelpPdCorregido.setOnClickListener {

        Timber.tag("AlertDialogCorregido").d(getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))
        alertDialogPdCorregido()
    }
}

fun Activity.configureFabWsp(fabWsp: FabWhatsapLayoutBinding) {
    fabWsp.floatingActionButton.setOnClickListener {

        val packageName = "com.whatsapp"

        val intent = packageManager.getLaunchIntentForPackage(packageName)

        when {
            intent != null -> {

                //Open whatsapp group
                val url = "https://chat.whatsapp.com/HY53a5RlUvvFNwFwstXHHy"

                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                    setPackage(packageName)
                    startActivity(this)
                }

            }
            else -> {
                //try to install package
                Intent(Intent.ACTION_VIEW).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    data = Uri.parse("market://details?id=$packageName")

                    try {
                        startActivity(this)
                    } catch (e: ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                            )
                        )
                    }
                }
            }
        }
    }
}
