/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 00:23
 */

package cl.figonzal.evaluatool.resolvers.evalua7.modulo2

import cl.figonzal.evaluatool.baremosTables.razonamientoDeductivoE7M2Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class RazonamientoDeductivoE7M2Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val perc = razonamientoDeductivoE7M2Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = floor(approved - reprobate / 2.0)
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
        const val DESVIACION = 6.05
        const val MEDIA = 12.51
    }
}