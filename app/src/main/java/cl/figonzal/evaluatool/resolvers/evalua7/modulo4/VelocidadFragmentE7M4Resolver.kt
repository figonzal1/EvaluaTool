/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 27-07-21 10:17
 */

package cl.figonzal.evaluatool.resolvers.evalua7.modulo4

import cl.figonzal.evaluatool.baremosTables.velocidadFragmentE7M4Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver

class VelocidadFragmentE7M4Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val perc = velocidadFragmentE7M4Baremo()

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
        const val DESVIACION = 68.21
        const val MEDIA = 257.12
    }
}