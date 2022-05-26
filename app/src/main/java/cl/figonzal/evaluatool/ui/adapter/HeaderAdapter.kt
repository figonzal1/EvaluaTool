/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26-05-22 00:14
 */

package cl.figonzal.evaluatool.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.HeaderItemListBinding
import cl.figonzal.evaluatool.domain.model.Child
import cl.figonzal.evaluatool.domain.model.Header

class HeaderAdapter(
    private val routeMapKey: String,
    private val headerList: List<Header>,
    private val childList: List<List<Child>>,
    private val activity: Activity
) :
    RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.header_item_list, parent, false)
        return HeaderViewHolder(v)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(routeMapKey, headerList[position], this, childList, activity)
    }

    override fun getItemCount(): Int {
        return headerList.size
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = HeaderItemListBinding.bind(itemView)

        fun bind(
            routeMapKey: String,
            header: Header,
            adapter: HeaderAdapter,
            childList: List<List<Child>>,
            activity: Activity
        ) {

            val expanded: Boolean = header.expanded

            with(binding) {

                tvGroup.text = header.name

                //Change arrrow icon
                ivArrow.setImageResource(
                    when {
                        header.expanded -> R.drawable.ic_round_keyboard_arrow_up_24
                        else -> R.drawable.ic_round_keyboard_arrow_down_24
                    }
                )

                //Header click listener
                clHeader.setOnClickListener {

                    header.expanded = !expanded

                    // Notify the adapter that item has changed
                    adapter.notifyItemChanged(adapterPosition)
                }

                //Config recyclerview for childs
                rvChildItem.adapter =
                    ChildAdapter(
                        routeMapKey,
                        header.name,
                        childList[adapterPosition],
                        activity
                    )

                rvChildItem.apply {
                    //Recycler view visibility
                    visibility = when {
                        expanded -> View.VISIBLE
                        else -> View.GONE
                    }

                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                }

            }
        }

    }

}