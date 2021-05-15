/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 14-05-21 21:36
 */

package cl.figonzal.evaluatool.evalua.evalua6.modulo4

import cl.figonzal.evaluatool.baremosTables.velocidadFragmentE6M4Baremo
import cl.figonzal.evaluatool.evalua.evalua6.modulo4.velocidadFragment.VelocidadFragmentE6M4
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class VelocidadFragmentE6M4Test(
    private val pd_total: Int, private val percentil_esperado: Double,
    private val desviacion_esperada: Double
) {
    private var m1: VelocidadFragmentE6M4? = null

    @Before
    fun setUp() {
        m1 = VelocidadFragmentE6M4()
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
        private const val DESVIACION = 46.59
        private const val MEDIA = 157.82

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return velocidadFragmentE6M4Baremo()
        }
    }
}
