/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 18-06-22 23:16
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua7.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.velocidadFragmentE7M4Baremo
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver

class VelocidadFragmentE7M4Resolver : BaseResolver {

    var totalPdTask1 = 0.0
    override val percentile = velocidadFragmentE7M4Baremo()

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        return approved.toDouble()
    }

    override fun getTotalPD() = totalPdTask1

    override fun correctPD(percentile: Array<Array<Double>>, pdCurrent: Int): Int {
        when {
            pdCurrent < percentile.first()[0].toInt() -> return percentile.first()[0].toInt()
            pdCurrent > percentile.last()[0].toInt() -> return percentile.last()[0].toInt()
            else -> percentile.forEach { item ->
                when {
                    pdCurrent == item.first().toInt() -> return item.first().toInt()
                    pdCurrent < item.first().toInt() -> return item.first().toInt()
                }
            }
        }
        return -1
    }

    companion object {
        const val DEVIATION = 68.21
        const val MEAN = 257.12
    }
}