/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12-05-21 16:08
 */
package cl.figonzal.evaluatool.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.BaremoAdapter.BaremoViewHolder
import cl.figonzal.evaluatool.databinding.BaremoItemListBinding
import cl.figonzal.evaluatool.utilidades.Utils

/**
 * Adapter used to show baremo table
 *
 * @param perc Baremo table with scores
 * @param context Used to get Resources
 * @version 18-04-2021
 */
class BaremoAdapter(private var perc: Array<Array<Any>>, private val context: Context) :
    RecyclerView.Adapter<BaremoViewHolder>() {

    companion object {
        private const val TABLE_HEADER = 0
        private const val TABLE_ROW = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaremoViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.baremo_item_list, parent, false)
        return BaremoViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaremoViewHolder, position: Int) {
        holder.bind(holder.itemViewType, context, perc)
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TABLE_HEADER
            else -> TABLE_ROW
        }
    }


    override fun getItemCount(): Int {
        return perc.size + 1
    }

    class BaremoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = BaremoItemListBinding.bind(itemView)

        fun bind(itemViewType: Int, context: Context, perc: Array<Array<Any>>) {

            with(binding, {
                when (itemViewType) {
                    TABLE_HEADER -> {

                        tvPd.text = Utils.get(R.string.PUNTAJE_DIRECTO)
                        tvPcChileno.text = Utils.get(R.string.PERCENTIL_CHILENO)

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
                        tvPd.text = item.first().toString()
                        tvPcChileno.text = item[1].toString()
                    }
                }
            })

        }


    }
}