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

package cl.figonzal.evaluatool.evalua0.modulo3;

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

public class HabilidadesFonologicas extends AppCompatActivity implements EvaluaInterface {

    private static final double DESVIACION = 10.07;
    private static final double MEDIA = 44.73;
    //PD,PC CHILE
    private final Integer[][] perc = new Integer[][]{
            {62, 99},
            {61, 99},
            {60, 99},
            {59, 95},
            {58, 95},
            {57, 95},
            {56, 90},
            {55, 90},
            {54, 80},
            {53, 80},
            {52, 70},
            {51, 70},
            {50, 65},
            {49, 65},
            {48, 60},
            {47, 60},
            {46, 55},
            {45, 55},
            {44, 50},
            {43, 50},
            {42, 40},
            {41, 40},
            {40, 30},
            {39, 30},
            {38, 20},
            {37, 20},
            {36, 20},
            {35, 15},
            {34, 15},
            {33, 10},
            {32, 10},
            {31, 10},
            {30, 7},
            {29, 7},
            {28, 7},
            {27, 7},
            {26, 7},
            {25, 7},
            {24, 7},
            {23, 7},
            {22, 7},
            {21, 7},
            {20, 5},
            {19, 5},
            {18, 5},
            {17, 5},
            {16, 5},
            {15, 3},
            {14, 3},
            {13, 3},
            {12, 3},
            {11, 3},
            {10, 1},
            {9, 1},
            {8, 1},
            {7, 1},
            {6, 1},
            {5, 1}
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
    //TAREA 3
    private TextInputEditText et_aprobadas_t3;
    private TextView tv_sub_total_t3;
    private int aprobadas_t3 = 0;
    private double subtotal_pd_t3 = 0;
    //TAREA 4
    private TextInputEditText et_aprobadas_t4;
    private TextView tv_sub_total_t4;
    private int aprobadas_t4 = 0;
    private double subtotal_pd_t4 = 0;
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
        setContentView(R.layout.activity_habilidades_fonologicas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_HABILIDADES_FONOLOGICAS));

        instanciarRecursosInterfaz();

        textWatcherTarea1();

        textWatcherTarea2();

        textWatcherTarea3();

        textWatcherTarea4();
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

        //TAREA 3
        tv_sub_total_t3 = findViewById(R.id.tv_pd_subtotal_t3);
        et_aprobadas_t3 = findViewById(R.id.et_aprobadas_t3);

        //TAREA 4
        tv_sub_total_t4 = findViewById(R.id.tv_pd_subtotal_t4);
        et_aprobadas_t4 = findViewById(R.id.et_aprobadas_t4);

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

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 3
     */
    private void textWatcherTarea3() {
        et_aprobadas_t3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                subtotal_pd_t3 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    aprobadas_t3 = 0;
                } else if (s.length() > 0) {
                    aprobadas_t3 = Integer.parseInt(Objects.requireNonNull(et_aprobadas_t3.getText()).toString());
                }
                subtotal_pd_t3 = calcularTarea(null, tv_sub_total_t3, "Tarea 3: ", aprobadas_t3, null, null);
                calcularResultado();
            }
        });

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private void textWatcherTarea4() {
        et_aprobadas_t4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                subtotal_pd_t4 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    aprobadas_t4 = 0;
                } else if (s.length() > 0) {
                    aprobadas_t4 = Integer.parseInt(Objects.requireNonNull(et_aprobadas_t4.getText()).toString());
                }
                subtotal_pd_t4 = calcularTarea(null, tv_sub_total_t4, "Tarea 4: ", aprobadas_t4, null, null);
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
        total_pd = subtotal_pd_t1 + subtotal_pd_t2 + subtotal_pd_t3 + subtotal_pd_t4;

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

    @Override
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
            Log.d(getString(R.string.TAG_HABILIDADES_FONOLOGICAS), getString(R.string.ACTIVIDAD_CERRADA));

            Crashlytics.log(Log.DEBUG, getString(R.string.TAG_HABILIDADES_FONOLOGICAS), getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
