/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 18:48
 */
package cl.figonzal.evaluatool.ui.evaluas.evalua3.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua3Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.baremo_tables.tables.Evalua3Baremo
import cl.figonzal.evaluatool.utils.EvaluaUtils.calculateDeviation
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

class MemoriaAtencionE3M1Test : KoinTest {

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

        perc = baremoTable.getBaremo(Evalua3Constants.MEMORIA_ATENCION_E3M1)
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
            Truth.assertThat(expPercentile).isEqualTo(calcPercentile)
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
            Truth.assertThat(expDeviation).isEqualTo(calcDeviation)
        }
    }

    companion object {
        private const val DESVIACION = 18.78
        private const val MEDIA = 84.36
    }
}