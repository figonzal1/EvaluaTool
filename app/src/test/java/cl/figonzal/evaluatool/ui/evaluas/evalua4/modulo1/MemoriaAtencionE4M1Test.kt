/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 23:23
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua4.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.memoriaAtencionE4M1Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MemoriaAtencionE4M1Test(
    private val totalPD: Double,
    private val expPercentile: Double,
    private val expDeviation: Double
) {
    private val perc = memoriaAtencionE4M1Baremo()

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
        private const val DESVIACION = 17.11
        private const val MEDIA = 62.66

        @JvmStatic
        @Parameterized.Parameters
        fun data() = memoriaAtencionE4M1Baremo()
    }
}