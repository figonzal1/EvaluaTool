/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-05-21 22:19
 */
package cl.figonzal.evaluatool.evalua.evalua4

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua4Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.util.*

class Evalua4Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua4Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_EVALUA_4, binding.include.toolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        //SUBTIMES - SUBMODULO 1
        val subItems1 = listOf(
                Evalua(getString(R.string.EVALUA_4_M1_SI_1))
        )

        val subItems2 = listOf(
                Evalua(getString(R.string.EVALUA_4_M2_SI_1)),
                Evalua(getString(R.string.EVALUA_4_M2_SI_2)),
                Evalua(getString(R.string.EVALUA_4_M2_SI_3)),
                Evalua(getString(R.string.EVALUA_4_EVALUA_GLOBAL)),
                Evalua(getString(R.string.EVALUA_4_M2_SI_4))
        )

        val subItems3 = listOf(
                Evalua(getString(R.string.EVALUA_4_M3_SI_1))
        )

        val subItems4 = listOf(
                Evalua(getString(R.string.EVALUA_4_M4_SI_1)),
                Evalua(getString(R.string.EVALUA_4_M4_SI_2)),
                Evalua(getString(R.string.EVALUA_4_EVALUA_GLOBAL)),
                Evalua(getString(R.string.EVALUA_4_M4_SI_3))
        )

        val subItems5 = listOf(
                Evalua(getString(R.string.EVALUA_4_M5_SI_1))
        )

        val subItems6 = listOf(
                Evalua(getString(R.string.EVALUA_4_M6_SI_1)),
                Evalua(getString(R.string.EVALUA_4_M6_SI_2)),
                Evalua(getString(R.string.EVALUA_4_EVALUA_GLOBAL)),
                Evalua(getString(R.string.EVALUA_4_M6_SI_4))
        )

        //HEADERS
        sectionedRecyclerViewAdapter.apply {
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_1), subItems1, this@Evalua4Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_2), subItems2, this@Evalua4Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_3), subItems3, this@Evalua4Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_4), subItems4, this@Evalua4Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_5), subItems5, this@Evalua4Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_6), subItems6, this@Evalua4Activity))
        }

        //RecyclerView
        binding.rv4.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }

    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua4)]?.let {
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