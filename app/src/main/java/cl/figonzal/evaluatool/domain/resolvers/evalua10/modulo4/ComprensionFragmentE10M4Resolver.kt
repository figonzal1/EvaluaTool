/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 11:58
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.COMPRENSION_FRAGMENT_E10M4
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class ComprensionFragmentE10M4Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    override val percentile = baremoTable.getBaremo(COMPRENSION_FRAGMENT_E10M4)

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor((approved - (omitted + reprobate)).toDouble())
        if (total < 0) total = 0.0

        return total
    }

    override fun getTotalPD() = totalPdTask1

    override fun correctPD(percentile: Array<DoubleArray>, pdCurrent: Int): Int {
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
        const val DEVIATION = 7.55
        const val MEAN = 7.53
    }
}