/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-04-21 22:17
 */
package cl.figonzal.evaluatool.evalua.evalua5

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua5Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.util.*

class Evalua5Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua5Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.include.toolbar)

        configActionBar(R.string.TOOLBAR_EVALUA_5, binding.include.toolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        //MODULO 1
        val subItems1 = listOf(
                Evalua(getString(R.string.EVALUA_5_M1_SI_1))
        )

        val subItems2 = listOf(
                Evalua(getString(R.string.EVALUA_5_M2_SI_1)),
                Evalua(getString(R.string.EVALUA_5_M2_SI_2)),
                Evalua(getString(R.string.EVALUA_5_M2_SI_3)),
                Evalua(getString(R.string.EVALUA_5_EVALUA_GLOBAL))
        )

        //modulo 3
        val subItems3 = listOf(
                Evalua(getString(R.string.EVALUA_5_M3_SI_1))
        )

        //Modulo 4
        val subItems4 = listOf(
                Evalua(getString(R.string.EVALUA_5_M4_SI_1)),
                Evalua(getString(R.string.EVALUA_5_M4_SI_2)),
                Evalua(getString(R.string.EVALUA_5_M4_SI_3)),
                Evalua(getString(R.string.EVALUA_5_EVALUA_GLOBAL))
        )

        //MODULO 5
        val subItems5 = listOf(
                Evalua(getString(R.string.EVALUA_5_M5_SI_1)),
                Evalua(getString(R.string.EVALUA_5_M5_SI_2))
        )

        //MODULO 6
        val subItems6 = listOf(
                Evalua(getString(R.string.EVALUA_5_M6_SI_1)),
                Evalua(getString(R.string.EVALUA_5_M6_SI_2))
        )

        //HEADERS
        sectionedRecyclerViewAdapter.apply {
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_1), subItems1, this@Evalua5Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_2), subItems2, this@Evalua5Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_3), subItems3, this@Evalua5Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_4), subItems4, this@Evalua5Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_5), subItems5, this@Evalua5Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_5_MODULO_6), subItems6, this@Evalua5Activity))
        }

        //RecyclerView
        binding.rv5.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }

    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua5)]?.let {
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