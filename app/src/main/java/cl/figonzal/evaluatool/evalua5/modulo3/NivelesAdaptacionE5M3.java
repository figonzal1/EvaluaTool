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
 Last modified 27-07-20 13:53                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua5.modulo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.evalua4.modulo3.adaptacionFragments.FragmentPageAdapterE4M3;
import cl.figonzal.evaluatool.evalua5.modulo3.adaptacionFragments.FragmentPageAdapterE5M3;

public class NivelesAdaptacionE5M3 extends AppCompatActivity {

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles_adaptacion_e5_m3);
        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_NIVELES_ADAPTACION));

        //View pager
        ViewPager viewPager = findViewById(R.id.view_pager_niveles_adaptacion);
        viewPager.setAdapter(new FragmentPageAdapterE5M3(getSupportFragmentManager()));

        //TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs_niveles_adaptacion);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Log.d(getString(R.string.TAG_NIVELES_ADAPTACION), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.TAG_NIVELES_ADAPTACION) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}