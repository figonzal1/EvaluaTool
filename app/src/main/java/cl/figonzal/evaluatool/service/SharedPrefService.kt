/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 21-07-21 22:49
 */

package cl.figonzal.evaluatool.service

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import cl.figonzal.evaluatool.R

/**
 * Clase in charge of handling the sharedPref data service more easily
 *
 * @param context Context that is used in Strings Resources
 */
class SharedPrefService(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.MAIN_SHARED_PREF),
        Context.MODE_PRIVATE
    )

    /**
     * Function date save data in shared preferences
     *
     * @param key Key that store the data in shared preferences
     * @param value The value which will be store in shared preferences
     */
    fun saveData(key: String, value: Any) {

        sharedPreferences.edit(true) {
            when (value) {
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> putString(key, value as String)
            }
        }
    }

    /**
     * Function that retrieve data from shared preferences
     *
     * @param key Key that store the data in shared preferences
     * @param defaultvalue If the store value is inaccessible
     * @return Any
     */
    fun getData(key: String, defaultvalue: Any): Any {
        val result: Any

        with(sharedPreferences, {
            result = when (defaultvalue) {
                is Int -> getInt(key, defaultvalue)
                is Boolean -> getBoolean(key, defaultvalue)
                is Float -> getFloat(key, defaultvalue)
                is Long -> getLong(key, defaultvalue)
                else -> getString(key, defaultvalue as String)!!

            }
            return result
        })
    }
}