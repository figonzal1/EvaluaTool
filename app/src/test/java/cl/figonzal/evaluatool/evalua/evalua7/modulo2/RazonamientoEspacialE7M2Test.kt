/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-05-21 12:39
 */
package cl.figonzal.evaluatool.evalua.evalua7.modulo2

import cl.figonzal.evaluatool.baremosTables.razonamientoEspacialE7M2Baremo
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RazonamientoEspacialE7M2Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private var m1: RazonamientoEspacialE7M2? = null

    @Before
    fun setUp() {
        m1 = RazonamientoEspacialE7M2()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.01)
    }

    @Test
    fun testEjecutarEvaluacion() {
        assertEquals(desviacion_esperada, calcularDesviacion(MEDIA, DESVIACION, pd_total, false), 0.01)
    }

    companion object {
        private const val DESVIACION = 8.51
        private const val MEDIA = 20.52

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return razonamientoEspacialE7M2Baremo()
        }
    }
}