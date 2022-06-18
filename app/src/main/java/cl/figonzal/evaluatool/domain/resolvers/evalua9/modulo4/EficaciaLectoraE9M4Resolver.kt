/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 10:23
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.eficaciaLectoraE9M4Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class EficaciaLectoraE9M4Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val perc = eficaciaLectoraE9M4Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        //FORMULA PARA RAZONAMIENTO DEDUCTIVO
        var total = floor(approved.toDouble())
        if (total < 0) total = 0.0

        return total
    }

    override fun getTotal(): Double {
        return totalPdTask1
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
        const val DEVIATION = 3.99
        const val MEAN = 5.73
    }
}