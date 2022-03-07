/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-03-22 16:51
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo4

import cl.figonzal.evaluatool.domain.baremos.comprensionLectoraE9M4Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ComprensionLectoraE9M4Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private val perc = comprensionLectoraE9M4Baremo()

    @Test
    fun testCalcularPercentil() {
        Assert.assertEquals(
            percentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total).toDouble(),
            0.1
        )
    }

    @Test
    fun testCalcularDesviacion() {
        Assert.assertEquals(
            desviacion_esperada,
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, pd_total).toDouble(),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 7.38
        private const val MEDIA = 13.17

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return comprensionLectoraE9M4Baremo()
        }
    }
}