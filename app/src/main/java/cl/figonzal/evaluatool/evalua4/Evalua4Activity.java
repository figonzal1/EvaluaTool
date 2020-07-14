/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 14-07-20 12:33                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.ArrayList;
import java.util.List;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.adapter.EvaluaAdapter;
import cl.figonzal.evaluatool.evalua4.modulo1.MemoriaAtencionE4M1;
import cl.figonzal.evaluatool.evalua4.modulo2.IndiceGeneralCognitivoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.OrganizacionPerceptivaE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.PensamientoAnalogicoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.ReflexividadE4M2;
import cl.figonzal.evaluatool.evalua4.modulo2.ValoracionGlobalRazonamientoE4M2;
import cl.figonzal.evaluatool.evalua4.modulo3.NivelesAdaptacionE4M3;
import cl.figonzal.evaluatool.evalua4.modulo4.ComprensionLectoraE4M4;
import cl.figonzal.evaluatool.evalua4.modulo5.OrtografiaVisualRegladaE4M5;
import cl.figonzal.evaluatool.evalua4.modulo6.CalculoNumeracionE4M6;
import cl.figonzal.evaluatool.evalua4.modulo6.ResolucionProblemasE4M6;
import cl.figonzal.evaluatool.evalua4.modulo6.ValoracionGlobalMatematicasE4M6;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua4Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua4);
        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_4));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        //SUBTIMES - SUBMODULO 1
        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_4_M1_SI_1)));

        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_4_M2_SI_1)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_4_M2_SI_2)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_4_M2_SI_3)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_4_EVALUA_GLOBAL)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_4_M2_SI_4)));

        List<Evalua> subItems3 = new ArrayList<>();
        subItems3.add(new Evalua(getString(R.string.EVALUA_4_M3_SI_1)));

        List<Evalua> subItems4 = new ArrayList<>();
        subItems4.add(new Evalua(getString(R.string.EVALUA_4_M4_SI_1)));

        List<Evalua> subItems5 = new ArrayList<>();
        subItems5.add(new Evalua(getString(R.string.EVALUA_4_M5_SI_1)));

        List<Evalua> subItems6 = new ArrayList<>();
        subItems6.add(new Evalua(getString(R.string.EVALUA_4_M6_SI_1)));
        subItems6.add(new Evalua(getString(R.string.EVALUA_4_M6_SI_2)));
        subItems6.add(new Evalua(getString(R.string.EVALUA_4_EVALUA_GLOBAL)));

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_3), subItems3, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_4), subItems4, this));
        //TODO: Pendiente Velocidad Lectora [VL-4], valoraciones globales e indice general de lectura
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_5), subItems5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_4_MODULO_6), subItems6, this));

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {

        //MOdulo 1
        if (getString(R.string.EVALUA_4_MODULO_1).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        MemoriaAtencionE4M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_MEMORIA_ATENCION)
                );
            }
        }

        //MOdulo 2
        if (getString(R.string.EVALUA_4_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ReflexividadE4M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_REFLEXIVIDAD)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        PensamientoAnalogicoE4M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        OrganizacionPerceptivaE4M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORG_PERCEPTIVA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {

                abrirActividad(
                        this,
                        ValoracionGlobalRazonamientoE4M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 4) {

                abrirActividad(
                        this,
                        IndiceGeneralCognitivoE4M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
                );
            }
        }

        //MOdulo 3
        else if (getString(R.string.EVALUA_4_MODULO_3).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        NivelesAdaptacionE4M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_NIVELES_ADAPTACION)
                );
            }
        }

        //MOdulo 4
        else if (getString(R.string.EVALUA_4_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ComprensionLectoraE4M4.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COMPRENSION_LECTORA)
                );
            }
        }

        //MOdulo 5
        else if (getString(R.string.EVALUA_4_MODULO_5).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        OrtografiaVisualRegladaE4M5.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORT_VIS_REGLADA)
                );
            }
        }

        //MOdulo 6
        else if (getString(R.string.EVALUA_4_MODULO_6).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        CalculoNumeracionE4M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_NUMERACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        ResolucionProblemasE4M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_RES_PROBLEMAS)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        ValoracionGlobalMatematicasE4M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_RES_PROBLEMAS)
                );
            }
        }
    }

    @Override
    public void onHeaderRootViewClicked(@NonNull final EvaluaAdapter section) {

        SectionAdapter sectionAdapter = sectionedRecyclerViewAdapter.getAdapterForSection(section);

        final boolean wasExpanded = section.isExpanded();
        final int previousItemsTotal = section.getContentItemsTotal();

        section.setExpanded(!wasExpanded);
        sectionAdapter.notifyHeaderChanged();

        if (wasExpanded) {
            sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal);
        } else {
            sectionAdapter.notifyAllItemsInserted();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Log.d(getString(R.string.CLOSE_EVALUA_4), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_4) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void abrirActividad(Activity activity, Class<?> calledActivity, String log_title, String log_reponse) {

        Log.d(log_title, log_reponse);
        crashlytics.log("D/" + log_title + ": " + log_reponse);

        Intent intent = new Intent(activity, calledActivity);
        startActivity(intent);
    }

}
