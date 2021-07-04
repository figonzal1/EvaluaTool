/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 01-07-21 21:40
 */

package cl.figonzal.evaluatool.resolvers.evalua3.modulo3

import cl.figonzal.evaluatool.baremosTables.autoControlFragmentE3M3Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class AutoControlFragmentE3M3Resolver : BaseResolver {

    var totalPdTarea1 = 0.0

    val perc = autoControlFragmentE3M3Baremo()

    override fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor(aprobadas.toDouble())
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotal(): Double {
        return totalPdTarea1
    }

    override fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        when {
            pdActual < perc.first()[0] as Int -> return perc.first()[0] as Int
            pdActual > perc.last()[0] as Int -> return perc.last()[0] as Int
            else -> perc.forEach { item ->
                when {
                    pdActual == item.first() -> return item.first() as Int
                    pdActual < item.first() as Int -> return item.first() as Int
                }
            }
        }
        return -1
    }

    companion object {
        const val DESVIACION = 3.49
        const val MEDIA = 4.02
    }
}