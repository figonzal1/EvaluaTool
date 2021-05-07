/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-05-21 17:32
 */
package cl.figonzal.evaluatool.evalua.evalua3

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.adapter.EvaluaAdapter
import cl.figonzal.evaluatool.adapter.EvaluaAdapter.ClickListener
import cl.figonzal.evaluatool.databinding.ActivityEvalua3Binding
import cl.figonzal.evaluatool.modelo.Evalua
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.RouteHandler
import cl.figonzal.evaluatool.utilidades.configActionBar
import cl.figonzal.evaluatool.utilidades.logInfo
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.util.*

class Evalua3Activity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityEvalua3Binding
    private var sectionedRecyclerViewAdapter = SectionedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvalua3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        configActionBar(R.string.TOOLBAR_EVALUA_3, binding.include.toolbar)
        configurarExpandedList()
    }

    private fun configurarExpandedList() {

        //SUBTIMES - SUBMODULO 1
        val subItems1 = listOf(
            Evalua(getString(R.string.EVALUA_3_M1_SI_1))
        )

        val subItem2 = listOf(
            Evalua(getString(R.string.EVALUA_3_M2_SI_1)),
            Evalua(getString(R.string.EVALUA_3_M2_SI_2)),
            Evalua(getString(R.string.EVALUA_3_M2_SI_3)),
            Evalua(getString(R.string.EVALUA_3_VALORACION_GLOBAL_RAZONAMIENTO))
        )

        val subItem3 = listOf(
            Evalua(getString(R.string.EVALUA_3_M3_SI_1))
        )

        val subItem4 = listOf(
            Evalua(getString(R.string.EVALUA_3_M4_SI_1)),
            Evalua(getString(R.string.EVALUA_3_M4_SI_2)),
            Evalua(getString(R.string.EVALUA_3_VALORACION_GLOBAL_LECTURA))
        )

        val subItem5 = listOf(
            Evalua(getString(R.string.EVALUA_3_M5_SI_1)),
            Evalua(getString(R.string.EVALUA_3_M5_SI_2)),
            Evalua(getString(R.string.EVALUA_2_VALORACION_GLOBAL_ESCRITURA))
        )

        val subItem6 = listOf(
            Evalua(getString(R.string.EVALUA_3_M6_SI_1)),
            Evalua(getString(R.string.EVALUA_3_M6_SI_2)),
            Evalua(getString(R.string.EVALUA_3_VALORACION_GLOBAL_MATEMATICA))
        )

        //HEADERS
        sectionedRecyclerViewAdapter.apply {

            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_1),
                    subItems1,
                    this@Evalua3Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_2),
                    subItem2,
                    this@Evalua3Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_3),
                    subItem3,
                    this@Evalua3Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_4),
                    subItem4,
                    this@Evalua3Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_5),
                    subItem5,
                    this@Evalua3Activity
                )
            )
            addSection(
                EvaluaAdapter(
                    getString(R.string.EVALUA_3_MODULO_6),
                    subItem6,
                    this@Evalua3Activity
                )
            )
        }

        //RecyclerView 3
        binding.rv3.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sectionedRecyclerViewAdapter
        }

    }

    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        ConfigRoutes.routeMap[getString(R.string.routeMapEvalua3)]?.let {
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