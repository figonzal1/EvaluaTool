/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 04-02-21 0:33
 */

package cl.figonzal.evaluatool.servicios

import android.content.Context
import android.content.SharedPreferences
import cl.figonzal.evaluatool.R

class SharedPrefService(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.MAIN_SHARED_PREF), Context.MODE_PRIVATE)

    fun saveData(key: String, value: Any) {

        with(sharedPreferences.edit()) {
            when (value) {
                is Int -> {
                    putInt(key, value)
                }
                is Boolean -> {
                    putBoolean(key, value)
                }
                is Long -> {
                    putLong(key, value)
                }
                is Float -> {
                    putFloat(key, value)
                }
                else -> putString(key, value as String)
            }

            apply()
        }
    }

    fun getData(key: String, defaultvalue: Any): Any {
        val result: Any

        when (defaultvalue) {
            is Int -> {
                result = sharedPreferences.getInt(key, defaultvalue)
            }
            is Boolean -> {
                result = sharedPreferences.getBoolean(key, defaultvalue)
            }
            is Float -> {
                result = sharedPreferences.getFloat(key, defaultvalue)
            }
            is Long -> {
                result = sharedPreferences.getLong(key, defaultvalue)
            }
            else -> result = sharedPreferences.getString(key, defaultvalue as String)!!

        }
        return result
    }
}