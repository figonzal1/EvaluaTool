/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 17:21
 */
package cl.figonzal.evaluatool.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.BaremoItemListBinding
import cl.figonzal.evaluatool.ui.adapter.BaremoAdapter.BaremoViewHolder
import cl.figonzal.evaluatool.utils.EvaluaUtils
import cl.figonzal.evaluatool.utils.layoutInflater

/**
 * Adapter used to show baremo table
 *
 * @param percentile Baremo table with scores
 * @param context Used to get Resources
 * @version 18-04-2021
 */
class BaremoAdapter(private var percentile: Array<DoubleArray>, private val context: Context) :
    RecyclerView.Adapter<BaremoViewHolder>() {

    companion object {
        private const val TABLE_HEADER = 0
        private const val TABLE_ROW = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaremoViewHolder(parent.layoutInflater(R.layout.baremo_item_list))

    override fun onBindViewHolder(holder: BaremoViewHolder, position: Int) {
        holder.bind(holder.itemViewType, context, percentile)
    }

    override fun getItemViewType(position: Int) = when (position) {
        0 -> TABLE_HEADER
        else -> TABLE_ROW
    }


    override fun getItemCount() = percentile.size + 1

    class BaremoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = BaremoItemListBinding.bind(itemView)

        fun bind(itemViewType: Int, context: Context, perc: Array<DoubleArray>) {

            with(binding) {
                when (itemViewType) {
                    TABLE_HEADER -> {

                        tvPd.text = EvaluaUtils.get(R.string.PUNTAJE_DIRECTO)
                        tvPcChileno.text = EvaluaUtils.get(R.string.PERCENTIL_CHILENO)

                        baremoItem.setBackgroundColor(
                            context.resources.getColor(
                                R.color.tableGreyHeader,
                                context.theme
                            )
                        )
                    }

                    else -> {
                        val item = perc[adapterPosition - 1]
                        when {
                            (adapterPosition - 1) % 2 != 0 -> baremoItem.setBackgroundColor(
                                context.resources.getColor(
                                    R.color.tableGreyRow,
                                    context.theme
                                )
                            )

                            else -> baremoItem.setBackgroundColor(
                                context.resources.getColor(
                                    R.color.colorSurface,
                                    context.theme
                                )
                            )
                        }
                        tvPd.text = item.first().toInt().toString()
                        tvPcChileno.text = item[1].toInt().toString()
                    }
                }
            }

        }


    }
}