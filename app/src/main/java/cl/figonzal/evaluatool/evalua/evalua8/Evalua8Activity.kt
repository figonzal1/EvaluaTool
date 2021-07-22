/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:49
 */

package cl.figonzal.evaluatool.evalua.evalua8

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.databinding.ActivityEvalua8Binding
import cl.figonzal.evaluatool.model.Evalua
import cl.figonzal.evaluatool.utilities.ConfigRoutes
import cl.figonzal.evaluatool.utilities.RouteHandler
import cl.figonzal.evaluatool.utilities.configActionBar
import cl.figonzal.evaluatool.utilities.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter

class Evalua8Activity : AppCompatActivity(), EvaluaAdapter.ClickListener {

    private lateinit var binding: ActivityEvalua8Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_EVALUA_8, binding.includeToolbar.materialToolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        val subItems1 = listOf(
            Evalua(getString(R.string.EVALUA_8_M1_SI_1))
        )

        val subItems2 = listOf(
            Evalua(getString(R.string.EVALUA_8_M2_SI_1)),
            Evalua(getString(R.string.EVALUA_8_M2_SI_2)),
            Evalua(getString(R.string.EVALUA_8_M2_SI_3)),
            Evalua(getString(R.string.EVALUA_8_VALORACION_GLOBAL_RAZONAMIENTO)),
            Evalua(getString(R.string.EVALUA_8_INDICE_GENERAL_COGNITIVO))

        )

        val subItems3 = listOf(
            Evalua(getString(R.string.EVALUA_8_M3_SI_1))
        )

        val subItems4 = listOf(
            Evalua(getString(R.string.EVALUA_8_M4_SI_1)),
            Evalua(getString(R.string.EVALUA_8_M4_SI_2)),
            Evalua(getString(R.string.EVALUA_8_M4_SI_3)),
            Evalua(getString(R.string.EVALUA_8_INDICE_GENERAL_LECTURA)),
        )

        val subItems5 = listOf(
            Evalua(getString(R.string.EVALUA_8_M5_SI_1)),
            Evalua(getString(R.string.EVALUA_8_INDICE_GENERAL_ESCRITURA)),
        )

        val subItems6 = listOf(
            Evalua(getString(R.string.EVALUA_8_M6_SI_1)),
            Evalua(getString(R.string.EVALUA_8_M6_SI_2)),
            Evalua(getString(R.string.EVALUA_8_VALORACION_GLOBAL_MATEMATICAS)),
            Evalua(getString(R.string.EVALUA_8_INDICE_GENERAL_MATEMATICAS)),
        )


        sectionedRecyclerViewAdapter.apply {
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_1),
                    subItems1,
                    this@Evalua8Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_2),
                    subItems2,
                    this@Evalua8Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_3),
                    subItems3,
                    this@Evalua8Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_4),
                    subItems4,
                    this@Evalua8Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_5),
                    subItems5,
                    this@Evalua8Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_8_MODULO_6),
                    subItems6,
                    this@Evalua8Activity
                )
            )
        }

        //RecyclerView
        binding.rv8.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }
    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua8)]?.let {
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