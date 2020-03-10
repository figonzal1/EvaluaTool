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
 Last modified 09-03-20 17:21                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo4;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.crashlytics.android.Crashlytics;
import com.google.android.material.tabs.TabLayout;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.evalua7.modulo4.velocidadFragments.FragmentPageAdapter;

public class VelocidadLectora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_lectora);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_VELOCIDAD_LECTORA));

        //View pager
        ViewPager viewPager = findViewById(R.id.view_pager_velocidad);
        viewPager.setAdapter(new FragmentPageAdapter(getSupportFragmentManager()));

        //TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs_velocidad);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Log.d(getString(R.string.TAG_VELOCIDAD_LECTORA), getString(R.string.ACTIVIDAD_CERRADA));

            Crashlytics.log(Log.DEBUG, getString(R.string.TAG_VELOCIDAD_LECTORA), getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
