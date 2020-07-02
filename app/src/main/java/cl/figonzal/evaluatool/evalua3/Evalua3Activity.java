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
 Last modified 01-07-20 21:42                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3;

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
import cl.figonzal.evaluatool.evalua3.modulo1.MemoriaAtencionE3M1;
import cl.figonzal.evaluatool.evalua3.modulo2.OrganizacionPerceptivaE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.PensamientoAnalogicoE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.ReflexividadE3M2;
import cl.figonzal.evaluatool.evalua3.modulo2.ValoracionGlobalBasesE3M2;
import cl.figonzal.evaluatool.evalua3.modulo4.ComprensionLectoraE3M4;
import cl.figonzal.evaluatool.evalua3.modulo4.ExactitudLectoraE3M4;
import cl.figonzal.evaluatool.evalua3.modulo4.ValoracionGlobalLecturaE3M4;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaFoneticaE3M5;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaVisualRegladaE3M5;
import cl.figonzal.evaluatool.evalua3.modulo6.CalculoNumeracionE3M6;
import cl.figonzal.evaluatool.evalua3.modulo6.ResolucionProblemasE3M6;
import cl.figonzal.evaluatool.evalua3.modulo6.ValoracionGlobalAprenMatematE3M6;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua3Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua3);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_3));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        //SUBTIMES - SUBMODULO 1
        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_3_M1_SI_1)));

        List<Evalua> subItem2 = new ArrayList<>();
        subItem2.add(new Evalua(getString(R.string.EVALUA_3_M2_SI_1)));
        subItem2.add(new Evalua(getString(R.string.EVALUA_3_M2_SI_2)));
        subItem2.add(new Evalua(getString(R.string.EVALUA_3_M2_SI_3)));
        subItem2.add(new Evalua(getString(R.string.EVALUA_3_EVALUA_GLOBAL)));

        List<Evalua> subItem4 = new ArrayList<>();
        subItem4.add(new Evalua(getString(R.string.EVALUA_3_M4_SI_1)));
        subItem4.add(new Evalua(getString(R.string.EVALUA_3_M4_SI_2)));
        subItem4.add(new Evalua(getString(R.string.EVALUA_3_EVALUA_GLOBAL)));

        List<Evalua> subItem5 = new ArrayList<>();
        subItem5.add(new Evalua(getString(R.string.EVALUA_3_M5_SI_1)));
        subItem5.add(new Evalua(getString(R.string.EVALUA_3_M5_SI_2)));
        subItem5.add(new Evalua(getString(R.string.EVALUA_3_EVALUA_GLOBAL)));

        List<Evalua> subItem6 = new ArrayList<>();
        subItem6.add(new Evalua(getString(R.string.EVALUA_3_M6_SI_1)));
        subItem6.add(new Evalua(getString(R.string.EVALUA_3_M6_SI_2)));
        subItem6.add(new Evalua(getString(R.string.EVALUA_3_EVALUA_GLOBAL)));

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_3_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_3_MODULO_2), subItem2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_3_MODULO_4), subItem4, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_3_MODULO_5), subItem5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_3_MODULO_6), subItem6, this));

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {

        //MOdulo 1
        if (getString(R.string.EVALUA_3_MODULO_1).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        MemoriaAtencionE3M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_MEMORIA_ATENCION)
                );
            }
        }

        //MODULO 2
        else if (getString(R.string.EVALUA_3_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ReflexividadE3M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_REFLEXIVIDAD)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        PensamientoAnalogicoE3M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_PENSAMIENTO_ANALOGICO)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        OrganizacionPerceptivaE3M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORG_PERCEPTIVA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {

                abrirActividad(
                        this,
                        ValoracionGlobalBasesE3M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            }
        }

        //MODULO 4
        else if (getString(R.string.EVALUA_3_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ComprensionLectoraE3M4.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COMPR_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        ExactitudLectoraE3M4.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_EXACTITUD_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        ValoracionGlobalLecturaE3M4.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            }
        }

        //MODULO 5
        else if (getString(R.string.EVALUA_3_MODULO_5).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        OrtografiaFoneticaE3M5.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORTOGRAFIA_FONETICA)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        OrtografiaVisualRegladaE3M5.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORT_VIS_REGLADA)
                );
            }
        }

        //MODULO 6
        else if (getString(R.string.EVALUA_3_MODULO_6).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        CalculoNumeracionE3M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_NUMERACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        ResolucionProblemasE3M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_RES_PROBLEMAS)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        ValoracionGlobalAprenMatematE3M6.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
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

            Log.d(getString(R.string.CLOSE_EVALUA_3), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_3) + getString(R.string.ACTIVIDAD_CERRADA));

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
