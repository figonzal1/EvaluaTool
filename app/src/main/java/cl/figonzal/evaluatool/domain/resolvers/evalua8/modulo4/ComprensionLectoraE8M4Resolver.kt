/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 23:08
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua8Constants.COMPRENSION_LECTORA_E8M4
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class ComprensionLectoraE8M4Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0
    var totalPdTask3 = 0.0
    var totalPdTask4 = 0.0
    var totalPdTask5 = 0.0

    override val percentile = baremoTable.getBaremo(COMPRENSION_LECTORA_E8M4)


    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(
            when (nTask) {
                1, 2 -> approved - reprobate / 2.0
                3, 4 -> approved - reprobate / 4.0
                5 -> approved - reprobate / 3.0
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotalPD() =
        totalPdTask1 + totalPdTask2 + totalPdTask3 + totalPdTask4 + totalPdTask5

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
        const val DEVIATION = 7.13
        const val MEAN = 15.83
    }
}