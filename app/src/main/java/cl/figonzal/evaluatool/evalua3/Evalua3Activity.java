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
 Last modified 09-03-20 17:12                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua3;

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
import cl.figonzal.evaluatool.evalua3.modulo1.MemoriaAtencion;
import cl.figonzal.evaluatool.evalua3.modulo2.OrganizacionPerceptiva;
import cl.figonzal.evaluatool.evalua3.modulo2.PensamientoAnalogico;
import cl.figonzal.evaluatool.evalua3.modulo2.Reflexividad;
import cl.figonzal.evaluatool.evalua3.modulo2.ValoracionInterfaceGlobalBases;
import cl.figonzal.evaluatool.evalua3.modulo4.ComprensionLectora;
import cl.figonzal.evaluatool.evalua3.modulo4.ExactitudLectora;
import cl.figonzal.evaluatool.evalua3.modulo4.ValoracionGlobalLectura;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaFonetica;
import cl.figonzal.evaluatool.evalua3.modulo5.OrtografiaVisualReglada;
import cl.figonzal.evaluatool.evalua3.modulo5.ValoracionGlobalEscritura;
import cl.figonzal.evaluatool.evalua3.modulo6.CalculoNumeracion;
import cl.figonzal.evaluatool.evalua3.modulo6.ResolucionProblemas;
import cl.figonzal.evaluatool.evalua3.modulo6.ValoracionGlobalAprenMatemat;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Evalua3Activity extends AppCompatActivity implements EvaluaAdapter.ClickListener {

    private SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalua3);

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

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_MEMORIA_ATENCION));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_MEMORIA_ATENCION));

                Intent intent = new Intent(Evalua3Activity.this, MemoriaAtencion.class);
                startActivity(intent);
            }
        }

        //MODULO 2
        else if (getString(R.string.EVALUA_3_MODULO_2).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_REFLEXIVIDAD));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_REFLEXIVIDAD));

                Intent intent = new Intent(Evalua3Activity.this, Reflexividad.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_PENSAMIENTO_ANALOGICO));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_PENSAMIENTO_ANALOGICO));

                Intent intent = new Intent(Evalua3Activity.this, PensamientoAnalogico.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORG_PERCEPTIVA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORG_PERCEPTIVA));

                Intent intent = new Intent(Evalua3Activity.this, OrganizacionPerceptiva.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 3) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));
                Intent intent = new Intent(Evalua3Activity.this, ValoracionInterfaceGlobalBases.class);
                startActivity(intent);
            }
        }

        //MODULO 4
        else if (getString(R.string.EVALUA_3_MODULO_4).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {

                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_COMPR_LECTORA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_COMPR_LECTORA));

                Intent intent = new Intent(Evalua3Activity.this, ComprensionLectora.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_EXACTITUD_LECTORA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_EXACTITUD_LECTORA));

                Intent intent = new Intent(Evalua3Activity.this, ExactitudLectora.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Intent intent = new Intent(Evalua3Activity.this, ValoracionGlobalLectura.class);
                startActivity(intent);
            }
        }

        //MODULO 5
        else if (getString(R.string.EVALUA_3_MODULO_5).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORTOGRAFIA_FONETICA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORTOGRAFIA_FONETICA));

                Intent intent = new Intent(Evalua3Activity.this, OrtografiaFonetica.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORT_VIS_REGLADA));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_ORT_VIS_REGLADA));

                Intent intent = new Intent(Evalua3Activity.this, OrtografiaVisualReglada.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Intent intent = new Intent(Evalua3Activity.this, ValoracionGlobalEscritura.class);
                startActivity(intent);
            }
        }

        //MODULO 6
        else if (getString(R.string.EVALUA_3_MODULO_6).equals(sectionTitle)) {
            if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 0) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CAL_NUMERACION));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CAL_NUMERACION));

                Intent intent = new Intent(Evalua3Activity.this, CalculoNumeracion.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 1) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CAL_RES_PROBLEMAS));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_CAL_RES_PROBLEMAS));

                Intent intent = new Intent(Evalua3Activity.this, ResolucionProblemas.class);
                startActivity(intent);
            } else if (sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition) == 2) {
                Log.d(getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Crashlytics.log(Log.DEBUG, getString(R.string.SUB_ITEM_CLICK), getString(R.string.CLICK_VALORACION_GLOBAL));

                Intent intent = new Intent(Evalua3Activity.this, ValoracionGlobalAprenMatemat.class);
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

            Log.d(getString(R.string.CLOSE_EVALUA_3), getString(R.string.ACTIVIDAD_CERRADA));

            Crashlytics.log(Log.DEBUG, getString(R.string.CLOSE_EVALUA_3), getString(R.string.ACTIVIDAD_CERRADA));

            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
