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
 Last modified 01-07-20 0:05                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua0;

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
import cl.figonzal.evaluatool.evalua0.modulo1.ClasificacionE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.IndiceGeneralCognitivoE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.LetrasYNumerosE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.MemoriaVerbalE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.OrganizacionPerceptivaE0M1;
import cl.figonzal.evaluatool.evalua0.modulo1.SeriesE0M1;
import cl.figonzal.evaluatool.evalua0.modulo2.CopiaDibujosE0M2;
import cl.figonzal.evaluatool.evalua0.modulo2.GrafoMotricidadE0M2;
import cl.figonzal.evaluatool.evalua0.modulo2.IndiceGeneralEspacialE0M2;
import cl.figonzal.evaluatool.evalua0.modulo3.HabilidadesFonologicasE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.IndiceGeneralLinguisticoE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.PalabrasYFrasesE0M3;
import cl.figonzal.evaluatool.evalua0.modulo3.RecepcionAuditivaArticulacionE0M3;
import cl.figonzal.evaluatool.interfaces.AbrirActivity;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua0Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener, AbrirActivity {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua0);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_EVALUA_0));

        configurarExpandedList();
    }

    private void configurarExpandedList() {
        sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        //SUBTIMES - SUBMODULO 1
        List<Evalua> subItems1 = new ArrayList<>();
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_1)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_2)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_3)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_4)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_5)));
        subItems1.add(new Evalua(getString(R.string.EVALUA_0_M1_SI_6)));

        //SUBMODULO 2
        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_0_M2_SI_1)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_0_M2_SI_2)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_0_M2_SI_3)));

        //SUBSMODULO 3
        List<Evalua> subItems3 = new ArrayList<>();
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_1)));
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_2)));
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_3)));
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_4)));

        //HEADERS
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_0_MODULO_3), subItems3, this));

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    @Override
    public void onItemRootViewClicked(@NonNull String sectionTitle, int itemAdapterPosition) {

        //MOdulo 1
        if (getString(R.string.EVALUA_0_MODULO_1).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        ClasificacionE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_CLASIFICACION)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        SeriesE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_SERIES)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                abrirActividad(
                        this,
                        OrganizacionPerceptivaE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_ORG_PERCEPTIVA)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {

                abrirActividad(
                        this,
                        LetrasYNumerosE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_LETRAS_NUMEROS)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 4) {
                abrirActividad(
                        this,
                        MemoriaVerbalE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_MEMORIA_VERBAL)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 5) {
                abrirActividad(
                        this,
                        IndiceGeneralCognitivoE0M1.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_INDICE_GENERAL_COGNITIVO)
                );
            }

        } else if (getString(R.string.EVALUA_0_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        CopiaDibujosE0M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_COPIA_DIBUJOS)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        GrafoMotricidadE0M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_GRAFO_MOTRICIDAD)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        IndiceGeneralEspacialE0M2.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_INDICE_GENERAL_ESPACIAL)
                );
            }
        } else if (getString(R.string.EVALUA_0_MODULO_3).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                abrirActividad(
                        this,
                        PalabrasYFrasesE0M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_PALABRAS_FRASES)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                abrirActividad(
                        this,
                        RecepcionAuditivaArticulacionE0M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_RECEPCION_AUDITIVA)
                );

            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                abrirActividad(
                        this,
                        HabilidadesFonologicasE0M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_HABILIDADES_FONOLOGICAS)
                );
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {

                abrirActividad(
                        this,
                        IndiceGeneralLinguisticoE0M3.class,
                        getString(R.string.SUB_ITEM_CLICK),
                        getString(R.string.CLICK_INDICE_GENERAL_LINGUISTICO)
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

            Log.d(getString(R.string.CLOSE_EVALUA_0), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.CLOSE_EVALUA_0) + getString(R.string.ACTIVIDAD_CERRADA));

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