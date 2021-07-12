/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 11-07-21 18:34
 */

package cl.figonzal.evaluatool.evalua.evalua8.modulo3

import cl.figonzal.evaluatool.baremosTables.habilidadesSocialesFragmentE8M3Baremo
import cl.figonzal.evaluatool.utilidades.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class HabilidadesSocialesFragmentE8M3Test(
    private val pd_total: Int, private val percentil_esperado: Double
) {
    private val perc = habilidadesSocialesFragmentE8M3Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            Utils.calculatePercentile(perc, pd_total, reverse = true).toDouble(),
            0.1
        )
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> {
            return habilidadesSocialesFragmentE8M3Baremo()
        }
    }
}
