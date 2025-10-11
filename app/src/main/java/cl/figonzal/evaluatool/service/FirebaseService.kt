/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2025

 Last modified 10-10-25, 23:22
 */

package cl.figonzal.evaluatool.service

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.ktx.performance

/**
 * Function that handle firebase service collection
 */
class FirebaseService {

    companion object {
        fun runCrashlyticsService() {
            Firebase.crashlytics.isCrashlyticsCollectionEnabled = true
        }

        fun stopCrashlyticsService() {
            Firebase.crashlytics.isCrashlyticsCollectionEnabled = false
        }

        fun runPerformanceService() {
            Firebase.performance.isPerformanceCollectionEnabled = true
        }

        fun stopPerformanceService() {
            Firebase.performance.isPerformanceCollectionEnabled = false
        }
    }
}