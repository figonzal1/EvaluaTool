/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-04-21 22:17
 */
package cl.figonzal.evaluatool.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.PdCorregidoDialogLayoutBinding
import cl.figonzal.evaluatool.utilidades.logInfo

/**
 * Class that handle CorrectedDialogFragment for directPoints (PD) of a any student.
 * This is only a simple dialog fragment (Informative fragment with static information)
 *
 * @version 18-04-2021
 */
class CorregidoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)

        with(PdCorregidoDialogLayoutBinding.inflate(LayoutInflater.from(context)), {
            btnEntendidoPd.setOnClickListener {
                activity?.logInfo(R.string.DIALOGO_AYUDA_MSG_CERRADO)
                dismiss()
            }

            builder.setView(root)
        })
        return builder.create()
    }
}