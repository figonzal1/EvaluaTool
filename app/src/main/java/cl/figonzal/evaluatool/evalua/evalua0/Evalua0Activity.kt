/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-02-21 19:47
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
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import timber.log.Timber
import java.util.*

class Evalua0Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua0Binding
    private lateinit var sectionedRecyclerViewAdapter: SectionedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_EVALUA_0)

        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

        //SUBTIMES - SUBMODULO 1
        val subItems1: MutableList<Evalua> = ArrayList()
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_1)))
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_2)))
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_3)))
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_4)))
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_5)))
        subItems1.add(Evalua(getString(R.string.EVALUA_0_M1_SI_6)))

        //SUBMODULO 2
        val subItems2: MutableList<Evalua> = ArrayList()
        subItems2.add(Evalua(getString(R.string.EVALUA_0_M2_SI_1)))
        subItems2.add(Evalua(getString(R.string.EVALUA_0_M2_SI_2)))
        subItems2.add(Evalua(getString(R.string.EVALUA_0_M2_SI_3)))

        //SUBSMODULO 3
        val subItems3: MutableList<Evalua> = ArrayList()
        subItems3.add(Evalua(getString(R.string.EVALUA_0_M3_SI_1)))
        subItems3.add(Evalua(getString(R.string.EVALUA_0_M3_SI_2)))
        subItems3.add(Evalua(getString(R.string.EVALUA_0_M3_SI_3)))
        subItems3.add(Evalua(getString(R.string.EVALUA_0_M3_SI_4)))

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_1), subItems1, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_2), subItems2, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_3), subItems3, this))

        val recyclerView = binding.rv0
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = sectionedRecyclerViewAdapter
    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {

        RouteHandler().handleRoutes(
                ConfigRoutes.getRouteMapEvalua0(),
                sectionTitle,
                sectionedRecyclerViewAdapter,
                itemAdapterPosition,
                this
        )
    }

    override fun onHeaderRootViewClicked(section: EvaluaAdapter) {

        val sectionAdapter = sectionedRecyclerViewAdapter.getAdapterForSection(section)
        val wasExpanded = section.isExpanded
        val previousItemsTotal = section.contentItemsTotal

        section.isExpanded = !wasExpanded
        sectionAdapter.notifyHeaderChanged()

        when {
            wasExpanded -> {
                sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal)
            }
            else -> {
                sectionAdapter.notifyAllItemsInserted()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}