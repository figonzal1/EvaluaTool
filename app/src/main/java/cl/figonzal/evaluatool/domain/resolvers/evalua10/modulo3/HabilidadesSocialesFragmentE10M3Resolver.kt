/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 18-06-23 11:58
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua10.modulo3

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua10Constants.HABILIDADES_SOCIALES_E10M3
import cl.figonzal.evaluatool.domain.baremo_tables.tables.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver

class HabilidadesSocialesFragmentE10M3Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    override val percentile = baremoTable.getBaremo(HABILIDADES_SOCIALES_E10M3)

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {
        var total = approved.toDouble()
        if (total < 0) total = 0.0
        return total
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
        const val MEAN = 24.38
        const val DEVIATION = 9.21
    }
}