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
 * Last modified 08-11-20 21:41
 */
package cl.figonzal.evaluatool.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.BaremoAdapter
import com.google.android.material.button.MaterialButton
import timber.log.Timber

class BaremoDialogFragment(private val perc: Array<Array<Int>>, private val itemName: String) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val v = inflater.inflate(R.layout.baremo_dialog_layout, null)

        val rv: RecyclerView = v.findViewById(R.id.rv_baremo)
        rv.setHasFixedSize(true)

        val baremoAdapter = BaremoAdapter(perc, requireContext())
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = baremoAdapter

        val tvDescription = v.findViewById<TextView>(R.id.tv_baremo_descripcion)
        tvDescription.text = String.format("%s %s", getString(R.string.dialogo_baremo_descripcion), itemName)

        val btnClose: MaterialButton = v.findViewById(R.id.btn_cerrar)
        btnClose.setOnClickListener {

            Timber.i(getString(R.string.DIALOGO_BAREMO_CERRADO))
            dismiss()
        }

        builder.setView(v)
        return builder.create()
    }

}