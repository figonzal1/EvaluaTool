/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 09:56
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua6.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua6Constants
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class OrganizacionPerceptivaE6M1Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0

    override val percentile = baremoTable.getBaremo(Evalua6Constants.ORGANIZACION_PERCEPTIVA_E6M1)

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(
            when (nTask) {
                1, 2 -> approved - reprobate / 3.0
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
        const val DEVIATION = 3.84
        const val MEAN = 10.77
    }
}