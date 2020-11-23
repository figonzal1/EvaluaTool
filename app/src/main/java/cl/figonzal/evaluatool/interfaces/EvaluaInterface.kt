/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 07-11-20 16:10
 */
package cl.figonzal.evaluatool.interfaces

import android.widget.TextView

interface EvaluaInterface {
    fun calcularTarea(n_tarea: Int?, tv_sub_total: TextView, tarea: String, aprobadas: Int?, omitidas: Int?, reprobadas: Int?): Double
    fun calcularResultado()

    /**
     * Tabla percentil
     *
     * @param pd_total Puntaje directo total obtenido
     * @return Percentil del alumno
     */
    fun calcularPercentil(pd_total: Double): Int

    /**
     * Funcion encargada de corregir el pd total obtenido y dejarlo dentro de los valores de la tabla del item asociado
     *
     * @param perc      Tablas de percentiles
     * @param pd_actual Puntaje directo actual antes de correccion
     * @return Double valor PD corregido
     */
    fun corregirPD(perc: Array<Array<Int>>, pd_actual: Double): Double
}