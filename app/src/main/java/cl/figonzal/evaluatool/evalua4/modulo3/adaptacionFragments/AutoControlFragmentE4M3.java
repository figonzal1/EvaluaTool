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
 Last modified 13-07-20 15:44                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo3.adaptacionFragments;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Locale;
import java.util.Objects;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.Utilidades;
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment;
import cl.figonzal.evaluatool.interfaces.EvaluaInterface;

public class AutoControlFragmentE4M3 extends Fragment implements EvaluaInterface {

    private static final double DESVIACION = 2.43;
    private static final double MEDIA = 3.37;
    private final Integer[][] perc = new Integer[][]{
            {0, 99},
            {1, 95},
            {2, 80},
            {3, 70},
            {4, 60},
            {5, 50},
            {6, 40},
            {7, 35},
            {8, 25},
            {9, 20},
            {10, 15},
            {11, 10},
            {12, 7},
            {13, 5},
            {14, 3},
            {15, 1},
            {16, 1},
            {17, 1},
            {18, 1},
            {19, 1},
            {20, 1},
            {22, 1},
            {24, 1},
            {26, 1},
            {28, 1},
            {30, 1}
    };
    private TextInputEditText et_aprobadas_t1;
    private int aprobadas_t1 = 0;
    private double subtotal_pd_t1;

    //TextView para Subtotales
    private TextView tv_sub_total_t1;
    //Tetview para total
    private TextView tv_pd_total;
    private TextView tv_pd_corregido;
    private TextView tv_percentil;
    private TextView tv_nivel;
    private ProgressBar progressBar;
    private TextView tv_desviacion_calculada;

    private FirebaseCrashlytics crashlytics;

    public AutoControlFragmentE4M3() {
    }

    public static AutoControlFragmentE4M3 newInstance() {
        return new AutoControlFragmentE4M3();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_auto_control_e4_m3, container, false);
        crashlytics = FirebaseCrashlytics.getInstance();

        instanciarRecursosInterfaz(v);

        textWatcherTarea1();

        return v;
    }

    /**
     * Funcion encargada de instanciar los recursos de la interfaz gráfica
     */
    private void instanciarRecursosInterfaz(View v) {

        //Promedio y desviacion
        //TetView desviacion y media
        TextView tv_media = v.findViewById(R.id.tv_media_value);
        TextView tv_desviacion = v.findViewById(R.id.tv_desviacion_value);
        tv_media.setText(String.valueOf(MEDIA));
        tv_desviacion.setText(String.valueOf(DESVIACION));

        //TAREA 1
        tv_sub_total_t1 = v.findViewById(R.id.tv_pd_subtotal_t1);
        et_aprobadas_t1 = v.findViewById(R.id.et_aprobadas_t1);

        //TOTAL
        tv_pd_total = v.findViewById(R.id.tv_pd_total_value);
        tv_pd_corregido = v.findViewById(R.id.tv_pd_total_corregido_value);
        tv_percentil = v.findViewById(R.id.tv_percentil_value);
        tv_nivel = v.findViewById(R.id.tv_nivel_obtenido_value);
        tv_desviacion_calculada = v.findViewById(R.id.tv_desviacion_calculada_value);
        progressBar = v.findViewById(R.id.progressBar);

        progressBar.setMax(perc[0][1]);

        ImageView iv_corregido = v.findViewById(R.id.iv_help_pd_corregido);
        iv_corregido.setOnClickListener(v1 -> {
            Log.d(getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            crashlytics.log(getString(R.string.DIALOGO_AYUDA) + getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            CorregidoDialogFragment dialogFragment = new CorregidoDialogFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), getString(R.string.DIALOGO_AYUDA));
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

    @Override
    public double calcularTarea(Integer n_tarea, TextView tv_sub_total, String tarea, Integer aprobadas, Integer omitidas, Integer reprobadas) {
        int total = aprobadas;

        if (total < 0) {
            total = 0;
        }

        tv_sub_total.setText(String.format(Locale.US, "%s%d pts", tarea, total));
        return total;
    }

    @Override
    public void calcularResultado() {

        //TOTALES
        double total_pd;
        total_pd = subtotal_pd_t1;

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

        double desviacion = Utilidades.calcularDesviacion(MEDIA, DESVIACION, pd_corregido, true);
        tv_desviacion_calculada.setText(String.valueOf(desviacion));
    }

    @Override
    public int calcularPercentil(double pd_total) {

        if (pd_total < perc[0][0]) {
            return perc[0][1];
        } else if (pd_total > perc[perc.length - 1][0]) {
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

        crashlytics.log(getString(R.string.TAG_PERCENTIL_CALCULADO) + getString(R.string.PERCENTIL_NULO));
        return -1;
    }

    @Override
    public double corregirPD(Integer[][] perc, double pd_actual) {
        if (pd_actual < perc[0][0]) {
            return perc[0][0];
        } else if (pd_actual > perc[perc.length - 1][0]) {
            return perc[perc.length - 1][0];
        } else {
            for (Integer[] item : perc) {
                if (pd_actual == item[0]) {
                    return item[0];
                } else if (pd_actual + 1 == item[0]) {
                    return item[0];
                } else if (pd_actual + 2 == item[0]) {
                    return item[0];
                }
            }
        }
        Log.d(getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO));

        crashlytics.log(getString(R.string.TAG_PD_CORREGIDO) + getString(R.string.PD_NULO));
        return -1;
    }
}