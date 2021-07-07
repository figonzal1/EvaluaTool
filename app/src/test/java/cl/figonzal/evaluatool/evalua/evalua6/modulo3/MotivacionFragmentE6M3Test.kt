/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-07-21 17:13
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo3

import cl.figonzal.evaluatool.baremosTables.motivacionFragmentE6M3Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MotivacionFragmentE6M3Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = motivacionFragmentE6M3Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            Utils.calculatePercentile(perc, pd_total, reverse = true).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion2(MEDIA, DESVIACION, pd_total, reverse = true).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 4.32
        private const val MEDIA = 7.16

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return motivacionFragmentE6M3Baremo()
        }
    }
}