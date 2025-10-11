/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2025

 Last modified 11-10-25, 18:22
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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item_list, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(
            routeMapKey = routeMapKey,
            header = headerList[position],
            position = position,
            adapter = this,
            childList = childList,
            activity = activity
        )
    }

    override fun getItemCount(): Int = headerList.size

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = HeaderItemListBinding.bind(itemView)

        fun bind(
            routeMapKey: String,
            header: Header,
            position: Int,
            adapter: HeaderAdapter,
            childList: List<List<Child>>,
            activity: Activity
        ) {
            val expanded = header.expanded

            with(binding) {
                tvGroup.text = header.name

                // Cambiar ícono de flecha
                ivArrow.setImageResource(
                    if (expanded)
                        R.drawable.ic_round_keyboard_arrow_up_24
                    else
                        R.drawable.ic_round_keyboard_arrow_down_24
                )

                // Click del header
                clHeader.setOnClickListener {
                    header.expanded = !header.expanded
                    adapter.notifyItemChanged(position)
                }

                //Config recyclerview for childs
                rvChildItem.adapter =
                    ChildAdapter(
                        routeMapKey = routeMapKey,
                        headerName = header.name,
                        list = childList.getOrNull(position) ?: emptyList(),
                        activity = activity
                    )

                rvChildItem.apply {
                    //Recycler view visibility
                    visibility = when {
                        expanded -> View.VISIBLE
                        else -> View.GONE
                    }

                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    visibility = if (expanded) View.VISIBLE else View.GONE
                }
            }
        }
    }
}