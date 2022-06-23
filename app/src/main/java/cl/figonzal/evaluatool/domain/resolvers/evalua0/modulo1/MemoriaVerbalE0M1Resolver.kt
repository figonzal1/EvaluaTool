/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:37
 */

package cl.figonzal.evaluatool.domain.resolvers.evalua0.modulo1

import cl.figonzal.evaluatool.domain.baremo_tables.constants.Evalua0Constants.MEMORIA_VERBAL_E0M1
import cl.figonzal.evaluatool.domain.resolvers.BaremoTable
import cl.figonzal.evaluatool.domain.resolvers.BaseResolver
import kotlin.math.floor

class MemoriaVerbalE0M1Resolver(
    baremoTable: BaremoTable
) : BaseResolver {

    var totalPdTask1 = 0.0
    var totalPdTask2 = 0.0

    override val percentile = baremoTable.getBaremo(MEMORIA_VERBAL_E0M1)

    override fun calculateTask(
        nTask: Int,
        approved: Int,
        omitted: Int,
        reprobate: Int
    ): Double {

        var total = floor(
            when (nTask) {
                1 -> 12 - reprobate.toDouble()
                2 -> 23 - reprobate.toDouble()
                else -> 0.0
            }
        )
        if (total < 0) total = 0.0
        return total
    }

    override fun correctPD(percentile: Array<Array<Double>>, pdCurrent: Int): Int {
        //Verificar si pd_actual esta en la lista
        when {
            pdCurrent < 0 -> return 0
            pdCurrent > percentile.first()[0].toInt() -> return percentile.first()[0].toInt()
            pdCurrent < percentile.last()[0].toInt() -> return percentile.last()[0].toInt()
            else -> percentile.forEach { item ->
                when {
                    pdCurrent == item.first().toInt() -> return item.first().toInt()
                    pdCurrent > item.first().toInt() -> return item.first().toInt()
                }
            }
        }

        return -1
    }

    override fun getTotalPD() = totalPdTask1 + totalPdTask2

    companion object {
        const val DEVIATION = 6.72
        const val MEAN = 22.02
    }
}