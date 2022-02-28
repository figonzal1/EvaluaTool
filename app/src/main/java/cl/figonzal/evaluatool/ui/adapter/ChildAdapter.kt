/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:46
 */

package cl.figonzal.evaluatool.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ChildItemListBinding
import cl.figonzal.evaluatool.domain.model.Child
import cl.figonzal.evaluatool.utils.ConfigRoutes
import cl.figonzal.evaluatool.utils.RouteHandler

class ChildAdapter(
    private val routeMapKey: String,
    private val headerName: String,
    private val list: List<Child>,
    private val activity: Activity
) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.child_item_list, parent, false)
        return ChildViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(routeMapKey, headerName, list[position], activity)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ChildItemListBinding.bind(itemView)

        fun bind(routeMapKey: String, headerName: String, childItem: Child, activity: Activity) {

            with(binding) {

                tvChild.text = childItem.name

                clChild.setOnClickListener {

                    //Handler to correct route
                    ConfigRoutes.routeMap[routeMapKey]?.let { map ->
                        RouteHandler.handleRoutes(
                            map,
                            headerName,
                            adapterPosition,
                            activity
                        )
                    }
                }
            }
        }
    }
}