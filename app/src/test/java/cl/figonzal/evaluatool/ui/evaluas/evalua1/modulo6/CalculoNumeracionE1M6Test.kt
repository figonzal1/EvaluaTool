/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 10:23
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo6

import cl.figonzal.evaluatool.domain.baremo_tables.calculoNumeracionE1M6Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CalculoNumeracionE1M6Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = calculoNumeracionE1M6Baremo()

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
        private const val DESVIACION = 8.83
        private const val MEDIA = 31.08

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return calculoNumeracionE1M6Baremo()
        }
    }
}