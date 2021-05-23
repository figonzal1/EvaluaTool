/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-05-21 15:25
 */
package cl.figonzal.evaluatool.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.servicios.AdsService
import cl.figonzal.evaluatool.utilidades.logInfo

/**
 * Class that handle RewardDialogFragment for eliminate ads
 *
 * @param adsService Services that provide ads
 */
class RewardDialogFragment(private val adsService: AdsService) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        with(AlertDialog.Builder(requireActivity()), {
            setTitle(getString(R.string.DIALOG_TITLE))
            setMessage(getString(R.string.DIALOG_MESSAGE))

            setPositiveButton(getString(R.string.DIALOG_POSITIVE_BUTTON)) { _, _ ->
                if (adsService.getIntersitial() != null) {
                    dismiss()
                    adsService.showRewardVideo()
                    requireActivity().logInfo(R.string.TAG_REWARD_DIALOG_BTN_VER_VIDEO)
                }
                dismiss()
            }

            setNegativeButton(getString(R.string.DIALOG_NEGATIVE_BUTTON)) { _, _ ->
                requireActivity().logInfo(R.string.TAG_REWARD_DIALOG_BTN_CANCEL)
                dismiss()
            }
            return create()
        })
    }
}