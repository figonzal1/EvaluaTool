/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 22:32
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo5

import cl.figonzal.evaluatool.domain.baremo_tables.ortografiaVisualRegladaE7M5Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class OrtografiaVisualRegladaE7M5Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = ortografiaVisualRegladaE7M5Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total).toDouble(),
            0.01
        )
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.01
        )
    }

    companion object {
        private const val DESVIACION = 14.49
        private const val MEDIA = 42.21

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Double>> {
            return ortografiaVisualRegladaE7M5Baremo()
        }
    }
}