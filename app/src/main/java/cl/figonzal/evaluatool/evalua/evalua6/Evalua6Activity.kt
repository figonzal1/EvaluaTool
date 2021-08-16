/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 16-08-21 16:35
 */

package cl.figonzal.evaluatool.evalua.evalua6

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.*
import cl.figonzal.evaluatool.databinding.ActivityEvalua6Binding
import cl.figonzal.evaluatool.interfaces.RecyclerBaseActivity
import cl.figonzal.evaluatool.model.Evalua
import cl.figonzal.evaluatool.utilities.ConfigRoutes
import cl.figonzal.evaluatool.utilities.RouteHandler
import cl.figonzal.evaluatool.utilities.configureActionBar
import cl.figonzal.evaluatool.utilities.configureFabWsp
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import timber.log.Timber

class Evalua6Activity : AppCompatActivity(), RecyclerBaseActivity, ClickListener {

    private lateinit var binding: ActivityEvalua6Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActionBar(R.string.TOOLBAR_EVALUA_6, binding.includeToolbar.materialToolbar)
        configureFabWsp(binding.fabWsp)
        configureExpandedList()
    }

    override fun configureExpandedList() {

        //MODULO 1
        val subItems1 = listOf(
            Evalua(getString(R.string.EVALUA_6_M1_SI_1)),
            Evalua(getString(R.string.EVALUA_6_M1_SI_2)),
            Evalua(getString(R.string.EVALUA_6_M1_SI_3)),
            Evalua(getString(R.string.EVALUA_6_VALORACION_GLOBAL_RAZONAMIENTO)),
            Evalua(getString(R.string.EVALUA_6_INDICE_GENERAL_COGNITIVO))
        )

        val subItems2 = listOf(
            Evalua(getString(R.string.EVALUA_6_M2_SI_1))
        )

        val subItems3 = listOf(
            Evalua(getString(R.string.EVALUA_6_M3_SI_1))
        )

        val subItems4 = listOf(
            Evalua(getString(R.string.EVALUA_6_M4_SI_1)),
            Evalua(getString(R.string.EVALUA_6_M4_SI_2)),
            Evalua(getString(R.string.EVALUA_6_VALORACION_GLOBAL_LECTURA)),
            Evalua(getString(R.string.EVALUA_6_INDICE_GENERAL_LECTURA))
        )

        val subItems5 = listOf(
            Evalua(getString(R.string.EVALUA_6_M5_SI_1)),
            Evalua(getString(R.string.EVALUA_6_INDICE_GENERAL_ESCRITURA))
        )

        val subItems6 = listOf(
            Evalua(getString(R.string.EVALUA_6_M6_SI_1)),
            Evalua(getString(R.string.EVALUA_6_M6_SI_2)),
            Evalua(getString(R.string.EVALUA_6_VALORACION_GLOBAL_MATEMATICAS)),
            Evalua(getString(R.string.EVALUA_6_INDICE_GENERAL_MATEMATICAS))
        )

        //HEADERS
        sectionedRecyclerViewAdapter.apply {
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_1),
                    subItems1,
                    this@Evalua6Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_2),
                    subItems2,
                    this@Evalua6Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_3),
                    subItems3,
                    this@Evalua6Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_4),
                    subItems4,
                    this@Evalua6Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_5),
                    subItems5,
                    this@Evalua6Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_6_MODULO_6),
                    subItems6,
                    this@Evalua6Activity
                )
            )
        }

        //RecyclerView
        binding.rv6.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }

    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua6)]?.let {
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
            Timber.d(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}