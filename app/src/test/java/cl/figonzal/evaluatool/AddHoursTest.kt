/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 25-04-21 15:50
 */
package cl.figonzal.evaluatool

import cl.figonzal.evaluatool.utilidades.DateHandler.addHoursToDate
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@RunWith(Parameterized::class)
class AddHoursTest(
        private val actualDate: Date,
        private val expectDate: Date,
        private val hours: Int) {

    @Test
    fun add_hours_to_date() {
        TestCase.assertEquals(expectDate, addHoursToDate(actualDate, hours))
    }

    companion object {
        @Parameterized.Parameters(name = "{index}: {0} = addHoursToJavaUtilDate({1},{2})")
        @Throws(ParseException::class)
        fun data(): List<Any> {
            return listOf(
                    listOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 15:00:00"), 1),
                    listOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-14 14:00:00"), 24),
                    listOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-12-31 23:59:59"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-01-01 09:59:59"), 10),
                    listOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-12 08:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-13 04:00:00"), 20),
                    listOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 10:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 15:00:00"), 5))
        }
    }
}