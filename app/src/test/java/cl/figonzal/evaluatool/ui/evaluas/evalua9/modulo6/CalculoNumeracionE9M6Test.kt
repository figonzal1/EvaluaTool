/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 11:26
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo6

import cl.figonzal.evaluatool.domain.baremo_tables.tables.calculoNumeracionE9M6Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CalculoNumeracionE9M6Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {

    private val perc = calculoNumeracionE9M6Baremo()

    @Test
    fun testCalculatePercentile() {

        val calcPercentile = EvaluaUtils.calculatePercentile(perc, totalPD.toInt()).toDouble()

        Truth.assertThat(expPercentile).isEqualTo(calcPercentile)
    }

    @Test
    fun testCalculateDeviation() {

        val calcDeviation = EvaluaUtils.calculateDeviation(
            MEDIA,
            DESVIACION,
            totalPD.toInt()
        ).toDouble()

        Truth.assertThat(expDeviation).isEqualTo(calcDeviation)
    }

    companion object {
        private const val DESVIACION = 6.36
        private const val MEDIA = 13.84

        @JvmStatic
        @Parameterized.Parameters
        fun data() = calculoNumeracionE9M6Baremo()
    }
}