/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-05-21 18:32
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo1

import cl.figonzal.evaluatool.baremosTables.memoriayAtencionE1M1Baremo
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MemoriaAtencionE1M1Test(private val pd_total: Double, private val percentil_esperado: Double,
                              private val desviacion_esperada: Double) {
    private var m1: MemoriaAtencionE1M1? = null

    @Before
    fun setUp() {
        m1 = MemoriaAtencionE1M1()
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
        private const val DESVIACION = 12.90
        private const val MEDIA = 49.39

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return memoriayAtencionE1M1Baremo()
        }
    }
}