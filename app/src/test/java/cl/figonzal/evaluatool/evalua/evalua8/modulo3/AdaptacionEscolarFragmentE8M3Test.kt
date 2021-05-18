/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-05-21 11:10
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo3

import cl.figonzal.evaluatool.baremosTables.adaptacionEscolarE8M3Baremo
import cl.figonzal.evaluatool.evalua.evalua8.modulo3.adaptacionFragments.AdaptacionEscolarFragmentE8M3
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AdaptacionEscolarFragmentE8M3Test(
    private val pd_total: Int, private val percentil_esperado: Double
) {
    private var m1: AdaptacionEscolarFragmentE8M3? = null

    @Before
    fun setUp() {
        m1 = AdaptacionEscolarFragmentE8M3()
    }

    @Test
    fun testCalcularPercentil() {
        assertEquals(percentil_esperado, m1!!.calculatePercentile(pd_total).toDouble(), 0.1)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return adaptacionEscolarE8M3Baremo()
        }
    }
}