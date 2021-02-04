/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 04-02-21 0:34
 */
package cl.figonzal.evaluatool.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.servicios.AdsService
import timber.log.Timber

/**
 * Dialog fragment con layout por defecto
 */
class RewardDialogFragment(private val adsService: AdsService) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("¡Apoya a la aplicación!")
        builder.setMessage("Ve el video, apoya gratis monetariamente y recibe 1 hora libre de publicidad")

        builder.setPositiveButton("Ver video") { _: DialogInterface, _: Int ->

            if (adsService.getIntersitial().isLoaded) {
                dismiss()
                adsService.showRewardVideo()
                Timber.i(getString(R.string.TAG_REWARD_DIALOG_BTN_VER_VIDEO))
            }
            dismiss()
        }

        builder.setNegativeButton("Cancelar") { _: DialogInterface, _: Int ->

            Timber.i(getString(R.string.TAG_REWARD_DIALOG_BTN_CANCEL))
            dismiss()
        }
        return builder.create()
    }
}