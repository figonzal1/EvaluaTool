/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-07-21 21:25
 */

package cl.figonzal.evaluatool.evalua.evalua1.modulo3

import cl.figonzal.evaluatool.baremosTables.autoEstimaFragmentE1M3Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AutoEstimaFragmentE1M3Test(
    private val pd_total: Int,
    private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {

    private val perc = autoEstimaFragmentE1M3Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, Utils.calculatePercentile(perc, pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 4.93
        private const val MEDIA = 21.78

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return autoEstimaFragmentE1M3Baremo()
        }
    }
}