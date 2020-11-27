/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 1:08
 */

package cl.figonzal.evaluatool.utilidades

import android.content.Context
import cl.figonzal.evaluatool.R
import java.text.SimpleDateFormat
import java.util.*

class DateHandler {

    /**
     * Funcion que convierte una fecha date en un string
     *
     * @param context Contexto utilizado para el uso de strings
     * @param dFecha  Fecha que será convertida
     * @return String de la fecha
     */
    fun dateToString(context: Context, dFecha: Date): String {
        val mFormat = SimpleDateFormat(context.getString(R.string.DATETIME_FORMAT), Locale.US)
        return mFormat.format(dFecha)
    }


    /**
     * Funcion encargada de sumar horas a un date
     *
     * @param date  Date al que se le sumaran horas
     * @param hours Horas que seran sumadas
     * @return Date con las horas ya sumadas
     */
    fun addHoursToJavaUtilDate(date: Date, hours: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR_OF_DAY, hours)
        return calendar.time
    }
}