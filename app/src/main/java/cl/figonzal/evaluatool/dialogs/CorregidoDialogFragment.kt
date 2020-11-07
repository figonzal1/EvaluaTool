/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 07-11-20 17:53
 */
package cl.figonzal.evaluatool.dialogs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import cl.figonzal.evaluatool.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.crashlytics.FirebaseCrashlytics

class CorregidoDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater

        @SuppressLint("InflateParams") val view = inflater.inflate(R.layout.pd_corregido_dialog_layout, null)

        builder.setView(view)

        val materialButton: MaterialButton

        materialButton = view.findViewById(R.id.btn_entendido_pd)
        materialButton.setOnClickListener {

            Log.d(getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_CERRADO))
            FirebaseCrashlytics.getInstance().log(getString(R.string.DIALOGO_AYUDA) + getString(R.string.DIALOGO_AYUDA_MSG_CERRADO))
            dismiss()
        }
        return builder.create()
    }
}