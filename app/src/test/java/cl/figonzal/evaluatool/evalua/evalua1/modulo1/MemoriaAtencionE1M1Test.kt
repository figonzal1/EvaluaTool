/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 22-07-21 13:24
 */
package cl.figonzal.evaluatool.evalua.evalua1.modulo1

import cl.figonzal.evaluatool.baremosTables.memoriaAtencionE1M1Baremo
import cl.figonzal.evaluatool.utilities.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MemoriaAtencionE1M1Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {

    private val perc = memoriaAtencionE1M1Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 12.90
        private const val MEDIA = 49.39

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return memoriaAtencionE1M1Baremo()
        }
    }
}