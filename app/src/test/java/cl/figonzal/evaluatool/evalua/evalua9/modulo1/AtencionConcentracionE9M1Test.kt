/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 13-07-21 20:56
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo1

import cl.figonzal.evaluatool.baremosTables.atencionConcentracionE9M1Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AtencionConcentracionE9M1Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = atencionConcentracionE9M1Baremo()

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
        private const val DESVIACION = 36.65
        private const val MEDIA = 150.89

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return atencionConcentracionE9M1Baremo()
        }
    }
}