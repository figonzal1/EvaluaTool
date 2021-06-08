/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 08-06-21 16:59
 */
package cl.figonzal.evaluatool.evalua.evalua0

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua0Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.util.*

class Evalua0Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua0Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_EVALUA_0, binding.include.materialToolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {
        //SUBTIMES - SUBMODULO 1
        val subItems1 = listOf(
            Evalua(getString(R.string.EVALUA_0_M1_SI_1)),
            Evalua(getString(R.string.EVALUA_0_M1_SI_2)),
            Evalua(getString(R.string.EVALUA_0_M1_SI_3)),
            Evalua(getString(R.string.EVALUA_0_M1_SI_4)),
            Evalua(getString(R.string.EVALUA_0_M1_SI_5)),
            Evalua(getString(R.string.EVALUA_0_M1_SI_6))
        )

        //SUBMODULO 2
        val subItems2 = listOf(
            Evalua(getString(R.string.EVALUA_0_M2_SI_1)),
            Evalua(getString(R.string.EVALUA_0_M2_SI_2)),
            Evalua(getString(R.string.EVALUA_0_M2_SI_3))
        )

        //SUBSMODULO 3
        val subItems3 = listOf(
            Evalua(getString(R.string.EVALUA_0_M3_SI_1)),
            Evalua(getString(R.string.EVALUA_0_M3_SI_2)),
            Evalua(getString(R.string.EVALUA_0_M3_SI_3)),
            Evalua(getString(R.string.EVALUA_0_M3_SI_4)),
        )

        //HEADERS
        sectionedRecyclerViewAdapter.apply {
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_0_MODULO_1),
                    subItems1,
                    this@Evalua0Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_0_MODULO_2),
                    subItems2,
                    this@Evalua0Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_0_MODULO_3),
                    subItems3,
                    this@Evalua0Activity
                )
            )
        }


        //Recycler View
        binding.rv0.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }
    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {

        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua0)]?.let {
            RouteHandler.handleRoutes(
                it,
                sectionTitle,
                sectionedRecyclerViewAdapter,
                itemAdapterPosition,
                this
            )
        }
    }

    override fun onHeaderRootViewClicked(section: EvaluaAdapter) {

        val sectionAdapter = sectionedRecyclerViewAdapter.getAdapterForSection(section)
        val wasExpanded = section.isExpanded
        val previousItemsTotal = section.contentItemsTotal

        section.isExpanded = !wasExpanded
        sectionAdapter.notifyHeaderChanged()

        when {
            wasExpanded -> sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal)
            else -> sectionAdapter.notifyAllItemsInserted()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}