/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-07-21 22:09
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo3

import cl.figonzal.evaluatool.baremosTables.autoControlFragmentE4M3Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AutoControlFragmentE4M3Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = autoControlFragmentE4M3Baremo()

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
        private const val DESVIACION = 2.43
        private const val MEDIA = 3.37

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {

            return autoControlFragmentE4M3Baremo()
        }
    }
}