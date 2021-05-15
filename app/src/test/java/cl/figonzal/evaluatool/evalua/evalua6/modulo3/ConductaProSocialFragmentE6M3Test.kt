/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-05-21 22:39
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo3

import cl.figonzal.evaluatool.baremosTables.conductaProSocialFragmentE6M3Baremo
import cl.figonzal.evaluatool.evalua.evalua6.modulo3.adaptacionFragments.ConductaProSocialFragmentE6M3
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ConductaProSocialFragmentE6M3Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private var m1: ConductaProSocialFragmentE6M3? = null

    @Before
    fun setUp() {
        m1 = ConductaProSocialFragmentE6M3()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.1)
    }

    @Test
    fun testCalcularDesviacion() {
        assertEquals(
            desviacion_esperada,
            Utils.calcularDesviacion(MEDIA, DESVIACION, pd_total, true),
            0.001
        )
    }

    companion object {
        private const val DESVIACION = 2.71
        private const val MEDIA = 3.50

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return conductaProSocialFragmentE6M3Baremo()
        }
    }
}