/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 22-06-21 13:03
 */

package cl.figonzal.evaluatool.resolvers

import cl.figonzal.evaluatool.baremosTables.memoriaVerbalE0M1Baremo
import kotlin.math.floor

class MemoriaVerbalE0M1Resolver {

    var totalPdTarea1 = 0.0
    var totalPdTarea2 = 0.0

    val perc = memoriaVerbalE0M1Baremo()

    fun calculateTask(
        nTarea: Int,
        aprobadas: Int = 0,
        omitidas: Int = 0,
        reprobadas: Int = 0
    ): Double {

        var total = floor(
            when (nTarea) {
                1 -> 12 - reprobadas.toDouble()
                2 -> 23 - reprobadas.toDouble()
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    fun calculatePercentile(pdTotal: Int): Int {

        //Limite superior
        return when {
            pdTotal > perc.first()[0] as Int -> perc.first()[1] as Int
            pdTotal < perc.last()[0] as Int -> perc.last()[1] as Int
            else -> {
                var value = 0
                perc
                    .filter { pdTotal == it.first() }
                    .forEach { item -> value = item[1] as Int }
                value
            }
        }
    }

    fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int {
        //Verificar si pd_actual esta en la lista
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

    fun getTotal(): Double {
        return totalPdTarea1 + totalPdTarea2
    }

    companion object {
        const val DESVIACION = 6.72
        const val MEDIA = 22.02
    }

    private fun findItem(items: Array<Any>, pdActual: Int): Int {

        var result = -1
        for (i in 1..items.size) {
            if (pdActual - i == items.first()) {
                println("entre AQUI")
                result = items.first() as Int
            }
        }
        return result
    }
}