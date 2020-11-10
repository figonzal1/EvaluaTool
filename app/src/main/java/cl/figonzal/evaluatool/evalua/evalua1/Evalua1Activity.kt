/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 10-11-20 16:21
 */
package cl.figonzal.evaluatool.evalua.evalua1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.Utilidades
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import timber.log.Timber
import java.util.*

class Evalua1Activity : AppCompatActivity(), ClickListener {

    private lateinit var sectionedRecyclerViewAdapter: SectionedRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evalua1)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorOnPrimary, theme))
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        actionBar.title = getString(R.string.TOOLBAR_EVALUA_1)

        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

        //SUBTIMES - SUBMODULO 1
        val subItems1: MutableList<Evalua> = ArrayList()
        subItems1.add(Evalua(getString(R.string.EVALUA_1_M1_SI_1)))

        //Submodulo2
        val subItems2: MutableList<Evalua> = ArrayList()
        subItems2.add(Evalua(getString(R.string.EVALUA_1_M2_SI_1)))
        subItems2.add(Evalua(getString(R.string.EVALUA_1_M2_SI_2)))
        subItems2.add(Evalua(getString(R.string.EVALUA_1_M2_SI_3)))
        subItems2.add(Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL)))

        //Submodulo3
        val subitems3: MutableList<Evalua> = ArrayList()
        subitems3.add(Evalua(getString(R.string.EVALUA_1_M3_SI_1)))

        //Submodulo4
        val subItems4: MutableList<Evalua> = ArrayList()
        subItems4.add(Evalua(getString(R.string.EVALUA_1_M4_SI_1)))
        subItems4.add(Evalua(getString(R.string.EVALUA_1_M4_SI_2)))
        subItems4.add(Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL)))
        val subItems5: MutableList<Evalua> = ArrayList()
        subItems5.add(Evalua(getString(R.string.EVALUA_1_M5_SI_1)))
        subItems5.add(Evalua(getString(R.string.EVALUA_1_M5_SI_2)))

        //Submodulo6
        val subItems6: MutableList<Evalua> = ArrayList()
        subItems6.add(Evalua(getString(R.string.EVALUA_1_M6_SI_1)))

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_1), subItems1, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_2), subItems2, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_3), subitems3, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_4), subItems4, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_5), subItems5, this))
        sectionedRecyclerViewAdapter.addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_6), subItems6, this))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = sectionedRecyclerViewAdapter
    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {

        Utilidades.handleRoutes(
                ConfigRoutes(this).getRouteMapEvalua1(),
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