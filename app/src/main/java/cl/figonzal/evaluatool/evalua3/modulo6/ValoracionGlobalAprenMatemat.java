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

package cl.figonzal.evaluatool.evalua3.modulo6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Locale;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.interfaces.ValoracionInterface;

public class ValoracionGlobalAprenMatemat extends AppCompatActivity implements ValoracionInterface {

    //TAREA 1
    private TextInputEditText et_totales_t1;
    private TextView tv_sub_total_t1;
    private double sub_total_t1;
    //TAREA 2
    private TextInputEditText et_totales_t2;
    private TextView tv_sub_total_t2;
    private double sub_total_t2;

    private TextView tv_pd_total;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion_global_apren_matemat);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(R.string.TOOLBAR_VALORACION_GLOBAL);

        instanciarRecursosInterfaz();

        textWatcherTarea1();
    }

    private void instanciarRecursosInterfaz() {

        et_totales_t1 = findViewById(R.id.et_totales_t1);
        et_totales_t2 = findViewById(R.id.et_totales_t2);

        //SUBTOTAL
        tv_sub_total_t1 = findViewById(R.id.tv_pd_subtotal_t1);
        tv_sub_total_t2 = findViewById(R.id.tv_pd_subtotal_t2);
        //TOTAL
        tv_pd_total = findViewById(R.id.tv_pd_total_value);
    }


    private void textWatcherTarea1() {

        et_totales_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sub_total_t1 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    sub_total_t1 = 0;
                } else if (s.length() > 0 && !s.toString().equals("-") && !s.toString().equals(".")) {
                    sub_total_t1 = Double.parseDouble(String.valueOf(et_totales_t1.getText()));
                }
                tv_sub_total_t1.setText(String.format(Locale.US, "%s: %s pts", "CN", sub_total_t1));
                calcularResultado();
            }
        });

        et_totales_t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sub_total_t2 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    sub_total_t2 = 0;
                } else if (s.length() > 0 && !s.toString().equals("-") && !s.toString().equals(".")) {
                    sub_total_t2 = Double.parseDouble(String.valueOf(et_totales_t2.getText()));
                }
                tv_sub_total_t2.setText(String.format(Locale.US, "%s: %s pts", "RP", sub_total_t2));
                calcularResultado();
            }
        });
    }

    @Override
    public void calcularResultado() {
        //TOTALES
        double total_pd = sub_total_t1 + sub_total_t2;
        total_pd /= 2.0;
        total_pd = Math.round(total_pd * 100.0) / 100.0;
        tv_pd_total.setText(String.format(Locale.US, "%s pts", total_pd));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            Log.d(getString(R.string.TAG_VALORACION_GLOBAL), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.TAG_VALORACION_GLOBAL) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
