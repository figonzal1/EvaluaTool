/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26/2/22 23:19
 */

package cl.figonzal.evaluatool.utils

import android.app.Activity
import android.content.Intent
import cl.figonzal.evaluatool.R
import timber.log.Timber

object RouteHandler {

    /**
     * Function in charge to handle the routes way in ConfigRoutes
     *
     * @param routeMapEvalua HashMap with all config routes
     * @param sectionTitle Header tittle
     * @param adapterPosition SubItem position in adapter
     * @param currentActivity The Caller Activity
     */
    fun handleRoutes(
        routeMapEvalua: HashMap<String, List<Any>>,
        sectionTitle: String,
        adapterPosition: Int,
        currentActivity: Activity,
    ) {

        routeMapEvalua.forEach { item ->

            //Item name
            if (item.key == sectionTitle) {

                (0..item.value.size)
                    .asSequence()
                    .filter {
                        it == adapterPosition
                    }
                    .map { item.value[it] as List<*> }
                    .forEach {
                        with(it) {
                            val destinationActivity = this[1]
                            val responseLog = this[2]
                            val titleLog = EvaluaUtils.get(R.string.SUB_ITEM_CLICK)

                            openActivity(
                                currentActivity,
                                destinationActivity as Class<*>,
                                titleLog,
                                responseLog as String
                            )
                        }
                    }
            }
        }
    }

    /**
     * Function that open the activities
     *
     * @param activity Parent Activity
     * @param destActivity ChildActivity (Destination activity)
     * @param TAG tag for logs
     * @param msg  Msg for logs
     *
     * @return Unit
     */
    private fun openActivity(
        activity: Activity,
        destActivity: Class<*>?,
        TAG: String,
        msg: String
    ) {
        Timber.i("%s%s", TAG, msg)
        activity.startActivity(Intent(activity, destActivity))
    }
}