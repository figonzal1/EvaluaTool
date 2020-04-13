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
 Last modified 13-04-20 17:57                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo1;

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

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Locale;
import java.util.Objects;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment;
import cl.figonzal.evaluatool.interfaces.EvaluaInterface;

public class AtencionConcentracion extends AppCompatActivity implements EvaluaInterface {

    private static final double DESVIACION = 28.04;
    private static final double MEDIA = 115.68;
    private final Integer[][] perc = new Integer[][]{
            {192, 185, 99},
            {184, 180, 95},
            {179, 175, 90},
            {174, 170, 87},
            {169, 165, 85},
            {164, 160, 80},
            {159, 155, 78},
            {154, 150, 75},
            {149, 145, 72},
            {144, 140, 70},
            {139, 135, 65},
            {134, 130, 63},
            {129, 125, 60},
            {124, 120, 55},
            {119, 115, 50},
            {114, 110, 45},
            {109, 105, 40},
            {104, 100, 35},
            {99, 95, 30},
            {94, 90, 25},
            {89, 85, 18},
            {84, 80, 15},
            {79, 75, 12},
            {74, 70, 10},
            {69, 65, 9},
            {64, 60, 7},
            {59, 55, 5},
            {54, 50, 3},
            {49, 45, 1}
    };
    private TextInputEditText et_aprobadas_t1;
    private TextInputEditText et_omitidas_t1;
    private TextInputEditText et_reprobadas_t1;
    private TextInputEditText et_aprobadas_t2;
    private TextInputEditText et_omitidas_t2;
    private TextInputEditText et_reprobadas_t2;
    //TextView para Subtotales
    private TextView tv_sub_total_t1;
    private TextView tv_sub_total_t2;
    //Parciales Tarea 1
    private int aprobadas_t1 = 0;
    private int omitidas_t1 = 0;
    private int reprobadas_t1 = 0;
    //Parciales para Tarea 2
    private int aprobadas_t2 = 0;
    private int omitidas_t2 = 0;
    private int reprobadas_t2 = 0;
    //Tetview para total
    private TextView tv_pd_total;
    private TextView tv_pd_corregido;
    private TextView tv_percentil;
    private TextView tv_nivel;
    private ProgressBar progressBar;
    private TextView tv_desviacion_calculada;
    private double total_pd_tarea1 = 0;
    private double total_pd_tarea2 = 0;

