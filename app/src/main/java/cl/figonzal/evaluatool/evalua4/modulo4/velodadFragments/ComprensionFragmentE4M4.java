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
 Last modified 17-07-20 0:55                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua4.modulo4.velodadFragments;

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

public class ComprensionFragmentE4M4 extends Fragment implements EvaluaInterface {

    private static final double DESVIACION = 4.01;
    private static final double MEDIA = 8.26;
    private final Integer[][] percentil_comprension = new Integer[][]{
            {15, 97},
            {14, 95},
            {13, 85},
            {12, 80},
            {11, 70},
            {10, 60},
            {9, 50},
            {8, 40},
            {7, 35},
            {6, 30},
            {5, 25},
            {4, 20},
            {3, 10},
            {2, 5},
            {1, 1}
    };

    private TextInputEditText et_aprobadas_t1;
    private TextInputEditText et_omitidas_t1;
    private TextInputEditText et_reprobadas_t1;
    private int aprobadas_t1 = 0;
    private int omitidas_t1 = 0;
    private int reprobadas_t1 = 0;
    private double total_pd_t1 = 0;
    //TextView para Subtotales
    private TextView tv_sub_total_t1;
    //Tetview para total
    private TextView tv_pd_total;
    private TextView tv_pd_corregido;
    private TextView tv_nivel_comprension;
    private TextView tv_percentil;
    private TextView tv_nivel;
    private ProgressBar progressBar;
    private TextView tv_desviacion_calculada;

    private FirebaseCrashlytics crashlytics;

    public ComprensionFragmentE4M4() {
        // Required empty public constructor
    }

    public static ComprensionFragmentE4M4 newInstance() {
        return new ComprensionFragmentE4M4();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comprension_e4_m4, container, false);

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
        et_omitidas_t1 = v.findViewById(R.id.et_omitidas_t1);
        et_reprobadas_t1 = v.findViewById(R.id.et_reprobadas_t1);

        //TOTAL
        tv_pd_total = v.findViewById(R.id.tv_pd_total_value);
        tv_pd_corregido = v.findViewById(R.id.tv_pd_total_corregido_value);
        tv_nivel_comprension = v.findViewById(R.id.tv_nivel_comprension_value);
        tv_percentil = v.findViewById(R.id.tv_percentil_value);
        tv_nivel = v.findViewById(R.id.tv_nivel_obtenido_value);
        tv_desviacion_calculada = v.findViewById(R.id.tv_desviacion_calculada_value);
        progressBar = v.findViewById(R.id.progressBar);

        progressBar.setMax(percentil_comprension[0][1]);

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
                total_pd_t1 = 0;
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
                total_pd_t1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
                calcularResultado();
            }
        });

        et_omitidas_t1.addTextChangedListener(new TextWatcher() {
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
                    omitidas_t1 = 0;
                } else if (s.length() > 0) {
                    omitidas_t1 = Integer.parseInt(Objects.requireNonNull(et_omitidas_t1.getText()).toString());
                }
                total_pd_t1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
                calcularResultado();

            }
        });

        et_reprobadas_t1.addTextChangedListener(new TextWatcher() {
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
                    reprobadas_t1 = 0;
                } else if (s.length() > 0) {
                    reprobadas_t1 = Integer.parseInt(Objects.requireNonNull(et_reprobadas_t1.getText()).toString());
                }
                total_pd_t1 = calcularTarea(null, tv_sub_total_t1, "Tarea 1: ", aprobadas_t1, omitidas_t1, reprobadas_t1);
                calcularResultado();
            }
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

        double total_pd;
        total_pd = total_pd_t1;

        tv_pd_total.setText(String.format(Locale.US, "%s pts", total_pd));

        double pd_corregido = corregirPD(percentil_comprension, total_pd);
        tv_pd_corregido.setText(String.format("%s pts", pd_corregido));

        String comprension = calcularComprension(pd_corregido);
        tv_nivel_comprension.setText(comprension);

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
        if (pd_total > percentil_comprension[0][0]) {
            return percentil_comprension[0][1];
        } else if (pd_total < percentil_comprension[percentil_comprension.length - 1][0]) {
            return percentil_comprension[percentil_comprension.length - 1][1];
        } else {
            for (Integer[] item : percentil_comprension) {
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
        if (pd_actual > percentil_comprension[0][0]) {
            return percentil_comprension[0][0];
        } else if (pd_actual < percentil_comprension[percentil_comprension.length - 1][0]) {
            return percentil_comprension[percentil_comprension.length - 1][0];
        } else {
            for (Integer[] item : percentil_comprension) {
                if (pd_actual == item[0]) {
                    return item[0];
                }
            }
        }
        Log.d(getString(R.string.TAG_PD_CORREGIDO), getString(R.string.PD_NULO));

        crashlytics.log(getString(R.string.TAG_PD_CORREGIDO) + getString(R.string.PD_NULO));
        return -1;
    }

    private String calcularComprension(double pd_actual) {

        if (pd_actual >= 0 && pd_actual <= 2) {
            return "Muy Baja";
        } else if (pd_actual >= 3 && pd_actual <= 4) {
            return "Baja";
        } else if (pd_actual >= 5 && pd_actual <= 6) {
            return "Media";
        } else if (pd_actual >= 7 && pd_actual <= 10) {
            return "Alta";
        } else if (pd_actual >= 11 && pd_actual <= 15) {
            return "Muy Alta";
        }

        //Percentil no encontrado
        Log.d(getString(R.string.TAG_COMPRENSION_CALCULADA), getString(R.string.COMPRENSION_NULA));

        crashlytics.log(getString(R.string.TAG_COMPRENSION_CALCULADA) + getString(R.string.COMPRENSION_NULA));
        return null;
    }
}