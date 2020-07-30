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
 Last modified 29-07-20 21:33                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Utilidades {

    /**
     * Funcion encargada de calcular la desviación del PD de un alumno (Metodo con implementacion
     * generica)
     *
     * @param pd_total Puntaje Directo del alumno
     * @return Desviación calculada
     */
    public static double calcularDesviacion(double MEDIA, double DESVIACION, double pd_total, boolean reverse) {
        if (!reverse) {
            return Math.round(((pd_total - MEDIA) / DESVIACION) * 100.0) / 100.0;
        } else {
            return Math.round(((MEDIA - pd_total) / DESVIACION) * 100.0) / 100.0;
        }
    }

    /**
     * Funcion encargada de calcular el nivel del alumno según el percentil obtenido (Metodo con
     * implementacion generica)
     *
     * @param percentil Percentil de posicion del alumno
     * @return Nivel asociado al percentil
     */
    public static String calcularNivel(int percentil) {
        if (percentil >= 80 && percentil <= 99) {
            return "ALTO";
        } else if (percentil >= 60 && percentil <= 79) {
            return "MEDIO-ALTO";
        } else if (percentil >= 40 && percentil <= 59) {
            return "MEDIO";
        } else if (percentil >= 20 && percentil <= 39) {
            return "MEDIO-BAJO";
        } else if (percentil >= 0 && percentil <= 19) {
            return "BAJO";
        }
        //Percentil no encontrado

        Log.d("NIVEL_CALCULADO", "nulo");

        FirebaseCrashlytics.getInstance().log("D/NIVEL_CALCULADO: " + "nulo");

        return null;
    }

    /**
     * Funcion que convierte una fecha date en un string
     *
     * @param context Contexto utilizado para el uso de strings
     * @param dFecha  Fecha que será convertida
     * @return String de la fecha
     */
    public static String dateToString(Context context, Date dFecha) {
        SimpleDateFormat mFormat =
                new SimpleDateFormat(context.getString(R.string.DATETIME_FORMAT), Locale.US);

        return mFormat.format(dFecha);
    }


    /**
     * Funcion encargada de sumar horas a un date
     *
     * @param date  Date al que se le sumaran horas
     * @param hours Horas que seran sumadas
     * @return Date con las horas ya sumadas
     */
    public static Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * Funcion encargada de generar un numero aleatorio para dialogs.
     *
     * @return Booleano con el resultado
     */
    public static boolean generateRandomNumber() {

        Random random = new Random();
        int item = random.nextInt(10);
        return item % 3 == 0;
    }

    /**
     * Funcion encargada de manejar las actividades del listado de subItems de cada Evalua
     *
     * @param routeMapEvalua               Route map con la configuracion
     * @param sectionTitle                 Titulo seccion
     * @param sectionedRecyclerViewAdapter RecyclerView seccionado
     * @param itemAdapterPosition          PosisionAdapter
     * @param currentActivity              Actividad que llama
     */
    public static void handleRoutes(Map<String, List<Object[]>> routeMapEvalua, String sectionTitle, SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter, int itemAdapterPosition, Activity currentActivity) {
        for (Map.Entry<String, List<Object[]>> entry : routeMapEvalua.entrySet()) {

            String moduleName = entry.getKey();
            List<Object[]> subItems = entry.getValue();

            if (moduleName.equals(sectionTitle)) {

                for (int i = 0; i < subItems.size(); i++) {

                    if (i == sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition)) {

                        Object[] objects = subItems.get(i);

                        Class<?> activity = (Class<?>) objects[1];
                        String titleLog = currentActivity.getString(R.string.SUB_ITEM_CLICK);
                        String responseLog = (String) objects[2];

                        abrirActividad(currentActivity, activity, titleLog, responseLog);
                    }
                }

                break;
            }
        }
    }

    /**
     * Funcion encargada de abrir las actividades
     *
     * @param activity       Actividad Padre
     * @param calledActivity Actividad hijo
     * @param log_title      Titulo del log
     * @param log_reponse    Respuesta del log
     */
    private static void abrirActividad(Activity activity, Class<?> calledActivity, String log_title, String log_reponse) {

        Log.d(log_title, log_reponse);
        FirebaseCrashlytics.getInstance().log("D/" + log_title + ": " + log_reponse);

        Intent intent = new Intent(activity, calledActivity);
        activity.startActivity(intent);
    }
}
