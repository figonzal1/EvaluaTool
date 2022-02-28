/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26/2/22 23:19
 */
package cl.figonzal.evaluatool

import cl.figonzal.evaluatool.utils.DateHandler.addHoursToDate
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.text.SimpleDateFormat
import java.util.*

@RunWith(Parameterized::class)
class AddHoursTest(
        private val actualDate: Date,
        private val expectDate: Date,
        private val hours: Int) {

    @Test
    fun add_hours_to_date() {
        assertEquals(expectDate, addHoursToDate(actualDate, hours))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 15:00:00"), 1),
                    arrayOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-13 14:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-03-14 14:00:00"), 24),
                    arrayOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-12-31 23:59:59"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-01-01 09:59:59"), 10),
                    arrayOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-12 08:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-13 04:00:00"), 20),
                    arrayOf(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 10:00:00"), SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-12 15:00:00"), 5)
            )
        }
    }
}