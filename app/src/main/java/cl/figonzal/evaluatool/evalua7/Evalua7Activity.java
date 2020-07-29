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
 Last modified 29-07-20 2:31                                                  -
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

import cl.figonzal.evaluatool.ConfigRoutes;
import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.adapter.EvaluaAdapter;
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
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_1)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_2)));
        subItems4.add(new Evalua(getString(R.string.EVALUA_7_M4_SI_3)));

        List<Evalua> subItems5 = new ArrayList<>();
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M5_SI_1)));
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M5_SI_2)));
        subItems5.add(new Evalua(getString(R.string.EVALUA_7_M5_SI_3)));

        List<Evalua> subItems6 = new ArrayList<>();
        subItems6.add(new Evalua(getString(R.string.EVALUA_7_M6_SI_1)));
        subItems6.add(new Evalua(getString(R.string.EVALUA_7_M6_SI_2)));

        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_1), subItems1, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_2), subItems2, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_4), subItems4, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_5), subItems5, this));
        sectionedRecyclerViewAdapter.addSection(new EvaluaAdapter(getString(R.string.EVALUA_7_MODULO_6), subItems6, this));


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

        Utilidades.handleRoutes(
                new ConfigRoutes(this).getRouteMapEvalua7(),
                sectionTitle,
                sectionedRecyclerViewAdapter,
                itemAdapterPosition,
                this
        );
    }

    @Override
    public void abrirActividad(Activity activity, Class<?> calledActivity, String log_title, String log_reponse) {
        Log.d(log_title, log_reponse);
        crashlytics.log("D/" + log_title + ": " + log_reponse);

        Intent intent = new Intent(activity, calledActivity);
        startActivity(intent);
    }
}

