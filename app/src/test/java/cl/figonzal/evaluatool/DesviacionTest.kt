/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:54
 */
package cl.figonzal.evaluatool

import cl.figonzal.evaluatool.utilities.EvaluaUtils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class DesviacionTest(
    private val media: Double,
    private val desviacion: Double,
    private val pd_total: Int,
    private val desviacion_esperada: Double
) {
    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            calcularDesviacion(media, desviacion, pd_total, false),
            0.001
        )
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<out Any>> {
            //MEDIA,DESVIACION,PD_TOTAL,DESVIACION CALCULADA
            return arrayOf(
                arrayOf(84.81, 9.01, 60, -2.75),
                arrayOf(23.21, 2.01, 25, 0.89),
                arrayOf(10.45, 4.12, 20, 2.32),
                arrayOf(42.23, 6.1, 35, -1.19),
                arrayOf(22.12, 10.1, 60, 3.75),
                arrayOf(78.48, 1.04, 75, -3.35),
                arrayOf(63.21, 10.35, 61, -0.21)
            )
        }
    }
}