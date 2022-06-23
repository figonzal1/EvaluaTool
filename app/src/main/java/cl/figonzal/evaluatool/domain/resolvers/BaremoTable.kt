/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 23-06-22 00:33
 */

package cl.figonzal.evaluatool.domain.resolvers

import cl.figonzal.evaluatool.domain.baremo_tables.constants.EvaluaConstants

interface BaremoTable {
    fun getBaremo(baremo: String): Array<Array<Double>>

    fun getBaremo(baremo: EvaluaConstants): Array<Array<Double>>
}