/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-04-21 18:20
 */
package cl.figonzal.evaluatool.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ExpandableItemGroupListBinding
import cl.figonzal.evaluatool.databinding.ExpandableItemListBinding
import cl.figonzal.evaluatool.modelo.Evalua
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters

/**
 * Adapter that is used
 */
class EvaluaAdapter(private val headerName: String, private val subItemsList: List<Evalua>, private val clickListener: ClickListener) : Section(
        SectionParameters.builder()
                .itemResourceId(R.layout.expandable_item_list)
                .headerResourceId(R.layout.expandable_item_group_list)
                .build()
) {
    var isExpanded = false

    override fun getContentItemsTotal(): Int = if (isExpanded) subItemsList.size else 0

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder = ItemViewHolder(view)
    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder = HeaderViewHolder(view)

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //Casting
        val itemViewHolder = holder as ItemViewHolder

        itemViewHolder.bind(subItemsList[position], this)
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder) {

        //Casting
        val headerViewHolder = holder as HeaderViewHolder

        headerViewHolder.bind(this)
    }

    interface ClickListener {
        fun onHeaderRootViewClicked(section: EvaluaAdapter)
        fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int)
    }

    /**
     * Clase holder para headers de lista expandida
     * ViewHolder for headers of Evalua's list
     *
     * @param rootView Parent view
     */
    internal class HeaderViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

        val binding = ExpandableItemGroupListBinding.bind(rootView)

        /**
         * Binding resources of Header view
         *
         * @param evaluaAdapter PassAdapter to provide all the required information
         */
        fun bind(evaluaAdapter: EvaluaAdapter) {

            with(binding, {

                tvGroup.text = evaluaAdapter.headerName
                ivArrow.setImageResource(
                        when {
                            evaluaAdapter.isExpanded -> R.drawable.ic_keyboard_arrow_up_black_24dp
                            else -> R.drawable.ic_keyboard_arrow_down_black_24dp
                        }
                )
                root.setOnClickListener {
                    evaluaAdapter.clickListener.onHeaderRootViewClicked(evaluaAdapter)
                }
            })
        }
    }

    /**
     * Clase holder para items de lista expandida
     */
    internal class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ExpandableItemListBinding.bind(itemView)

        /**
         * Binding resources for items list
         *
         * @param subItem SubItem binded
         * @param evaluaAdapter PassAdapter to provide all the required information
         */
        fun bind(subItem: Evalua, evaluaAdapter: EvaluaAdapter) {

            with(binding, {
                tvChild.text = subItem.nombre
                itemView.setOnClickListener { evaluaAdapter.clickListener.onItemRootViewClicked(evaluaAdapter.headerName, adapterPosition) }
            })
        }
    }
}