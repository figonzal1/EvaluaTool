/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 20-05-21 13:49
 */
package cl.figonzal.evaluatool.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.servicios.AdsService
import cl.figonzal.evaluatool.utilidades.logInfo
import timber.log.Timber

/**
 * Class that handle RewardDialogFragment for eliminate ads
 *
 * @param adsService Services that provide ads
 */
class RewardDialogFragment(private val adsService: AdsService) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //TODO: Extraer strings
        with(AlertDialog.Builder(requireActivity()), {
            setTitle("¡Apoya a la aplicación!")
            setMessage("Ve el video, apoya gratis monetariamente y recibe 1 día libre de publicidad")

            setPositiveButton("Ver video") { _, _ ->
                if (adsService.getIntersitial() != null) {
                    dismiss()
                    adsService.showRewardVideo()
                    activity?.logInfo(R.string.TAG_REWARD_DIALOG_BTN_VER_VIDEO)
                }
                dismiss()
            }

            setNegativeButton("Cancelar") { _, _ ->

                Timber.i(getString(R.string.TAG_REWARD_DIALOG_BTN_CANCEL))
                dismiss()
            }
            return create()
        })
    }
}