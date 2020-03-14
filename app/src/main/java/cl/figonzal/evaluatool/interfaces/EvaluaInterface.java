/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 17:21                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.interfaces;

import android.widget.TextView;

@SuppressWarnings("unused")
public interface EvaluaInterface {

    double calcularTarea(Integer n_tarea, TextView tv_sub_total, String tarea, Integer aprobadas, Integer omitidas, Integer reprobadas);

    void calcularResultado();

    /**
     * Tabla percentil
     *
     * @param pd_total Puntaje directo total obtenido
     * @return Percentil del alumno
     */
    int calcularPercentil(double pd_total);

    /**
     * Funcion encargada de corregir el pd total obtenido y dejarlo dentro de los valores de la tabla del item asociado
     *
     * @param perc      Tablas de percentiles
     * @param pd_actual Puntaje directo actual antes de correccion
     * @return Double valor PD corregido
     */
    double corregirPD(Integer[][] perc, double pd_actual);
}
