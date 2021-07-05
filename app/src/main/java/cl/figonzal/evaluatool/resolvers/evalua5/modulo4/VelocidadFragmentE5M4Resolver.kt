/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 04-07-21 22:00
 */

package cl.figonzal.evaluatool.resolvers.evalua5.modulo4

import cl.figonzal.evaluatool.baremosTables.velocidadFragmentE5M4Baremo
import cl.figonzal.evaluatool.interfaces.BaseResolver

class VelocidadFragmentE5M4Resolver : BaseResolver {

    var totalPdTarea1 = 0.0
    val perc = velocidadFragmentE5M4Baremo()

    override fun calculateTask(
        nTarea: Int,
        aprobadas: Int,
        omitidas: Int,
        reprobadas: Int
    ): Double {
        return aprobadas.toDouble()
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
        const val DESVIACION = 28.62
        const val MEDIA = 93.61
    }
}