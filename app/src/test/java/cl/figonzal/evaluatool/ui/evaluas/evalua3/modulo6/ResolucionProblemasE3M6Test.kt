/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 21-06-23 21:07
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo6

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua3Baremo
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

class ResolucionProblemasE3M6Test : KoinTest {

    private val baremoTable: BaremoTable by inject()
    private lateinit var perc: Array<DoubleArray>

    @Before
    fun setUp() {
        startKoin {

            modules(
                module {
                    single<BaremoTable> { Evalua3Baremo() }
                }
            )
        }

        perc = baremoTable.getBaremo(Evalua3Constants.RESOLUCION_PROBLEMAS_E3M6)
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
                mean = MEDIA,
                deviation = DESVIACION,
                pdTotal = it[0].toInt()
            ).toDouble()
            assertThat(expDeviation).isEqualTo(calcDeviation)
        }
    }

    companion object {
        private const val DESVIACION = 7.79
        private const val MEDIA = 14.68

    }
}