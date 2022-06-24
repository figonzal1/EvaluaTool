/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 22:26
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua9.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua9Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils.calculatePercentile
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class AdaptacionEscolarFragmentE9M3Test : KoinTest {

    private val baremoTable: BaremoTable by inject()
    private lateinit var perc: Array<Array<Double>>

    @Before
    fun setUp() {
        startKoin {

            modules(
                module {
                    single<BaremoTable> { Evalua9Baremo() }
                }
            )
        }

        perc = baremoTable.getBaremo(Evalua9Constants.ADAPTACION_ESCOLAR_E9M3)
    }

    @After
    fun cleanup() {
        stopKoin()
    }


    @Test
    fun testCalculatePercentile() {

        perc.forEach {

            val expPercentile = it[1].toInt()
            val calcPercentile = calculatePercentile(
                percentile = perc,
                pdTotal = it[0].toInt(),
                reverse = true
            )
            Truth.assertThat(expPercentile).isEqualTo(calcPercentile)
        }
    }

}