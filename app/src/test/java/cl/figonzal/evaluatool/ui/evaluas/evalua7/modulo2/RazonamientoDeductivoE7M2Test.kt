/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 23:23
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua7.modulo2

import cl.figonzal.evaluatool.domain.baremo_tables.razonamientoDeductivoE7M2Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RazonamientoDeductivoE7M2Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {
    private val perc = razonamientoDeductivoE7M2Baremo()

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
        private const val DESVIACION = 6.05
        private const val MEDIA = 12.51

        @JvmStatic
        @Parameterized.Parameters
        fun data() = razonamientoDeductivoE7M2Baremo()
    }
}