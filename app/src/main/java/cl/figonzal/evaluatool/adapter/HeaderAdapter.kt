/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 10/11/21, 5:23 PM
 */

package cl.figonzal.evaluatool.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.HeaderItemListBinding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.model.Header

class HeaderAdapter(
    val headerList: List<Header>,
    private val childList: List<List<Child>>,
    val context: Context,
    val activity: Activity
) :
    RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.header_item_list, parent, false)
        return HeaderViewHolder(v)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {

        holder.bind(headerList[position], this, childList, context, activity)

    }

    override fun getItemCount(): Int {
        return headerList.size
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = HeaderItemListBinding.bind(itemView)

        fun bind(
            header: Header,
            adapter: HeaderAdapter,
            childList: List<List<Child>>,
            context: Context,
            activity: Activity
        ) {

            val expanded: Boolean = header.expanded

            with(binding, {

                rvSubItem.visibility = when {
                    expanded -> View.VISIBLE
                    else -> View.GONE
                }

                tvGroup.text = header.name

                //Change arrrow icon
                ivArrow.setImageResource(
                    when {
                        header.expanded -> R.drawable.ic_keyboard_arrow_up_black_24dp
                        else -> R.drawable.ic_keyboard_arrow_down_black_24dp
                    }
                )

                //Expand header
                clHeader.setOnClickListener {

                    header.expanded = !expanded

                    // Notify the adapter that item has changed
                    adapter.notifyItemChanged(adapterPosition)
                }

                //Config recyclerview for childs
                rvSubItem.adapter =
                    ChildAdapter(header.name, childList[adapterPosition], context, activity)
                rvSubItem.layoutManager = LinearLayoutManager(adapter.context)
                rvSubItem.setHasFixedSize(true)
            })
        }

    }

}