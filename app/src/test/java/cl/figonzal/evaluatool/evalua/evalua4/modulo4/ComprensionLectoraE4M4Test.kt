/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 04-05-21 16:04
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo4

import cl.figonzal.evaluatool.baremosTables.comprensionLectoraE4M4Baremo
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ComprensionLectoraE4M4Test(private val pd_total: Double, private val percentil_esperado: Double,
                                 private val desviacion_esperada: Double) {
    private var m1: ComprensionLectoraE4M4? = null

    @Before
    fun setUp() {
        m1 = ComprensionLectoraE4M4()
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
        private const val DESVIACION = 6.63
        private const val MEDIA = 21.47

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return comprensionLectoraE4M4Baremo()
        }
    }
}