/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 16:51                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua0;

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

import com.crashlytics.android.Crashlytics;

import java.util.ArrayList;
import java.util.List;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.adapter.EvaluaAdapter;
import cl.figonzal.evaluatool.evalua0.modulo1.Clasificacion;
import cl.figonzal.evaluatool.evalua0.modulo1.LetrasYNumeros;
import cl.figonzal.evaluatool.evalua0.modulo1.MemoriaVerbal;
import cl.figonzal.evaluatool.evalua0.modulo1.OrganizacionPerceptiva;
import cl.figonzal.evaluatool.evalua0.modulo1.Series;
import cl.figonzal.evaluatool.evalua0.modulo2.CopiaDibujos;
import cl.figonzal.evaluatool.evalua0.modulo2.GrafoMotricidad;
import cl.figonzal.evaluatool.evalua0.modulo3.HabilidadesFonologicas;
import cl.figonzal.evaluatool.evalua0.modulo3.PalabrasYFrases;
import cl.figonzal.evaluatool.evalua0.modulo3.RecepcionAuditivaArticulacion;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua0Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua0);

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

        //SUBMODULO 2
        List<Evalua> subItems2 = new ArrayList<>();
        subItems2.add(new Evalua(getString(R.string.EVALUA_0_M2_SI_1)));
        subItems2.add(new Evalua(getString(R.string.EVALUA_0_M2_SI_2)));

        //SUBSMODULO 3
        List<Evalua> subItems3 = new ArrayList<>();
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_1)));
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_2)));
        subItems3.add(new Evalua(getString(R.string.EVALUA_0_M3_SI_3)));

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

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CLASIFICACION));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CLASIFICACION));

                Intent intent = new Intent(Evalua0Activity.this, Clasificacion.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_SERIES));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_SERIES));

                Intent intent = new Intent(Evalua0Activity.this, Series.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORG_PERCEPTIVA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORG_PERCEPTIVA));

                Intent intent = new Intent(Evalua0Activity.this, OrganizacionPerceptiva.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_LETRAS_NUMEROS));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_LETRAS_NUMEROS));

                Intent intent = new Intent(Evalua0Activity.this, LetrasYNumeros.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 4) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_MEMORIA_VERBAL));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_MEMORIA_VERBAL));

                Intent intent = new Intent(Evalua0Activity.this, MemoriaVerbal.class);
                startActivity(intent);
            }
        } else if (getString(R.string.EVALUA_0_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_COPIA_DIBUJOS));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_COPIA_DIBUJOS));

                Intent intent = new Intent(Evalua0Activity.this, CopiaDibujos.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_GRAFO_MOTRICIDAD));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_GRAFO_MOTRICIDAD));

                Intent intent = new Intent(Evalua0Activity.this, GrafoMotricidad.class);
                startActivity(intent);
            }
        } else if (getString(R.string.EVALUA_0_MODULO_3).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_PALABRAS_FRASES));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_PALABRAS_FRASES));

                Intent intent = new Intent(Evalua0Activity.this, PalabrasYFrases.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_RECEPCION_AUDITIVA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_RECEPCION_AUDITIVA));

                Intent intent = new Intent(Evalua0Activity.this, RecepcionAuditivaArticulacion.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_HABILIDADES_FONOLOGICAS));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_HABILIDADES_FONOLOGICAS));

                Intent intent = new Intent(Evalua0Activity.this, HabilidadesFonologicas.class);
                startActivity(intent);
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

            Crashlytics.log(Log.DEBUG, getString(R.string.CLOSE_EVALUA_0), getString(R.string.ACTIVIDAD_CERRADA));

            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}