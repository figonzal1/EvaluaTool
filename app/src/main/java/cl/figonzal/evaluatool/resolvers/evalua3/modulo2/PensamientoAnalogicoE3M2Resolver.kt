/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-07-21 15:46
 */

package cl.figonzal.evaluatool.resolvers.evalua3.modulo2

import cl.figonzal.evaluatool.baremosTables.pensamientoAnalogicoE3M2Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver
import kotlin.math.floor

class PensamientoAnalogicoE3M2Resolver : BaseResolver {

    var totalPdTarea1 = 0.0

    val perc = pensamientoAnalogicoE3M2Baremo()

    override fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor(aprobadas - reprobadas / 3.0)
        if (total < 0) total = 0.0
        return total
    }

    override fun getTotal(): Double {
        return totalPdTarea1
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
        const val DESVIACION = 5.25
        const val MEDIA = 9.32
    }
}