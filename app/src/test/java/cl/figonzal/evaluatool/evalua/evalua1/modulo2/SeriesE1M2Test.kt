/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-05-21 18:12
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo2

import cl.figonzal.evaluatool.baremosTables.seriesE1M2Baremo
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SeriesE1M2Test(private val pd_total: Double, private val percentil_esperado: Double,
                     private val desviacion_esperada: Double) {
    private var m1: SeriesE1M2? = null

    @Before
    fun setUp() {
        m1 = SeriesE1M2()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(desviacion_esperada, calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.001)
    }

    companion object {
        private const val DESVIACION = 8.00
        private const val MEDIA = 14.50

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return seriesE1M2Baremo()
        }
    }
}