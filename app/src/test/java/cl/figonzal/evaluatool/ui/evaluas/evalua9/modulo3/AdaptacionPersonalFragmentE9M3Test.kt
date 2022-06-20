/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 19-06-22 23:20
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.adaptacionPersonalE9M3Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class AdaptacionPersonalFragmentE9M3Test(
    private val totalPD: Double,
    private val expPercentile: Double
) {
    private val perc = adaptacionPersonalE9M3Baremo()

    @Test
    fun testCalculatePercentile() {

        val calcPercentile =
            EvaluaUtils.calculatePercentile(perc, totalPD.toInt(), reverse = true).toDouble()

        Truth.assertThat(expPercentile).isEqualTo(calcPercentile)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = adaptacionPersonalE9M3Baremo()
    }
}