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
 Last modified 14-08-20 1:09                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua7.modulo4.velocidadFragments;

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

import java.util.Objects;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.dialogs.CorregidoDialogFragment;
import cl.figonzal.evaluatool.interfaces.EvaluaInterface;
import cl.figonzal.evaluatool.utilidades.Utilidades;

public class VelocidadFragmentE7M4 extends Fragment implements EvaluaInterface {

    private static final double DESVIACION = 68.21;
    private static final double MEDIA = 257.12;
    private final Integer[][] percentil_segundos = new Integer[][]{
            {100, 99},
            {121, 97},
            {135, 95},
            {150, 90},
            {160, 85},
            {170, 80},
            {180, 75},
            {190, 70},
            {210, 65},
            {220, 60},
            {240, 55},
            {250, 50},
            {260, 40},
            {280, 30},
            {300, 20},
            {340, 10},
            {500, 5}
    };
    //TAREA 1
    private TextInputEditText et_segundos_t1;
    private int segundos_t1 = 0;
    //SUBTOTALES
    private TextView tv_sub_total_t1;
    private double total_pd_t1 = 0;
    //TOTALES
    private TextView tv_pd_total;
    private TextView tv_pd_corregido;
    private TextView tv_percentil;
    private TextView tv_nivel;
    private TextView tv_desviacion_calculada;
    private ProgressBar progressBar;

    private FirebaseCrashlytics crashlytics;

    public VelocidadFragmentE7M4() {
        // Required empty public constructor
    }

    static VelocidadFragmentE7M4 newInstance() {
        return new VelocidadFragmentE7M4();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_velocidad_e7_m4, container, false);

        crashlytics = FirebaseCrashlytics.getInstance();

        instanciarRecursosInterfaz(v);

        textWatcherTarea1();

        return v;
    }

    private void instanciarRecursosInterfaz(View v) {
        TextView tv_media = v.findViewById(R.id.tv_media_value);
        TextView tv_desviacion = v.findViewById(R.id.tv_desviacion_value);
        tv_media.setText(String.valueOf(MEDIA));
        tv_desviacion.setText(String.valueOf(DESVIACION));

        //SUBTOTALES
        tv_sub_total_t1 = v.findViewById(R.id.tv_pd_subtotal_t1);
        et_segundos_t1 = v.findViewById(R.id.et_segundos_t1);

        //TOTALES
        tv_pd_total = v.findViewById(R.id.tv_pd_total_value);
        tv_pd_corregido = v.findViewById(R.id.tv_pd_total_corregido_value);
        tv_percentil = v.findViewById(R.id.tv_percentil_value);
        tv_nivel = v.findViewById(R.id.tv_nivel_obtenido_value);
        tv_desviacion_calculada = v.findViewById(R.id.tv_desviacion_calculada_value);

        progressBar = v.findViewById(R.id.progressBar);
        progressBar.setMax(percentil_segundos[0][1]);

        ImageView iv_corregido = v.findViewById(R.id.iv_help_pd_corregido);
        iv_corregido.setOnClickListener(v1 -> {
            Log.d(getString(R.string.DIALOGO_AYUDA), getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            crashlytics.log(getString(R.string.DIALOGO_AYUDA) + getString(R.string.DIALOGO_AYUDA_MSG_ABIERTO));

            CorregidoDialogFragment dialogFragment = new CorregidoDialogFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), getString(R.string.DIALOGO_AYUDA));
        });
    }

    private void textWatcherTarea1() {
        et_segundos_t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                total_pd_t1 = 0;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 0) {
                    segundos_t1 = 0;
                } else if (s.length() > 0) {
                    segundos_t1 = Integer.parseInt(Objects.requireNonNull(et_segundos_t1.getText()).toString());
                }
                total_pd_t1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", segundos_t1, null, null);
                calcularResultado();
            }
        });

    }

    @Override
    public double calcularTarea(Integer n_tarea, TextView tv_sub_total, String tarea, Integer aprobadas, Integer omitidas, Integer reprobadas) {
        tv_sub_total.setText(String.format("%s%s seg", tarea, aprobadas));
        return aprobadas;
    }

    @Override
    public void calcularResultado() {

        double total_pd;
        total_pd = total_pd_t1;

        tv_pd_total.setText(String.format("%s seg", total_pd));


        double pd_corregido = corregirPD(percentil_segundos, total_pd);
        tv_pd_corregido.setText(String.format("%s seg", pd_corregido));

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
        if (pd_total < percentil_segundos[0][0]) {
            return percentil_segundos[0][1];
        } else if (pd_total > percentil_segundos[percentil_segundos.length - 1][0]) {
            return percentil_segundos[percentil_segundos.length - 1][1];
        } else {
            for (Integer[] item : percentil_segundos) {
                if (pd_total <= item[0]) {
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
                if (pd_actual <= item[0]) {
                    return item[0];
                }
            }
        }
        Log.d(getString(R.string.TAG_SEG_CORREGIDOS), getString(R.string.SEG_NULOS));

        crashlytics.log(getString(R.string.TAG_SEG_CORREGIDOS) + getString(R.string.SEG_NULOS));
        return -1;
    }
}
