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

package cl.figonzal.evaluatool.evalua3.modulo6;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.crashlytics.android.Crashlytics;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.Objects;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment;
import cl.figonzal.evaluatool.interfaces.EvaluaInterface;

public class CalculoNumeracion extends AppCompatActivity implements EvaluaInterface {

    private static final double DESVIACION = 6.50;
    private static final double MEDIA = 19.56;
    //PD,PC CHILE
    private final Integer[][] perc = new Integer[][]{
            {34, 99},
            {33, 98},
            {32, 97},
            {31, 95},
            {30, 92},
            {29, 87},
            {28, 85},
            {27, 82},
            {26, 77},
            {25, 75},
            {24, 70},
            {23, 65},
            {22, 60},
            {21, 55},
            {20, 50},
            {19, 45},
            {18, 42},
            {17, 40},
            {16, 35},
            {15, 30},
            {14, 25},
            {13, 20},
            {12, 15},
            {11, 12},
            {10, 10},
            {9, 7},
            {8, 5},
            {7, 3},
            {6, 1}
    };
    //TAREA 1
    private TextInputEditText et_aprobadas_t1;
    private TextView tv_sub_total_t1;
    private int aprobadas_t1 = 0;
    private double subtotal_pd_t1 = 0;
    //TAREA 2
    private TextInputEditText et_aprobadas_t2;
    private TextView tv_sub_total_t2;
    private int aprobadas_t2 = 0;
    private double subtotal_pd_t2 = 0;
    //Tetview para total
    private TextView tv_pd_total;
    private TextView tv_pd_corregido;
    private TextView tv_percentil;
    private TextView tv_nivel;
    private TextView tv_desviacion_calculada;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_numeracion2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_CALC_NUMERACION));

        instanciarRecursosInterfaz();

        textWatcherTarea1();

        textWatcherTarea2();
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private void instanciarRecursosInterfaz() {

        //Promedio y desviacion
        TextView tv_media = findViewById(R.id.tv_media_value);
        TextView tv_desviacion = findViewById(R.id.tv_desviacion_value);
        tv_media.setText(String.valueOf(MEDIA));
        tv_desviacion.setText(String.valueOf(DESVIACION));

        //TAREA 1
        tv_sub_total_t1 = findViewById(R.id.tv_pd_subtotal_t1);
        et_aprobadas_t1 = findViewById(R.id.et_aprobadas_t1);

        //TAREA 2
        tv_sub_total_t2 = findViewById(R.id.tv_pd_subtotal_t2);
        et_aprobadas_t2 = findViewById(R.id.et_aprobadas_t2);

        //TOTAL
        tv_pd_total = findViewById(R.id.tv_pd_total_value);
        tv_pd_corregido = findViewById(R.id.tv_pd_total_corregido_value);
        tv_percentil = findViewById(R.id.tv_percentil_value);
        tv_nivel = findViewById(R.id.tv_nivel_obtenido_value);
        tv_desviacion_calculada = findViewById(R.id.tv_desviacion_calculada_value);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(perc[0][1]);

        ImageView iv_corregido = findViewById(R.id.iv_help_pd_corregido);
        iv_corregido.setOnClickListener(v -> {
            Log.d(getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            Crashlytics.log(Log.DEBUG, getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            CorregidoDialogFragment dialogFragment = new CorregidoDialogFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getSupportFragmentManager(), getString(R.string.DIALOGO_AYUDA));
        });
    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private void textWatcherTarea1() {
        et_aprobadas_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                subtotal_pd_t1 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    aprobadas_t1 = 0;
                } else if (s.length() > 0) {
                    aprobadas_t1 = Integer.parseInt(Objects.requireNonNull(et_aprobadas_t1.getText()).toString());
                }
                subtotal_pd_t1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, null, null);
                calcularResultado();
            }
        });

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 2
     */
    private void textWatcherTarea2() {
        et_aprobadas_t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                subtotal_pd_t2 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    aprobadas_t2 = 0;
                } else if (s.length() > 0) {
                    aprobadas_t2 = Integer.parseInt(Objects.requireNonNull(et_aprobadas_t2.getText()).toString());
                }
                subtotal_pd_t2 = calcularTarea(null, tv_sub_total_t2, "Tarea 2: ", aprobadas_t2, null, null);
                calcularResultado();
            }
        });

    }

    @Override
    public double calcularTarea(Integer n_tarea, TextView tv_sub_total, String tarea, Integer aprobadas, Integer omitidas, Integer reprobadas) {
        double total = aprobadas;
        total = Math.floor(total);
        tv_sub_total.setText(String.format(Locale.US, "%s%s pts", tarea, total));
        return total;
    }

    @Override
    public void calcularResultado() {

        double total_pd;
        total_pd = subtotal_pd_t1 + subtotal_pd_t2;

        tv_pd_total.setText(String.format(Locale.US, "%s pts", total_pd));

        double pd_corregido = corregirPD(perc, total_pd);
        tv_pd_corregido.setText(String.format("%s pts", pd_corregido));
        int percentil = calcularPercentil(pd_corregido);
        tv_percentil.setText(String.valueOf(percentil));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            progressBar.setProgress(percentil, true);
        } else {
            progressBar.setProgress(percentil);
        }
        String nivel = Utilidades.calcularNivel(percentil);
        tv_nivel.setText(nivel);

        double desviacion = Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_corregido, false);
        tv_desviacion_calculada.setText(String.valueOf(desviacion));
    }

    public int calcularPercentil(double pd_total) {

        //Limite superior
        if (pd_total > perc[0][0]) {
            return perc[0][1];
        }
        //Limite inferior
        else if (pd_total < perc[perc.length - 1][0]) {
            return perc[perc.length - 1][1];
        } else {
            for (Integer[] item : perc) {
                if (pd_total == item[0]) {
                    return item[1];
                }
            }
        }

        //Percentil no encontrado
        Log.d(getString(R.string.TAG_PERCENTIL_CALCULADO), getString(R.string.PERCENTIL_NULO));

        Crashlytics.log(Log.DEBUG, getString(R.string.TAG_PERCENTIL_CALCULADO), getString(R.string.PERCENTIL_NULO));
        return -1;
    }

    @Override
    public double corregirPD(Integer[][] perc, double pd_actual) {
        if (pd_actual < 0) {
            return 0;
        } else if (pd_actual > perc[0][0]) {
            return perc[0][0];
        } else if (pd_actual < perc[perc.length - 1][0]) {
            return perc[perc.length - 1][0];
        } else {
            //Verificar si pd_actual esta en la lista
            for (Integer[] item : perc) {
                if (pd_actual == item[0]) {
                    return item[0];
                }
            }
        }
        Log.d(getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO));

        Crashlytics.log(Log.DEBUG, getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO));
        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Log.d(getString(R.string.TAG_CALCU_NUMERACION), getString(R.string.ACTIVIDAD_CERRADA));

            Crashlytics.log(Log.DEBUG, getString(R.string.TAG_CALCU_NUMERACION), getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
