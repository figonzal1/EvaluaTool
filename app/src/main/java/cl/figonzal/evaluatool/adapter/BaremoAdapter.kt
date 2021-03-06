/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-02-21 18:26
 */
package cl.figonzal.evaluatool.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.BaremoAdapter.BaremoViewHolder

class BaremoAdapter(private var perc: Array<Array<Int>>, private val context: Context) : RecyclerView.Adapter<BaremoViewHolder>() {

    companion object {
        private const val TABLE_HEADER = 0
        private const val TABLE_ROW = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaremoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.baremo_item_list, parent, false)
        return BaremoViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaremoViewHolder, position: Int) {

        when (holder.itemViewType) {
            TABLE_HEADER -> {

                holder.tvPD.text = context.getString(R.string.PUNTAJE_DIRECTO)
                holder.tvPcChileno.text = context.getString(R.string.PERCENTIL_CHILENO)

                holder.baremoItem.setBackgroundColor(context.resources.getColor(R.color.tableGreyHeader, context.theme))
            }
            else -> {

                val item = perc[position - 1]

                when {
                    (position - 1) % 2 != 0 -> holder.baremoItem.setBackgroundColor(context.resources.getColor(R.color.tableGreyRow, context.theme))
                    else -> holder.baremoItem.setBackgroundColor(context.resources.getColor(R.color.colorSurface, context.theme))
                }

                holder.tvPD.text = item[0].toString()
                holder.tvPcChileno.text = item[1].toString()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TABLE_HEADER
            else -> {
                TABLE_ROW
            }
        }
    }


    override fun getItemCount(): Int {
        return perc.size + 1
    }

    class BaremoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val baremoItem: ConstraintLayout = itemView.findViewById(R.id.baremo_item)
        internal val tvPD: TextView = itemView.findViewById(R.id.tv_pd)
        internal val tvPcChileno: TextView = itemView.findViewById(R.id.tv_pc_chileno)

    }
}