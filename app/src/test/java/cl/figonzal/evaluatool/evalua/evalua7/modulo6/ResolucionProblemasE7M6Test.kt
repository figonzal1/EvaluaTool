/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 05-05-21 10:16
 */

package cl.figonzal.evaluatool.evalua.evalua7.modulo6

import cl.figonzal.evaluatool.baremosTables.resolucionProblemasE7M6Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ResolucionProblemasE7M6Test(private val pd_total: Double, private val percentil_esperado: Double,
                                  private val desviacion_esperada: Double) {
    private var m1: ResolucionProblemasE7M6? = null

    @Before
    fun setUp() {
        m1 = ResolucionProblemasE7M6()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.01)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(desviacion_esperada, Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01)
    }

    companion object {
        private const val DESVIACION = 8.62
        private const val MEDIA = 10.51

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return resolucionProblemasE7M6Baremo()
        }
    }
}