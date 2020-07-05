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
 Last modified 05-07-20 17:08                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua2;


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
import cl.figonzal.evaluatool.evalua2.modulo1.ClasificacionesE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.IndiceGeneralCognitivoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.OrganizacionPerceptivaE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.PensamientoAnalogicoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo1.ValoracionGlobalRazonamientoE2M1;
import cl.figonzal.evaluatool.evalua2.modulo2.MemoriaAtencionE2M2;
import cl.figonzal.evaluatool.evalua2.modulo3.NivelesAdaptacionE2M3;
import cl.figonzal.evaluatool.evalua2.modulo4.ComprensionLectoraE2M4;
import cl.figonzal.evaluatool.evalua2.modulo5.OrtografiaE2M5;
import cl.figonzal.evaluatool.evalua2.modulo6.CalculoNumeracionE2M6;
import cl.figonzal.evaluatool.evalua2.modulo6.ResolucionProblemasE2M6;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua2Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua2);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_2));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_2_M1_SI_1)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_2_M1_SI_2)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_2_M1_SI_3)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_2_EVALUA_GLOBAL)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_2_INDICE_GENERAL_COGNITIVO)));

        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_2_M2_SI_1)));

        List<Evalua> subItems3 = new ArrayList<>();
        subItems3.add(new Evalua(getString(R.string.EVALUA_2_M3_SI_1)));

        List<Evalua> subItems4 = new ArrayList<>();
        subItems4.add(new Evalua(getString(R.string.EVALUA_2_M4_SI_1)));

        List<Evalua> subItems5 = new ArrayList<>();
        subItems5.add(new Evalua(getString(R.string.EVALUA_2_M5_SI_1)));

        List<Evalua> subItems6 = new ArrayList<>();
        subItems6.add(new Evalua(getString(R.string.EVALUA_2_M6_SI_1)));
        subItems6.add(new Evalua(getString(R.string.EVALUA_2_M6_SI_2)));

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_3), subItems3, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_4), subItems4, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_5), subItems5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_2_MODULO_6), subItems6, this));

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {

        //MOdulo 1
        if (getString(R.string.EVALUA_2_MODULO_1).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        PensamientoAnalogicoE2M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                abrirActividad(
                        this,
                        OrganizacionPerceptivaE2M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORG_PERCEPTIVA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        ClasificacionesE2M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CLASIFICACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {
                abrirActividad(
                        this,
                        ValoracionGlobalRazonamientoE2M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 4) {
                abrirActividad(
                        this,
                        IndiceGeneralCognitivoE2M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
                );
            }
        }

        //Modulo2
        else if (getString(R.string.EVALUA_2_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        MemoriaAtencionE2M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_MEMORIA_ATENCION)
                );
            }
        }

        //Modulo3
        else if (getString(R.string.EVALUA_2_MODULO_3).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        NivelesAdaptacionE2M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_NIVELES_ADAPTACION)
                );
            }
        }

        //Modulo4
        else if (getString(R.string.EVALUA_2_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        ComprensionLectoraE2M4.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COMPRENSION_LECTORA)
                );
            }
        }

        //Modulo5
        else if (getString(R.string.EVALUA_2_MODULO_5).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        OrtografiaE2M5.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORTOGRAFIA)
                );
            }
        }

        //Modulo6
        else if (getString(R.string.EVALUA_2_MODULO_6).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        CalculoNumeracionE2M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_NUMERACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                abrirActividad(
                        this,
                        ResolucionProblemasE2M6.class,
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

            Log.d(getString(R.string.CLOSE_EVALUA_2), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_2) + getString(R.string.ACTIVIDAD_CERRADA));

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