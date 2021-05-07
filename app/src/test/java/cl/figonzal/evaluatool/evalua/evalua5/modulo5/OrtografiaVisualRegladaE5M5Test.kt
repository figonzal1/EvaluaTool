/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-05-21 12:37
 */

package cl.figonzal.evaluatool.evalua.evalua5.modulo5

import cl.figonzal.evaluatool.baremosTables.ortografiaVisualRegladaE5M5Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class OrtografiaVisualRegladaE5M5Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private var m1: OrtografiaVisualRegladaE5M5? = null

    @Before
    fun setUp() {
        m1 = OrtografiaVisualRegladaE5M5()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, false),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 13.45
        private const val MEDIA = 34.57

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return ortografiaVisualRegladaE5M5Baremo()
        }
    }
}