    private FirebaseCrashlytics crashlytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atencion_concentracion);

        crashlytics = FirebaseCrashlytics.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorOnPrimary, getTheme()));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        actionBar.setTitle(getString(R.string.TOOLBAR_ATENCION_CONCENTRACION));

        instanciarRecursosInterfaz();

        textWatcherTarea1();

        textWatcherTarea2();

    }

    /**
     * Funcion encargada de la logica de los TextWatcher de la tarea 1
     */
    private void textWatcherTarea1() {

        et_aprobadas_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_tarea1 = 0;
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
                total_pd_tarea1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
                calcularResultado();
            }
        });

        et_omitidas_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_tarea1 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 0) {
                    omitidas_t1 = 0;
                } else if (s.length() > 0) {
                    omitidas_t1 = Integer.parseInt(Objects.requireNonNull(et_omitidas_t1.getText()).toString());
                }
                total_pd_tarea1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
                calcularResultado();

            }
        });

        et_reprobadas_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_tarea1 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    reprobadas_t1 = 0;
                } else if (s.length() > 0) {
                    reprobadas_t1 = Integer.parseInt(Objects.requireNonNull(et_reprobadas_t1.getText()).toString());
                }
                total_pd_tarea1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
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
                total_pd_tarea2 = 0;
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
                total_pd_tarea2 = calcularTarea(null, tv_sub_total_t2, "Tarea 2: ", aprobadas_t2, omitidas_t2, reprobadas_t2);
                calcularResultado();
            }
        });

        et_omitidas_t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_tarea2 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 0) {
                    omitidas_t2 = 0;
                } else if (s.length() > 0) {
                    omitidas_t2 = Integer.parseInt(Objects.requireNonNull(et_omitidas_t2.getText()).toString());
                }
                total_pd_tarea2 = calcularTarea(null, tv_sub_total_t2, "Tarea 2: ", aprobadas_t2, omitidas_t2, reprobadas_t2);
                calcularResultado();
            }
        });

        et_reprobadas_t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_tarea2 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    reprobadas_t2 = 0;
                } else if (s.length() > 0) {
                    reprobadas_t2 = Integer.parseInt(Objects.requireNonNull(et_reprobadas_t2.getText()).toString());
                }
                total_pd_tarea2 = calcularTarea(null, tv_sub_total_t2, "Tarea 2: ", aprobadas_t2, omitidas_t2, reprobadas_t2);
                calcularResultado();
            }
        });
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private void instanciarRecursosInterfaz() {

        //Promedio y desviacion
        //TetView desviacion y media
        TextView tv_media = findViewById(R.id.tv_media_value);
        TextView tv_desviacion = findViewById(R.id.tv_desviacion_value);
        tv_media.setText(String.valueOf(MEDIA));
        tv_desviacion.setText(String.valueOf(DESVIACION));

        //TAREA 1
        tv_sub_total_t1 = findViewById(R.id.tv_pd_subtotal_t1);
        et_aprobadas_t1 = findViewById(R.id.et_aprobadas_t1);
        et_omitidas_t1 = findViewById(R.id.et_omitidas_t1);
        et_reprobadas_t1 = findViewById(R.id.et_reprobadas_t1);

        //TAREA 2
        tv_sub_total_t2 = findViewById(R.id.tv_pd_subtotal_t2);
        et_aprobadas_t2 = findViewById(R.id.et_aprobadas_t2);
        et_omitidas_t2 = findViewById(R.id.et_omitidas_t2);
        et_reprobadas_t2 = findViewById(R.id.et_reprobadas_t2);

        //TOTAL
        tv_pd_total = findViewById(R.id.tv_pd_total_value);
        tv_pd_corregido = findViewById(R.id.tv_pd_total_corregido_value);
        tv_percentil = findViewById(R.id.tv_percentil_value);
        tv_nivel = findViewById(R.id.tv_nivel_obtenido_value);
        tv_desviacion_calculada = findViewById(R.id.tv_desviacion_calculada_value);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(perc[0][2]);

        ImageView iv_corregido = findViewById(R.id.iv_help_pd_corregido);
        iv_corregido.setOnClickListener(v -> {
            Log.d(getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            crashlytics.log(getString(R.string.DIALOGO_AYUDA) + getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            CorregidoDialogFragment dialogFragment = new CorregidoDialogFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getSupportFragmentManager(), getString(R.string.DIALOGO_AYUDA));
        });
    }

    @Override
    public double calcularTarea(Integer n_tarea, TextView tv_sub_total, String tarea, Integer aprobadas, Integer omitidas, Integer reprobadas) {
        int total = aprobadas - (omitidas + reprobadas);

        if (total < 0) {
            total = 0;
        }

        tv_sub_total.setText(String.format(Locale.US, "%s%d pts", tarea, total));
        return total;
    }

    @Override
    public void calcularResultado() {

        double total_pd = total_pd_tarea1 + total_pd_tarea2;

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

        //Limite Superior
        // Si alumno sobrepasa tabla de percentil
        // Retornar percentil mas alto
        if (pd_total > perc[0][0]) {
            return perc[0][2];
        }
        //Limite inferior
        //Si alumno subpasa tabla de percentil
        //Retornar percentil mas bajo
        else if (pd_total < perc[perc.length - 1][1]) {
            return perc[perc.length - 1][2];
        } else {
            for (Integer[] item : perc) {
                int maximo = item[0];
                int minimo = item[1];
                if (pd_total <= maximo && pd_total >= minimo) {
                    return item[2];
                }
            }
        }
        //Percentil no encontrado
        Log.d(getString(R.string.TAG_PERCENTIL_CALCULADO), getString(R.string.PERCENTIL_NULO));

        crashlytics.log(getString(R.string.TAG_PERCENTIL_CALCULADO) + getString(R.string.PERCENTIL_NULO));

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
                if (pd_actual <= item[0] && pd_actual >= item[1]) {
                    return pd_actual;
                }
            }
        }

        Log.d(getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO));

        crashlytics.log(getString(R.string.TAG_PD_CORREGIDO) + getString(R.string.PD_NULO));

        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            Log.d(getString(R.string.TAG_ATENCION_CONCENTRACION), getString(R.string.ACTIVIDAD_CERRADA));

            crashlytics.log(getString(R.string.TAG_ATENCION_CONCENTRACION) + getString(R.string.ACTIVIDAD_CERRADA));

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
