/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 11:58
 */

package cl.figonzal.evaluatool.domain.resolvers

interface BaseResolver {

    //Change name to baremo
    val percentile: Array<Array<Double>>

    fun calculateTask(
        nTask: Int = 0,
        approved: Int = 0,
        omitted: Int = 0,
        reprobate: Int = 0
    ): Double

    fun getTotalPD(): Double

    fun correctPD(percentile: Array<DoubleArray>, pdCurrent: Int): Int
}
