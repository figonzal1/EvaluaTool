/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 20:57
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import cl.figonzal.evaluatool.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import timber.log.Timber

class GooglePlayService(
    private val activity: Activity
) : DefaultLifecycleObserver {

    private val googlePlay: GoogleApiAvailability = GoogleApiAvailability.getInstance()

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        checkPlayServices()
    }

    private fun checkPlayServices() {

        val resultCode = googlePlay.isGooglePlayServicesAvailable(activity)

        //Si existe algun problema con google play
        //Si el error puede ser resuelto por el usuario
        when {
            resultCode != ConnectionResult.SUCCESS -> when {
                googlePlay.isUserResolvableError(resultCode) -> {

                    Timber.e(activity.getString(R.string.GP_REQUEST))

                    //Solicitar al usuario actualizar google play
                    googlePlay.getErrorDialog(
                        activity,
                        resultCode,
                        PLAY_SERVICES_RESOLUTION_REQUEST
                    )?.apply {
                        setCanceledOnTouchOutside(false)
                        show()
                    }
                }

                else -> {

                    //El error no puede ser resuelto por el usuario y la app se cierra
                    Timber.e(activity.getString(R.string.GP_NOT_SUPPORTED))
                    activity.finish()
                }
            }

            else -> Timber.d(activity.getString(R.string.GP_UPDATED))
        }
    }

    companion object {
        private const val PLAY_SERVICES_RESOLUTION_REQUEST = 9000
    }
}