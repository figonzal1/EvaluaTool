/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-07-21 15:26
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo5

import cl.figonzal.evaluatool.baremosTables.ortografiaVisualRegladaE9M5Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class OrtografiaVisualRegladaE9M5Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = ortografiaVisualRegladaE9M5Baremo()

    @Test
    fun testCalcularPercentil() {
        Assert.assertEquals(
            percentil_esperado,
            Utils.calculatePercentile(perc, pd_total).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        Assert.assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 18.83
        private const val MEDIA = 37.51

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return ortografiaVisualRegladaE9M5Baremo()
        }
    }
}