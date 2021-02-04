/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-02-21 22:59
 */
package cl.figonzal.evaluatool.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import com.google.android.material.button.MaterialButton
import timber.log.Timber

/**
 * Dialogo frament con custom layout
 */
class CorregidoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater

        val view = inflater.inflate(R.layout.pd_corregido_dialog_layout, null)

        builder.setView(view)

        val materialButton: MaterialButton

        materialButton = view.findViewById(R.id.btn_entendido_pd)
        materialButton.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_AYUDA_MSG_CERRADO))
            dismiss()
        }
        return builder.create()
    }
}