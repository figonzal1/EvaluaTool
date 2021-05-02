/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-05-21 22:19
 */
package cl.figonzal.evaluatool.evalua.evalua1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua1Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.util.*

class Evalua1Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua1Binding
    private var sectionedRecyclerViewAdapter: SectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.EVALUA_1, binding.include.toolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        //SUBTIMES - SUBMODULO 1
        val subItems1 = listOf(
                Evalua(getString(R.string.EVALUA_1_M1_SI_1))
        )

        //Submodulo2
        val subItems2 = listOf(
                Evalua(getString(R.string.EVALUA_1_M2_SI_1)),
                Evalua(getString(R.string.EVALUA_1_M2_SI_2)),
                Evalua(getString(R.string.EVALUA_1_M2_SI_3)),
                Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL))
        )

        //Submodulo3
        val subitems3 = listOf(
                Evalua(getString(R.string.EVALUA_1_M3_SI_1))
        )

        //Submodulo4
        val subItems4 = listOf(
                Evalua(getString(R.string.EVALUA_1_M4_SI_1)),
                Evalua(getString(R.string.EVALUA_1_M4_SI_2)),
                Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL))
        )

        val subItems5 = listOf(
                Evalua(getString(R.string.EVALUA_1_M5_SI_1)),
                Evalua(getString(R.string.EVALUA_1_M5_SI_2))
        )

        //Submodulo6
        val subItems6 = listOf(
                Evalua(getString(R.string.EVALUA_1_M6_SI_1))
        )


        //HEADERS
        sectionedRecyclerViewAdapter.apply {
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_1), subItems1, this@Evalua1Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_2), subItems2, this@Evalua1Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_3), subitems3, this@Evalua1Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_4), subItems4, this@Evalua1Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_5), subItems5, this@Evalua1Activity))
            addSection(EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_6), subItems6, this@Evalua1Activity))
        }

        //Recycler View
        binding.rv1.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }

    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {

        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua1)]?.let {
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
            logInfo(R.string.ACTIVIDAD_CERRADA)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}