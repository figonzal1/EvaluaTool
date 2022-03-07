/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-03-22 16:49
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua8.modulo4

import cl.figonzal.evaluatool.domain.baremos.velocidadFragmentE8M4Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver

class VelocidadFragmentE8M4Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val perc = velocidadFragmentE8M4Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        return approved.toDouble()
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
        const val DEVIATION = 73.19
        const val MEAN = 177.26
    }
}