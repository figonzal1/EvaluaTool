/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 21:15
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua1.modulo5

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua1Constants
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class OrtografiaFoneticaE1M5Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0
    var totalPdTask3 = 0.0

    override val percentile = baremoTable.getBaremo(Evalua1Constants.ORTOGRAFIA_FONETICA_E1M5)

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

    override fun getTotalPD() = totalPdTask1 + totalPdTask2 + totalPdTask3

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
        const val DEVIATION = 17.35
        const val MEAN = 54.30
    }
}