/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 12/17/21, 1:58 AM
 */

package cl.figonzal.evaluatool.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.SettingsActivityBinding
import cl.figonzal.evaluatool.dialogs.FirebaseDialogFragment
import cl.figonzal.evaluatool.service.FirebaseService
import cl.figonzal.evaluatool.utilities.configureActionBar
import timber.log.Timber

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }

        configureActionBar(R.string.TOOLBAR_CONFIGURACION, binding.includeToolbar.materialToolbar)
    }

    class SettingsFragment : PreferenceFragmentCompat(),
        SharedPreferences.OnSharedPreferenceChangeListener {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            //Put app version un summary preferences
            val versionPreference: Preference? = findPreference("acerca")
            versionPreference?.summary = "EvalúaTool Versión: ${BuildConfig.VERSION_NAME}"

            val firebaseCrashlytics: SwitchPreferenceCompat? =
                findPreference(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY))
            firebaseCrashlytics?.setOnPreferenceClickListener {
                FirebaseDialogFragment().show(parentFragmentManager, "Dialogo Firebase")
                true
            }
        }

        override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, p1: String?) {

            val edit = sharedPreferences?.edit()

            //Firebase Crashlytics Preference
            if (p1.equals(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY))) {

                //Get saved value
                when (sharedPreferences?.getBoolean(
                    getString(R.string.SHARED_PREF_CRASHLYTICS_KEY),
                    true
                )) {
                    true -> {
                        //Edit value
                        edit?.putBoolean(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY), true)
                        edit?.apply()

                        Toast.makeText(context, "Registro de fallos activado", Toast.LENGTH_LONG)
                            .show()

                        FirebaseService.runCrashlyticsService()
                    }
                    else -> {
                        edit?.putBoolean(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY), false)
                        edit?.apply()

                        Toast.makeText(context, "Registro de fallos desactivado", Toast.LENGTH_LONG)
                            .show()

                        FirebaseService.stopCrashlyticsService()
                    }
                }
            }


            if (p1.equals(getString(R.string.SHARED_PREF_PERFORMANCE_KEY))) {
                //Get saved value
                when (sharedPreferences?.getBoolean(
                    getString(R.string.SHARED_PREF_PERFORMANCE_KEY),
                    true
                )) {
                    true -> {
                        //Edit value
                        edit?.putBoolean(getString(R.string.SHARED_PREF_PERFORMANCE_KEY), true)
                        edit?.apply()

                        Toast.makeText(
                            context,
                            "Registro de rendimiento activado",
                            Toast.LENGTH_LONG
                        ).show()

                        FirebaseService.runPerformanceService()
                    }
                    else -> {
                        edit?.putBoolean(getString(R.string.SHARED_PREF_PERFORMANCE_KEY), false)
                        edit?.apply()

                        Toast.makeText(
                            context,
                            "Registro de rendimiento desactivado",
                            Toast.LENGTH_LONG
                        ).show()

                        FirebaseService.stopPerformanceService()
                    }
                }
            }
        }

        override fun onResume() {
            super.onResume()
            preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        }

        override fun onPause() {
            super.onPause()
            preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            Timber.d(getString(R.string.ACTIVIDAD_CERRADA))
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}