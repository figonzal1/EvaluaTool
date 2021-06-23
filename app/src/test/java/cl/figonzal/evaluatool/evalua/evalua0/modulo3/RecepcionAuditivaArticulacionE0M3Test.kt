/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-06-21 02:25
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo3

import cl.figonzal.evaluatool.baremosTables.recepcionAuditivaE0M3Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RecepcionAuditivaArticulacionE0M3Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {

    private val perc = recepcionAuditivaE0M3Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, Utils.calculatePercentile(perc, pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion2(MEDIA, DESVIACION, pd_total, false).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 9.01
        private const val MEDIA = 84.81

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return recepcionAuditivaE0M3Baremo()
        }
    }
}