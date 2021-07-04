/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 03-07-21 17:44
 */
package cl.figonzal.evaluatool.evalua.evalua4.modulo2

import cl.figonzal.evaluatool.baremosTables.organizacionPerceptivaE4M2Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import cl.figonzal.evaluatool.utilidades.Utils.calcularDesviacion2
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class OrganizacionPerceptivaE4M2Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {

    private val perc = organizacionPerceptivaE4M2Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            Utils.calculatePercentile(perc, pd_total).toDouble(),
            0.1
        )
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
        private const val DESVIACION = 3.21
        private const val MEDIA = 13.18

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return organizacionPerceptivaE4M2Baremo()
        }
    }
}