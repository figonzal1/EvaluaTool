/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 21:07
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua10.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua10Baremo
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

class AtencionConcentracionE10M1Test : KoinTest {

    private val baremoTable: BaremoTable by inject()
    private lateinit var perc: Array<DoubleArray>

    @Before
    fun setUp() {
        startKoin {

            modules(
                module {
                    single<BaremoTable> { Evalua10Baremo() }
                }
            )
        }

        perc = baremoTable.getBaremo(Evalua10Constants.ATENCION_CONCENTRACION_E10M1)
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
                mean = MEDIA,
                deviation = DESVIACION,
                pdTotal = it[0].toInt()
            ).toDouble()
            Truth.assertThat(expDeviation).isEqualTo(calcDeviation)
        }
    }

    companion object {
        private const val DESVIACION = 24.28
        private const val MEDIA = 135.67
    }
}
