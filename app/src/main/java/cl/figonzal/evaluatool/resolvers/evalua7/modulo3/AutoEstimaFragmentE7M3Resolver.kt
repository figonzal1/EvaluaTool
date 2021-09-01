/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 10:17
 */

package cl.figonzal.evaluatool.resolvers.evalua7.modulo3

import cl.figonzal.evaluatool.baremosTables.autoEstimaFragmentE7M3Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver

class AutoEstimaFragmentE7M3Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val perc = autoEstimaFragmentE7M3Baremo()

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

    override fun getTotal(): Double {
        return totalPdTask1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdCurrent: Int): Int {
        when {
            pdCurrent < perc.first()[0] as Int -> return perc.first()[0] as Int
            pdCurrent > perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                when {
                    pdCurrent == item.first() -> return item.first() as Int
                    pdCurrent < item.first() as Int -> return item.first() as Int
                }
            }
        }
        return -1
    }

    companion object {
        const val DESVIACION = 4.51
        const val MEDIA = 11.45
    }
}