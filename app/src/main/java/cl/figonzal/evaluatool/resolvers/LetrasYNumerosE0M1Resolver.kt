/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 18-06-21 13:03
 */

package cl.figonzal.evaluatool.resolvers

import cl.figonzal.evaluatool.baremosTables.letrasyNumerosE0M1Baremo
import kotlin.math.floor

class LetrasYNumerosE0M1Resolver {

    var totalPdTarea1 = 0.0
    var totalPdTarea2 = 0.0

    val perc = letrasyNumerosE0M1Baremo()

    fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        var total = floor(
            when (nTarea) {
                1 -> aprobadas - ((omitidas + reprobadas) / 4.0)
                2 -> aprobadas - ((omitidas + reprobadas) / 6.0)
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    fun getTotal(): Double {
        return totalPdTarea1 + totalPdTarea2
    }

    fun calculatePercentile(pdTotal: Int): Int {

        return when {
            pdTotal > perc.first()[0] as Int -> perc.first()[1] as Int
            pdTotal < perc.last()[0] as Int -> perc.last()[1] as Int
            else -> {
                var value = 0
                perc.filter { pdTotal == it.first() }.forEach { item -> value = item[1] as Int }
                value
            }
        }
    }

    fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        //Verificar si pd_actual esta en la lista
        return when {
            pdActual < 0 -> 0
            pdActual > perc.first()[0] as Int -> perc.first()[0] as Int
            pdActual < perc.last()[0] as Int -> perc.last()[0] as Int
            else -> {
                var value = 0
                perc
                    .filter { pdActual == it.first() }
                    .forEach { value = it.first() as Int }
                value
            }
        }
    }

    companion object {
        const val DESVIACION = 2.91
        const val MEDIA = 26.02
    }
}
