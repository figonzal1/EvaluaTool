/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-03-22 16:48
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo4

import cl.figonzal.evaluatool.domain.baremos.comprensionLectoraE6M4Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class ComprensionLectoraE6M4Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0
    var totalPdTask3 = 0.0

    override val perc = comprensionLectoraE6M4Baremo()


    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(
            when (nTask) {
                1 -> approved - reprobate / 2.0
                2 -> approved + reprobate.toDouble() //21+22
                3 -> approved + reprobate.toDouble() //31+32
                else -> 0.0
            }
        )
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
        const val DEVIATION = 5.21
        const val MEAN = 13.10
    }
}