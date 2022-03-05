/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 05-03-22 12:02
 */

package cl.figonzal.evaluatool.utils

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.net.Uri
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.databinding.FabWhatsapLayoutBinding
import cl.figonzal.evaluatool.ui.dialogs.FirebaseDialogFragment
import cl.figonzal.evaluatool.ui.evaluas.evalua0.Evalua0Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua1.Evalua1Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua10.Evalua10Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua2.Evalua2Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua3.Evalua3Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua4.Evalua4Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua5.Evalua5Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua6.Evalua6Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua7.Evalua7Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua8.Evalua8Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua9.Evalua9Activity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.shape.CornerFamily
import timber.log.Timber
import java.util.*


fun AppCompatActivity.configureActionBar(idString: Int, materialToolbar: MaterialToolbar) {
    setSupportActionBar(materialToolbar)

    supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(true)
        setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        title = getString(idString)
    }
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
fun List<String>.printChangeLogList(): CharSequence {
    var changes = ""

    indices.forEach { i ->

        changes = when {
            i > 0 -> changes.plus("\n" + this[i])
            else -> changes.plus(this[i])
        }
    }
    return changes
}


fun Activity.configureFABWsp(fabWsp: FabWhatsapLayoutBinding) {
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

/**
 * Animate View
 */
fun Activity.setIndexAnimation(totalPd: Double): TransitionDrawable {

    return TransitionDrawable(
        arrayOf(
            ColorDrawable(Color.TRANSPARENT),
            ColorDrawable(resources.getColor(R.color.indexRed, theme))
        )
    ).apply {
        isCrossFadeEnabled = true

        when {
            totalPd <= -2.0 -> startTransition(500)
            else -> resetTransition()
        }
    }
}

/**
 * Function that set sub totals textViews
 *
 */
fun Activity.formatSubTotalPoints(tarea: String, total: Double): String {
    return String.format(Locale.US, getString(R.string.POINTS_FORMAT), tarea, total)
}

/**
 * Function to show toast easily
 */
fun Activity.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

fun ImageView.setAlertDialogCorregido() =
    setOnClickListener {

        Timber.d(resources.getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO))

        MaterialAlertDialogBuilder(context)
            .setTitle(resources.getString(R.string.pd_corregido))
            .setMessage(resources.getString(R.string.descripcion_corregido_dialog))
            .setPositiveButton(resources.getString(R.string.dialogo_boton_cerrar)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

/**
 * Function that handle listener for buttons in Main Activity
 */
fun Activity.setUpMainButtons(
    buttonList: MutableList<MaterialButton>,
    binding: ActivityMainBinding,
) {

    with(buttonList) {

        setUpAnimations(this, binding)

        forEachIndexed { i, button ->

            button.setOnClickListener {

                var activityToOpen: Class<out Activity?>? = null

                when (i) {
                    0 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_0))
                        activityToOpen = Evalua0Activity::class.java
                    }
                    1 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_1))
                        activityToOpen = Evalua1Activity::class.java
                    }
                    2 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_2))
                        activityToOpen = Evalua2Activity::class.java
                    }
                    3 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_3))
                        activityToOpen = Evalua3Activity::class.java
                    }
                    4 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_4))
                        activityToOpen = Evalua4Activity::class.java
                    }
                    5 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_5))
                        activityToOpen = Evalua5Activity::class.java
                    }
                    6 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_6))
                        activityToOpen = Evalua6Activity::class.java
                    }
                    7 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_7))
                        activityToOpen = Evalua7Activity::class.java
                    }
                    8 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_8))
                        activityToOpen = Evalua8Activity::class.java
                    }
                    9 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_9))
                        activityToOpen = Evalua9Activity::class.java
                    }
                    10 -> {
                        Timber.d(getString(R.string.BTN_EVALUA_10))
                        activityToOpen = Evalua10Activity::class.java
                    }
                }
                val intent = Intent(this@setUpMainButtons, activityToOpen)
                startActivity(intent)
                //adsService.checkIntersitialOnStart(activityToOpen, test)
            }
        }
    }
}

private fun Activity.setUpAnimations(
    buttonList: MutableList<MaterialButton>,
    binding: ActivityMainBinding,
) {

    val fadeList = mutableListOf<Animation>()
    val offset = 400L
    val step = 150L

    for (i in 0..12) {
        fadeList.add(AnimationUtils.loadAnimation(this, R.anim.anim_fade).also {
            when (i) {
                0 -> it.startOffset = offset
                else -> it.startOffset = offset + step * (i + 1)
            }
        })
    }

    //Start animations
    fadeList.forEachIndexed { index, animation ->
        when (index) {
            0 -> binding.tvNombreApp.startAnimation(animation)
            1 -> binding.tvVersion.startAnimation(animation)
        }
    }

    buttonList.forEachIndexed { index, materialButton ->
        materialButton.startAnimation(fadeList[index + 2])
    }

}

/**
 * Function that set a custom corners for a Material CardView
 */
fun MaterialCardView.setUpCardViewCustomCorners() {
    //Custom card view corners
    shapeAppearanceModel
        .toBuilder()
        .setBottomLeftCorner(CornerFamily.ROUNDED, 32f)
        .setBottomRightCorner(CornerFamily.ROUNDED, 32f)
        .setTopRightCornerSize(0f)
        .setTopLeftCornerSize(0f)
        .build().also { shapeAppearanceModel = it }
}

/*fun Activity.setLatexText(
    cvFormula: MaterialCardView,
    mathJaxWebView: MathJaxWebView,
    formula: String
) {
    cvFormula.visibility = View.VISIBLE
    mathJaxWebView.setText(formula)
}*/

fun AppCompatActivity.handlePrivacyPolicy(sharedPrefUtil: SharedPrefUtil) {

    val privacyDialogShowed: Boolean = sharedPrefUtil.getData(
        getString(R.string.SHARED_PREF_PRIVACY_POLICY),
        false
    ) as Boolean

    when {
        !privacyDialogShowed -> {
            FirebaseDialogFragment(sharedPrefUtil, this).show(
                supportFragmentManager,
                "Dialog Fragment"
            )

            Timber.d(getString(R.string.privacy_policy_show))
        }
        else -> Timber.d(getString(R.string.privacy_policy_not_show))
    }

}

fun ActivityMainBinding.hideSwitchNightMode() {
    View.INVISIBLE.apply {
        includeSwitch.switchMaterial.visibility = this
        includeSwitch.ivLightMode.visibility = this
        includeSwitch.ivNightMode.visibility = this
    }
}