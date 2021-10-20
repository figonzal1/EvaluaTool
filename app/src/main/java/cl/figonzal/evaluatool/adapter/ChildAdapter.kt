/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 10/12/21, 12:46 AM
 */

package cl.figonzal.evaluatool.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ChildItemListBinding
import cl.figonzal.evaluatool.model.Child
import cl.figonzal.evaluatool.utilities.ConfigRoutes
import cl.figonzal.evaluatool.utilities.RouteHandler

class ChildAdapter(
    val headerName: String,
    val list: List<Child>,
    val context: Context,
    val activity: Activity
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
        holder.bind(headerName, list[position], activity)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ChildItemListBinding.bind(itemView)

        fun bind(headerName: String, child: Child, activity: Activity) {

            binding.tvChild.text = child.name

            binding.clChild.setOnClickListener {

                //Get routes por EV0
                val routeMapEvalua0 = ConfigRoutes.routeMapEvalua0

                //Handler to correct route
                RouteHandler.handleRoutes2(routeMapEvalua0, headerName, adapterPosition, activity)
            }

        }
    }

}