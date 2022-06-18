/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 12:19
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.organizacionPerceptivaE0M1Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class OrganizacionPerceptivaE0M1Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0
    var totalPdTask3 = 0.0
    var totalPdTask4 = 0.0

    override val percentile = organizacionPerceptivaE0M1Baremo()


    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(
            when (nTask) {
                1 -> 3 - reprobate.toDouble()
                2 -> 5 - reprobate * 1.5
                3 -> 6 - (reprobate * 2).toDouble()
                4 -> 8 - (reprobate * 2).toDouble()
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotalPD() = totalPdTask1 + totalPdTask2 + totalPdTask3 + totalPdTask4

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
        const val DEVIATION = 3.98
        const val MEAN = 19.39
    }
}