/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 11:58
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua9.modulo4

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua9Constants.VELOCIDAD_FRAGMENT_E9M4
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver

class VelocidadFragmentE9M4Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    override val percentile = baremoTable.getBaremo(VELOCIDAD_FRAGMENT_E9M4)

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        return approved.toDouble()
    }

    override fun getTotalPD() = totalPdTask1

    override fun correctPD(percentile: Array<DoubleArray>, pdCurrent: Int): Int {
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
        const val DEVIATION = 74.13
        const val MEAN = 203.58
    }
}