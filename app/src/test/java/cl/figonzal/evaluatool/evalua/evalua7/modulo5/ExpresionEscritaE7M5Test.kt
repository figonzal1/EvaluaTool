/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-05-21 12:39
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo5

import cl.figonzal.evaluatool.baremosTables.expresionEscritaE7M5Baremo
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ExpresionEscritaE7M5Test(
    private val pd_total: Int, private val precentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private var m1: ExpresionEscritaE7M5? = null

    @Before
    fun setUp() {
        m1 = ExpresionEscritaE7M5()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(precentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.01)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(desviacion_esperada, calcularDesviacion(MEDIA, DESVIACION, pd_total, true), 0.01)
    }

    companion object {
        private const val DESVIACION = 0.843
        private const val MEDIA = 2.45

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return expresionEscritaE7M5Baremo()
        }
    }
}