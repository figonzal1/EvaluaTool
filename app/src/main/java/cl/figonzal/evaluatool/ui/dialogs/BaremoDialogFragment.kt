/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 17:21
 */
package cl.figonzal.evaluatool.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.BaremoDialogLayoutBinding
import cl.figonzal.evaluatool.ui.adapter.BaremoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import timber.log.Timber

/**
 * Class that handle DialogFragment for Baremo Score Table
 *
 * @param percentile Table of scores (Baremo table)
 * @param itemName Title of item section
 *
 * @version 10-06-2021
 */
class BaremoDialogFragment(
    private val percentile: Array<DoubleArray>,
    private val itemName: String
) :
    DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = MaterialAlertDialogBuilder(requireContext())

        with(BaremoDialogLayoutBinding.inflate(layoutInflater)) {

            //Recycler view
            rvBaremo.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = BaremoAdapter(percentile, requireContext())
            }

            //tvBaremoDescription
            tvBaremoDescripcion.text =
                String.format(
                    "%s %s",
                    getString(R.string.dialogo_baremo_descripcion),
                    itemName
                )

            //BtnCloseDialog
            btnCerrar.setOnClickListener {
                Timber.d(getString(R.string.DIALOGO_BAREMO_CERRADO))
                dismiss()
            }

            builder.setView(root)
            return builder.create()
        }
    }

}