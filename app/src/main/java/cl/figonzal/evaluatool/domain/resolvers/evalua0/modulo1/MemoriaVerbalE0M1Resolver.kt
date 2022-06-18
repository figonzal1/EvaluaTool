/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 10:23
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.memoriaVerbalE0M1Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class MemoriaVerbalE0M1Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0

    override val perc = memoriaVerbalE0M1Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {

        var total = floor(
            when (nTask) {
                1 -> 12 - reprobate.toDouble()
                2 -> 23 - reprobate.toDouble()
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun correctPD(perc: Array<Array<Any>>, pdCurrent: Int): Int {
        //Verificar si pd_actual esta en la lista
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

    override fun getTotal(): Double {
        return totalPdTask1 + totalPdTask2
    }

    companion object {
        const val DEVIATION = 6.72
        const val MEAN = 22.02
    }
}