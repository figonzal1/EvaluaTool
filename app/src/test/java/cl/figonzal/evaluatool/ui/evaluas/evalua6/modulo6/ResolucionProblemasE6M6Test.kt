/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 18:33
 */

package cl.figonzal.evaluatool.ui.evaluas.evalua6.modulo6

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua6Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable
import cl.figonzal.evaluatool.utils.EvaluaUtils.calculateDeviation
import cl.figonzal.evaluatool.utils.EvaluaUtils.calculatePercentile
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject


class ResolucionProblemasE6M6Test : KoinTest {

    private val baremoTable: BaremoTable by inject()
    private lateinit var perc: Array<Array<Double>>

    @Before
    fun setUp() {
        startKoin {

            modules(
                module {
                    single<BaremoTable> { Evalua6Baremo() }
                }
            )
        }

        perc = baremoTable.getBaremo(Evalua6Constants.RESOLUCION_PROBLEMAS_E6M6)
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
                pdTotal = it[0].toInt()
            )
            assertThat(expPercentile).isEqualTo(calcPercentile)
        }
    }

    @Test
    fun testCalculateDeviation() {

        perc.forEach {

            val expDeviation = it[2]
            val calcDeviation = calculateDeviation(
                MEAN = MEDIA,
                DEVIATION = DESVIACION,
                pdTotal = it[0].toInt()
            ).toDouble()
            assertThat(expDeviation).isEqualTo(calcDeviation)
        }
    }

    companion object {
        private const val DESVIACION = 2.79
        private const val MEDIA = 6.02
    }
}