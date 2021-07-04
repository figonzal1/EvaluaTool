/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-07-21 20:54
 */
package cl.figonzal.evaluatool.evalua.evalua0.modulo1

import cl.figonzal.evaluatool.baremosTables.letrasyNumerosE0M1Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion2
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class LetrasYNumerosE0M1Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {

    private val perc = letrasyNumerosE0M1Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, Utils.calculatePercentile(perc, pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 2.91
        private const val MEDIA = 26.02

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return letrasyNumerosE0M1Baremo()
        }
    }
}