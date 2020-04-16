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
 Last modified 14-04-20 18:03                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua1;

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
import cl.figonzal.evaluatool.evalua1.modulo1.MemoriaAtencion;
import cl.figonzal.evaluatool.evalua1.modulo2.Clasificaciones;
import cl.figonzal.evaluatool.evalua1.modulo2.OrganizacionPerceptiva;
import cl.figonzal.evaluatool.evalua1.modulo2.Series;
import cl.figonzal.evaluatool.evalua1.modulo2.ValoracionInterfaceGlobalBases;
import cl.figonzal.evaluatool.evalua1.modulo4.ComprensionLectora;
import cl.figonzal.evaluatool.evalua1.modulo4.ExactitudLectora;
import cl.figonzal.evaluatool.evalua1.modulo4.ValoracionGlobalLectura;
import cl.figonzal.evaluatool.evalua1.modulo5.OrtografiaFonetica;
import cl.figonzal.evaluatool.evalua1.modulo5.OrtografiaVisual;
import cl.figonzal.evaluatool.evalua1.modulo6.CalculoNumeracion;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua1Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private FirebaseCrashlytics crashlytics;
    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua1);
        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_1));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        //SUBTIMES - SUBMODULO 1
        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_1_M1_SI_1)));

        //Submodulo2
        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_1_M2_SI_1)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_1_M2_SI_2)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_1_M2_SI_3)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL)));

        //Submodulo4
        List<Evalua> subItems4 = new ArrayList<>();
        subItems4.add(new Evalua(getString(R.string.EVALUA_1_M4_SI_1)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_1_M4_SI_2)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_1_EVALUA_GLOBAL)));

        List<Evalua> subItems5 = new ArrayList<>();
        subItems5.add(new Evalua(getString(R.string.EVALUA_1_M5_SI_1)));
        subItems5.add(new Evalua(getString(R.string.EVALUA_1_M5_SI_2)));

        //Submodulo6
        List<Evalua> subItems6 = new ArrayList<>();
        subItems6.add(new Evalua(getString(R.string.EVALUA_1_M6_SI_1)));

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_4), subItems4, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_5), subItems5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_1_MODULO_6), subItems6, this));

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {

        //MOdulo 1
        if (getString(R.string.EVALUA_1_MODULO_1).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        MemoriaAtencion.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_MEMORIA_ATENCION)
                );
            }
        }

        //Modulo 2
        else if (getString(R.string.EVALUA_1_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        Series.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_SERIES)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        Clasificaciones.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CLASIFICACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        OrganizacionPerceptiva.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORG_PERCEPTIVA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {

                abrirActividad(
                        this,
                        ValoracionInterfaceGlobalBases.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            }
        }

        //MOdulo 4
        else if (getString(R.string.EVALUA_1_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ComprensionLectora.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COMPRENSION_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                abrirActividad(
                        this,
                        ExactitudLectora.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_EXACTITUD_LECTORA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        ValoracionGlobalLectura.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_VALORACION_GLOBAL)
                );
            }
        }

        //MOdulo 5
        else if (getString(R.string.EVALUA_1_MODULO_5).equals(sectionTitle)) {
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
                        OrtografiaVisual.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORTOGRAFIA_VISUAL)
                );
            }
        }

        //Modulo6
        else if (getString(R.string.EVALUA_1_MODULO_6).equals(sectionTitle)) {
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

            Log.d(getString(R.string.CLOSE_EVALUA_1), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_1) + getString(R.string.ACTIVIDAD_CERRADA));

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
