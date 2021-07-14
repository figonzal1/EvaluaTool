/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-07-21 18:05
 */

package cl.figonzal.evaluatool.evalua.evalua9.modulo4

import cl.figonzal.evaluatool.baremosTables.velocidadFragmentE9M4Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class VelocidadFragmentE9M4Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = velocidadFragmentE9M4Baremo()

    @Test
    fun testCalcularPercentil() {
        Assert.assertEquals(
            percentil_esperado,
            Utils.calculatePercentile(perc, pd_total, reverse = true).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        Assert.assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion2(MEDIA, DESVIACION, pd_total, reverse = true).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 74.13
        private const val MEDIA = 203.58

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return velocidadFragmentE9M4Baremo()
        }
    }
}