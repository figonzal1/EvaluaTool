/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:53
 */

package cl.figonzal.evaluatool.utilities

import cl.figonzal.evaluatool.R
import java.text.SimpleDateFormat
import java.util.*

object DateHandler {

    /**
     * Function that convert date to string
     *
     * @param dFecha Date that will be converted
     * @return String's date
     */
    fun dateToString(dFecha: Date): String {
        return SimpleDateFormat(EvaluaUtils.get(R.string.DATETIME_FORMAT), Locale.US).format(dFecha)
    }

    /**
     * Funcion that adds time to date
     *
     * @param date Date to which hours will be added
     * @param hours Hours added
     * @return Date with added hours
     */
    fun addHoursToDate(date: Date, hours: Int): Date {
        with(Calendar.getInstance(), {
            this.time = date
            this.add(Calendar.HOUR_OF_DAY, hours)
            return time
        })
    }
}