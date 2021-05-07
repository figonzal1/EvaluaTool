/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 07-05-21 17:29
 */
package cl.figonzal.evaluatool.interfaces

import android.widget.TextView

interface EvaluaInterface {
    /**
     * Calculate the result of every task
     *
     * @param nTarea Indicate what task is calculated (1,2,3, etc)
     * @param tvSubTotal The textView to write the results
     * @param tarea String name of task
     * @param aprobadas Correct answer score
     * @param omitidas Omitted answer score
     * @param reprobadas Incorrect answer score
     *
     * @return Double The result of calculations (It's depend of each subItem formula)
     */
    fun calculateTask(
        nTarea: Int?,
        tvSubTotal: TextView,
        tarea: String,
        aprobadas: Int?,
        omitidas: Int?,
        reprobadas: Int?
    ): Double

    /**
     *
     */
    fun calculateResult()

    /**
     * Tabla percentil
     *
     * @param pdTotal Puntaje directo total obtenido
     * @return Percentil del alumno
     */
    fun calculatePercentile(pdTotal: Int): Int

    /**
     * Funcion encargada de corregir el pd total obtenido y dejarlo dentro de los valores de la tabla del item asociado
     *
     * @param perc      Tablas de percentiles
     * @param pdActual Puntaje directo actual antes de correccion
     * @return Double valor PD corregido
     */
    fun correctPD(perc: Array<Array<Any>>, pdActual: Int): Int
}