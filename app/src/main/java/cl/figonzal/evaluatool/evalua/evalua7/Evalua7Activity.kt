/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-02-21 19:47
 */
package cl.figonzal.evaluatool.evalua.evalua7

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua7Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import timber.log.Timber
import java.util.*

class Evalua7Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua7Binding
    private lateinit var sectionedRecyclerViewAdapter: SectionedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.include.toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_EVALUA_7)

        configurarExpandedList()
    }

    private fun configurarExpandedList() {
        sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

        val subItems1: MutableList<Evalua> = ArrayList()
        subItems1.add(Evalua(getString(R.string.EVALUA_7_M1_SI_1)))

        val subItems2: MutableList<Evalua> = ArrayList()
        subItems2.add(Evalua(getString(R.string.EVALUA_7_M2_SI_1)))
        subItems2.add(Evalua(getString(R.string.EVALUA_7_M2_SI_2)))
        subItems2.add(Evalua(getString(R.string.EVALUA_7_M2_SI_3)))

        val subItems4: MutableList<Evalua> = ArrayList()
        subItems4.add(Evalua(getString(R.string.EVALUA_7_M4_SI_1)))
        subItems4.add(Evalua(getString(R.string.EVALUA_7_M4_SI_2)))
        subItems4.add(Evalua(getString(R.string.EVALUA_7_M4_SI_3)))

        val subItems5: MutableList<Evalua> = ArrayList()
        subItems5.add(Evalua(getString(R.string.EVALUA_7_M5_SI_1)))
        subItems5.add(Evalua(getString(R.string.EVALUA_7_M5_SI_2)))
        subItems5.add(Evalua(getString(R.string.EVALUA_7_M5_SI_3)))

        val subItems6: MutableList<Evalua> = ArrayList()
        subItems6.add(Evalua(getString(R.string.EVALUA_7_M6_SI_1)))
        subItems6.add(Evalua(getString(R.string.EVALUA_7_M6_SI_2)))

        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_1), subItems1, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_2), subItems2, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_4), subItems4, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_5), subItems5, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_6), subItems6, this))

        val recyclerView = binding.rv7
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = sectionedRecyclerViewAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.i(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onHeaderRootViewClicked(section: EvaluaAdapter) {

        val sectionAdapter = sectionedRecyclerViewAdapter.getAdapterForSection(section)
        val wasExpanded = section.isExpanded
        val previousItemsTotal = section.contentItemsTotal
        section.isExpanded = !wasExpanded
        sectionAdapter.notifyHeaderChanged()

        if (wasExpanded) {
            sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal)
        } else {
            sectionAdapter.notifyAllItemsInserted()
        }
    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        RouteHandler().handleRoutes(
                ConfigRoutes.getRouteMapEvalua7(),
                sectionTitle,
                sectionedRecyclerViewAdapter,
                itemAdapterPosition,
                this
        )
    }
}