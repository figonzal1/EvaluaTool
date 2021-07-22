/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:53
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo5

import cl.figonzal.evaluatool.baremosTables.expresionEscritaE7M5Baremo
import cl.figonzal.evaluatool.utilities.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ExpresionEscritaE7M5Test(
    private val pd_total: Int, private val precentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = expresionEscritaE7M5Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            precentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total).toDouble(),
            0.01
        )
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pd_total, reverse = true).toDouble(),
            0.01
        )
    }

    companion object {
        private const val DESVIACION = 0.843
        private const val MEDIA = 2.45

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return expresionEscritaE7M5Baremo()
        }
    }
}