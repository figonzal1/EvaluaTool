/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 23:23
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.comprensionLectoraE7M4Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ComprensionLectoraE7M4Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {

    private val perc = comprensionLectoraE7M4Baremo()

    @Test
    fun testCalculatePercentile() {

        val calcPercentile = EvaluaUtils.calculatePercentile(perc, totalPD.toInt()).toDouble()

        assertThat(expPercentile).isEqualTo(calcPercentile)
    }

    @Test
    fun testCalculateDeviation() {

        val calcDeviation =
            EvaluaUtils.calculateDeviation(MEDIA, DESVIACION, totalPD.toInt()).toDouble()

        assertThat(expDeviation).isEqualTo(calcDeviation)
    }

    companion object {
        private const val DESVIACION = 6.71
        private const val MEDIA = 14.52

        @JvmStatic
        @Parameterized.Parameters
        fun data() = comprensionLectoraE7M4Baremo()
    }
}