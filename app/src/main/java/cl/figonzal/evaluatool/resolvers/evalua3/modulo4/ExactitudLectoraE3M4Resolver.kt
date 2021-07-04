/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-07-21 21:04
 */

package cl.figonzal.evaluatool.resolvers.evalua3.modulo4

import cl.figonzal.evaluatool.baremosTables.exactitudLectoraE3M4Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class ExactitudLectoraE3M4Resolver : BaseResolver {

    var totalPdTarea1 = 0.0
    var totalPdTarea2 = 0.0

    val perc = exactitudLectoraE3M4Baremo()


    override fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor(
            when (nTarea) {
                1 -> aprobadas - (reprobadas + omitidas) / 2.0
                2 -> aprobadas.toDouble()
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotal(): Double {
        return totalPdTarea1 + totalPdTarea2
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        when {

            pdActual < 0 -> return 0
            pdActual > perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual < perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                when {
                    pdActual == item.first() -> return item.first() as Int
                    pdActual > item.first() as Int -> return item.first() as Int
                }
            }
        }

        return -1
    }

    companion object {
        const val DESVIACION = 5.54
        const val MEDIA = 33.66
    }
}