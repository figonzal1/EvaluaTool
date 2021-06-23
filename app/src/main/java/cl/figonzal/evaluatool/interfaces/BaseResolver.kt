/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 22-06-21 17:33
 */

package cl.figonzal.evaluatool.interfaces

interface BaseResolver {

    fun calculateTask(
        nTarea: Int = 0,
        aprobadas: Int = 0,
        omitidas: Int = 0,
        reprobadas: Int = 0
    ): Double

    fun getTotal(): Double
    fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int
}
