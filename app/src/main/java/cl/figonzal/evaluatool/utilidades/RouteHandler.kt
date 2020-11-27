/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 26-11-20 23:57
 */

package cl.figonzal.evaluatool.utilidades

import android.app.Activity
import android.content.Intent
import cl.figonzal.evaluatool.R
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import timber.log.Timber

class RouteHandler {

    /**
     * Funcion encargada de manejar las actividades del listado de subItems de cada Evalua
     *
     * @param routeMapEvalua               Route map con la configuracion
     * @param sectionTitle                 Titulo seccion
     * @param sectionedRecyclerViewAdapter RecyclerView seccionado
     * @param itemAdapterPosition          PosisionAdapter
     * @param currentActivity              Actividad que llama
     */
    fun handleRoutes(routeMapEvalua: Map<String, List<Array<Any>>>, sectionTitle: String, sectionedRecyclerViewAdapter: SectionedRecyclerViewAdapter, itemAdapterPosition: Int, currentActivity: Activity) {

        for ((moduleName, subItems) in routeMapEvalua) {

            if (moduleName == sectionTitle) {

                for (i in subItems.indices) {

                    if (i == sectionedRecyclerViewAdapter.getPositionInSection(itemAdapterPosition)) {

                        val activity = subItems[i][1] as Class<*>
                        val responseLog = subItems[i][2] as String
                        val titleLog = currentActivity.getString(R.string.SUB_ITEM_CLICK)

                        abrirActividad(currentActivity, activity, titleLog, responseLog)
                    }
                }
                break
            }
        }
    }

    /**
     * Funcion encargada de abrir las actividades
     *
     * @param activity       Actividad Padre
     * @param calledActivity Actividad hijo
     * @param log_title      Titulo del log
     * @param log_reponse    Respuesta del log
     */
    private fun abrirActividad(activity: Activity, calledActivity: Class<*>, log_title: String, log_reponse: String) {
        Timber.i("%s%s", log_title, log_reponse)
        val intent = Intent(activity, calledActivity)
        activity.startActivity(intent)
    }
}