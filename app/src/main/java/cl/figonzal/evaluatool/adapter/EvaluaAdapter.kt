/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-02-21 19:05
 */
package cl.figonzal.evaluatool.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.modelo.Evalua
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters

class EvaluaAdapter(private val nombre_header: String, private val subItems: List<Evalua>, private val clickListener: ClickListener) : Section(
        SectionParameters.builder()
                .itemResourceId(R.layout.expandable_list_item)
                .headerResourceId(R.layout.expandable_list_group)
                .build()
) {
    var isExpanded = false

    override fun getContentItemsTotal(): Int {
        return if (isExpanded) subItems.size else 0
    }

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ItemViewHolder(view)
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val itemViewHolder = holder as ItemViewHolder

        itemViewHolder.tvItemTitle.text = subItems[position].nombre
        itemViewHolder.itemView.setOnClickListener { clickListener.onItemRootViewClicked(nombre_header, itemViewHolder.adapterPosition) }
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder) {

        val headerViewHolder = holder as HeaderViewHolder

        headerViewHolder.tvHeaderTitle.text = nombre_header
        headerViewHolder.ivArrow.setImageResource(
                if (isExpanded) R.drawable.ic_keyboard_arrow_up_black_24dp else R.drawable.ic_keyboard_arrow_down_black_24dp
        )

        headerViewHolder.rootView.setOnClickListener { clickListener.onHeaderRootViewClicked(this) }
    }

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return HeaderViewHolder(view)
    }

    interface ClickListener {
        fun onHeaderRootViewClicked(section: EvaluaAdapter)
        fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int)
    }

    /**
     * Clase holder para headers de lista expandida
     */
    internal class HeaderViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView) {
        val tvHeaderTitle: TextView = rootView.findViewById(R.id.tv_group)
        val ivArrow: ImageView = rootView.findViewById(R.id.iv_arrow)

    }

    /**
     * Clase holder para items de lista expandida
     */
    internal class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvItemTitle: TextView = itemView.findViewById(R.id.tv_child)
    }
}