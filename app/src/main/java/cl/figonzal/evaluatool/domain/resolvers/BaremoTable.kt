/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 20-06-22 19:08
 */

package cl.figonzal.evaluatool.domain.resolvers

interface BaremoTable {
    fun getBaremo(baremo: String): Array<Array<Double>>
}