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
 Last modified 26-09-20 1:36                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua7.modulo4;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.evalua.evalua7.modulo4.velocidadFragments.FragmentStateAdapterE7M4;

public class VelocidadLectoraE7M4 extends AppCompatActivity {

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_lectora_e7_m4);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_VELOCIDAD_LECTORA));

        //View pager
        ViewPager2 viewPager2 = findViewById(R.id.view_pager_velocidad);
        viewPager2.setAdapter(new FragmentStateAdapterE7M4(this));

        //TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs_velocidad);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(FragmentStateAdapterE7M4.getTabs()[position])).attach();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Log.d(getString(R.string.TAG_VELOCIDAD_LECTORA), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.TAG_VELOCIDAD_LECTORA) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
