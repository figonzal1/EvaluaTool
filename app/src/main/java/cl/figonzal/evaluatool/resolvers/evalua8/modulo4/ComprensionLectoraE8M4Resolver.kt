/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-07-21 15:36
 */

package cl.figonzal.evaluatool.resolvers.evalua8.modulo4

import cl.figonzal.evaluatool.baremosTables.comprensionLectoraE8M4Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class ComprensionLectoraE8M4Resolver : BaseResolver {

    var totalPdTarea1 = 0.0
    var totalPdTarea2 = 0.0
    var totalPdTarea3 = 0.0
    var totalPdTarea4 = 0.0
    var totalPdTarea5 = 0.0

    val perc = comprensionLectoraE8M4Baremo()


    override fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor(
            when (nTarea) {
                1, 2 -> aprobadas - reprobadas / 2.0
                3, 4 -> aprobadas - reprobadas / 4.0
                5 -> aprobadas - reprobadas / 3.0
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotal(): Double {
        return totalPdTarea1 + totalPdTarea2 + totalPdTarea3 + totalPdTarea4 + totalPdTarea5
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
        const val DESVIACION = 7.13
        const val MEDIA = 15.83
    }
}