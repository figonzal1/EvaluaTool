/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-04-21 0:26
 */

package cl.figonzal.evaluatool.utilidades

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cl.figonzal.evaluatool.R
import com.google.android.material.button.MaterialButton
import timber.log.Timber
import java.util.*

/**
 *  Function that set Action Bar title, home indicator & toolbar
 *
 *  @param title Title of activity actionbar
 *  @param toolbar Toolbar that is set for action bar
 *  @version 17-04-2021
 */
fun AppCompatActivity.configActionBar(title: Int, toolbar: Toolbar) {
    setSupportActionBar(toolbar)

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
 * Function that generate a random number with 30% of success
 *
 * @return Boolean with the result
 */
fun generateRandomNumber(): Boolean = Random().nextInt(10) % 3 == 0