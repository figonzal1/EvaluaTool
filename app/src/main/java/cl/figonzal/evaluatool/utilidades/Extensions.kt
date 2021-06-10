/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 09-06-21 23:53
 */

package cl.figonzal.evaluatool.utilidades

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
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
 * Function to disable Material Buttons
 *
 * @return Unit
 */
fun MaterialButton.disable() {
    this.isEnabled = false
    this.alpha = 0.6f
}

/**
 * Function that set sub totals textViews
 *
 * @param tarea task to be written
 * @param total Direct score
 * @version 03-04-2021
 * @return String
 */
fun Activity.setSubTotalPoints(tarea: String, total: Double): String {
    return String.format(Locale.US, getString(R.string.POINTS_FORMAT), tarea, total)
}

/**
 * Funcion that show Helper Dialog for corrected scores
 *
 * @param supportFragmentManager Fragment manager to show FragmentDialog
 * @return Unit
 * @version 03-04-2021
 */
fun Activity.showHelperDialog(supportFragmentManager: FragmentManager) {
    val dialogo = CorregidoDialogFragment()
    dialogo.isCancelable = false
    dialogo.show(supportFragmentManager, getString(R.string.DIALOGO_AYUDA))
}

/**
 * Class that handle CorrectedDialogFragment for directPoints (PD) of a any student.
 * This is only a simple dialog fragment (Informative fragment with static information)
 *
 * @version 18-04-2021
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