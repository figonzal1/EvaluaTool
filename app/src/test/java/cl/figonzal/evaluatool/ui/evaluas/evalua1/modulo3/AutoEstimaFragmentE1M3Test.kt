/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 22:26
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua1.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua1Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class AutoEstimaFragmentE1M3Test : KoinTest {

    private val baremoTable: BaremoTable by inject()
    private lateinit var perc: Array<Array<Double>>

    @Before
    fun setUp() {
        startKoin {

            modules(
                module {
                    single<BaremoTable> { Evalua1Baremo() }
                }
            )
        }

        perc = baremoTable.getBaremo(Evalua1Constants.AUTO_ESTIMA_FRAGMENT_E1M3)
    }

    @After
    fun cleanup() {
        stopKoin()
    }


    @Test
    fun testCalculatePercentile() {

        perc.forEach {

            val expPercentile = it[1].toInt()
            val calcPercentile = EvaluaUtils.calculatePercentile(
                percentile = perc,
                pdTotal = it[0].toInt()
            )
            Truth.assertThat(expPercentile).isEqualTo(calcPercentile)
        }
    }

    @Test
    fun testCalculateDeviation() {

        perc.forEach {

            val expDeviation = it[2]
            val calcDeviation = EvaluaUtils.calculateDeviation(
                MEAN = MEDIA,
                DEVIATION = DESVIACION,
                pdTotal = it[0].toInt()
            ).toDouble()
            Truth.assertThat(expDeviation).isEqualTo(calcDeviation)
        }
    }

    companion object {
        private const val DESVIACION = 4.93
        private const val MEDIA = 21.78
    }
}