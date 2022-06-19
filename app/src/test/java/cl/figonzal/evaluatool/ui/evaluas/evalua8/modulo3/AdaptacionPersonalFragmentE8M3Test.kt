/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 22:32
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua8.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.adaptacionPersonalE8M3Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AdaptacionPersonalFragmentE8M3Test(
    private val pd_total: Int, private val percentil_esperado: Double
) {
    private val perc = adaptacionPersonalE8M3Baremo()

    @Test
    fun testCalcularPercentil() {
        assertEquals(
            percentil_esperado,
            EvaluaUtils.calculatePercentile(perc, pd_total, reverse = true).toDouble(),
            0.1
        )
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Double>> {
            return adaptacionPersonalE8M3Baremo()
        }
    }
}