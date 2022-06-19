/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 22:52
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua5.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.conductaProsocialFragmentE5M3Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver

class ConductaProSocialFragmentE5M3Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val percentile = conductaProsocialFragmentE5M3Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = approved.toDouble()
        if (total < 0) total = 0.0

        return total
    }

    override fun getTotalPD() = totalPdTask1

    override fun correctPD(percentile: Array<Array<Double>>, pdCurrent: Int): Int {
        when {
            pdCurrent < percentile.first()[0].toInt() -> return percentile.first()[0].toInt()
            pdCurrent > percentile.last()[0].toInt() -> return percentile.last()[0].toInt()
            else -> percentile.forEach { item ->
                when {
                    pdCurrent == item.first().toInt() -> return item.first().toInt()
                    pdCurrent < item.first().toInt() -> return item.first().toInt()
                }
            }
        }
        return -1
    }

    companion object {
        const val DEVIATION = 2.86
        const val MEAN = 3.57
    }
}