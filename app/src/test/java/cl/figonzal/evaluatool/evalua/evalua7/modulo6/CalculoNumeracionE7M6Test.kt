/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 10-07-21 19:19
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo6

import cl.figonzal.evaluatool.baremosTables.calculoNumeracionE7M6Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion2
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CalculoNumeracionE7M6Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = calculoNumeracionE7M6Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, Utils.calculatePercentile(perc, pd_total).toDouble(), 0.01)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.01
        )
    }

    companion object {
        private const val DESVIACION = 12.29
        private const val MEDIA = 33.70

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return calculoNumeracionE7M6Baremo()
        }
    }
}