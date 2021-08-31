/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-07-21 22:43
 */

package cl.figonzal.evaluatool.interfaces

interface BaseResolver {

    val perc: Array<Array<Any>>

    fun calculateTask(
        nTask: Int = 0,
        approved: Int = 0,
        omitted: Int = 0,
        reprobate: Int = 0
    ): Double

    fun getTotal(): Double
    fun correctPD(perc: Array<Array<Any>>, pdCurrent: Int): Int
}
