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
 Last modified 04-04-20 17:32                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.content.Context;
import android.util.Log;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Utilidades {

    private static FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();

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

        crashlytics.log("D/NIVEL_CALCULADO: " + "nulo");

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
}
