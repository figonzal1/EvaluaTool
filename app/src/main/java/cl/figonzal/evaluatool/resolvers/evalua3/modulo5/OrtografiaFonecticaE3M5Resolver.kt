/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 00:19
 */

package cl.figonzal.evaluatool.resolvers.evalua3.modulo5

import cl.figonzal.evaluatool.baremosTables.ortografiaFoneticaE3M5Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class OrtografiaFonecticaE3M5Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0
    var totalPdTask3 = 0.0

    override val perc = ortografiaFoneticaE3M5Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(approved.toDouble())
        if (total < 0) total = 0.0
        return total

    }

    override fun getTotal(): Double {
        return totalPdTask1 + totalPdTask2 + totalPdTask3
    }

    override fun correctPD(perc: Array<Array<Any>>, pdCurrent: Int): Int {
        when {

            pdCurrent < 0 -> return 0
            pdCurrent > perc.first()[0] as Int -> return perc.first()[0] as Int
            pdCurrent < perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                when {
                    pdCurrent == item.first() -> return item.first() as Int
                    pdCurrent > item.first() as Int -> return item.first() as Int
                }
            }
        }

        return -1
    }

    companion object {
        const val DESVIACION = 6.84
        const val MEDIA = 67.51
    }
}