/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 23:23
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.autoEstimaFragmentE6M3Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AutoEstimaFragmentE6M3Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {
    private val perc = autoEstimaFragmentE6M3Baremo()

    @Test
    fun testCalculatePercentile() {

        val calcPercentile =
            EvaluaUtils.calculatePercentile(perc, totalPD.toInt(), reverse = true).toDouble()

        assertThat(expPercentile).isEqualTo(calcPercentile)
    }

    @Test
    fun testCalculateDeviation() {

        val calcDeviation = EvaluaUtils.calculateDeviation(
            MEDIA,
            DESVIACION,
            totalPD.toInt(), reverse = true
        ).toDouble()

        assertThat(expDeviation).isEqualTo(calcDeviation)
    }

    companion object {
        private const val DESVIACION = 3.01
        private const val MEDIA = 5.54

        @JvmStatic
        @Parameterized.Parameters
        fun data() = autoEstimaFragmentE6M3Baremo()
    }
}