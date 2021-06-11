/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 11-06-21 01:58
 */
package cl.figonzal.evaluatool.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.BaremoAdapter
import cl.figonzal.evaluatool.databinding.BaremoDialogLayoutBinding
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.logInfo
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Class that handle DialogFragment for Baremo Score Table
 *
 * @param perc Table of scores (Baremo table)
 * @param itemName Title of item section
 *
 * @version 10-06-2021
 */
class BaremoDialogFragment(private val perc: Array<Array<Any>>, private val itemName: String) :
    DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = MaterialAlertDialogBuilder(requireContext())

        with(BaremoDialogLayoutBinding.inflate(LayoutInflater.from(context)), {

            //Recycler view
            rvBaremo.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = BaremoAdapter(perc, requireContext())
            }

            //tvBaremoDescription
            tvBaremoDescripcion.text =
                String.format("%s %s", Utils.get(R.string.dialogo_baremo_descripcion), itemName)

            //BtnCloseDialog
            btnCerrar.setOnClickListener {
                requireActivity().logInfo(R.string.DIALOGO_BAREMO_CERRADO)
                dismiss()
            }

            builder.setView(root)
            return builder.create()
        })
    }

}