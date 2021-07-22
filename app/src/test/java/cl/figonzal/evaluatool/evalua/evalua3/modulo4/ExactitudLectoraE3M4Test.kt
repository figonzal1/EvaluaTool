/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 22-07-21 13:24
 */
package cl.figonzal.evaluatool.evalua.evalua3.modulo4

import cl.figonzal.evaluatool.baremosTables.exactitudLectoraE3M4Baremo
import cl.figonzal.evaluatool.utilities.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ExactitudLectoraE3M4Test(
    private val pd_total: Int,
    private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = exactitudLectoraE3M4Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 5.54
        private const val MEDIA = 33.66

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return exactitudLectoraE3M4Baremo()
        }
    }
}