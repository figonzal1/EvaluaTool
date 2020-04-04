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
 Last modified 04-04-20 18:20                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7;

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
import cl.figonzal.evaluatool.evalua7.modulo1.AtencionConcentracion;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoDeductivo;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoEspacial;
import cl.figonzal.evaluatool.evalua7.modulo2.RazonamientoInductivo;
import cl.figonzal.evaluatool.evalua7.modulo4.ComprensionLectora;
import cl.figonzal.evaluatool.evalua7.modulo4.EficaciaLectora;
import cl.figonzal.evaluatool.evalua7.modulo4.VelocidadLectora;
import cl.figonzal.evaluatool.evalua7.modulo5.ExpresionEscrita;
import cl.figonzal.evaluatool.evalua7.modulo5.OrtografiaFonetica;
import cl.figonzal.evaluatool.evalua7.modulo5.OrtografiaVisualReglada;
import cl.figonzal.evaluatool.evalua7.modulo6.CalculoNumeracion;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua7Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua7);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_7));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_7_M1_SI_1)));

        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_7_M2_SI_1)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_7_M2_SI_2)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_7_M2_SI_3)));

        List<Evalua> subItems4 = new ArrayList<>();
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M3_SI_1)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M3_SI_2)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M3_SI_3)));

        List<Evalua> subItems5 = new ArrayList<>();
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_1)));
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_2)));
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_3)));

        List<Evalua> subItems6 = new ArrayList<>();
        subItems6.add(new Evalua(getString(R.string.EVALUA_7_M5_SI_1)));

        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_3), subItems4, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_4), subItems5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_5), subItems6, this));


        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Log.d(getString(R.string.CLOSE_EVALUA_7), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_7) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
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
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {


        if (getString(R.string.EVALUA_7_MODULO_1).equals(sectionTitle)) {

            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this, AtencionConcentracion.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ATEN_CONCENTRACION)
                );
            }
        } else if (getString(R.string.EVALUA_7_MODULO_2).equals(sectionTitle)) {

            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                abrirActividad(
                        this,
                        RazonamientoDeductivo.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_RAZON_DEDUCTIVO)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        RazonamientoInductivo.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_RAZON_INDUCTIVO)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        RazonamientoEspacial.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_RAZON_ESPACIAL)
                );
            }
        } else if (getString(R.string.EVALUA_7_MODULO_3).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        EficaciaLectora.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_EFICACIA_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        ComprensionLectora.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COMPRENSION_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        VelocidadLectora.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VELOCIDAD_LECTORA)
                );
            }
        } else if (getString(R.string.EVALUA_7_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        OrtografiaFonetica.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORTOGRAFIA_FONETICA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        ExpresionEscrita.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_EXP_ESCRITA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        OrtografiaVisualReglada.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORT_VIS_REGLADA)
                );
            }
        } else if (getString(R.string.EVALUA_7_MODULO_5).equals(sectionTitle)) {

            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        CalculoNumeracion.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CAL_NUMERACION)
                );
            }
        }

    }

    @Override
    public void abrirActividad(Activity activity, Class<?> calledActivity, String log_title, String log_reponse) {
        Log.d(log_title, log_reponse);
        crashlytics.log("D/" + log_title + ": " + log_reponse);

        Intent intent = new Intent(activity, calledActivity);
        startActivity(intent);
    }
}

