/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 12:05
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua0.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.recepcionAuditivaE0M3Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RecepcionAuditivaArticulacionE0M3Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {

    private val perc = recepcionAuditivaE0M3Baremo()

    @Test
    fun testCalculatePercentile() {

        val calcPercentile = EvaluaUtils.calculatePercentile(perc, totalPD.toInt()).toDouble()

        assertThat(expPercentile).isEqualTo(calcPercentile)
    }

    @Test
    fun testCalculateDeviation() {

        val calcDeviation =
            EvaluaUtils.calcularDesviacion2(MEDIA, DESVIACION, totalPD.toInt()).toDouble()

        assertThat(expDeviation).isEqualTo(calcDeviation)
    }

    companion object {
        private const val DESVIACION = 9.01
        private const val MEDIA = 84.81

        @JvmStatic
        @Parameterized.Parameters
        fun data() = recepcionAuditivaE0M3Baremo()
    }
}