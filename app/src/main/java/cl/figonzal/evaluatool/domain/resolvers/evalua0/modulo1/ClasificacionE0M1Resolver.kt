/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 11:36
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.clasificacionE0M1Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class ClasificacionE0M1Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0

    override val percentile = clasificacionE0M1Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(
            when (nTask) {
                1 -> approved - reprobate / 4.0
                2 -> approved - reprobate / 5.0
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotalPD() = totalPdTask1 + totalPdTask2

    override fun correctPD(percentile: Array<Array<Double>>, pdCurrent: Int): Int {
        when {

            pdCurrent < 0 -> return 0
            pdCurrent > percentile.first()[0].toInt() -> return percentile.first()[0].toInt()
            pdCurrent < percentile.last()[0].toInt() -> return percentile.last()[0].toInt()
            else -> percentile.forEach { item ->
                when {
                    pdCurrent == item.first().toInt() -> return item.first().toInt()
                    pdCurrent > item.first().toInt() -> return item.first().toInt()
                }
            }
        }

        return -1
    }

    companion object {
        const val DEVIATION = 3.00
        const val MEAN = 12.93
    }
}
