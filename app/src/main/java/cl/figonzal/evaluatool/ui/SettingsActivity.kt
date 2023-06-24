/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2023

 Last modified 23-06-23 23:36
 */

package cl.figonzal.evaluatool.ui

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.SettingsActivityBinding
import cl.figonzal.evaluatool.service.FirebaseService
import cl.figonzal.evaluatool.utils.configureActionBar
import cl.figonzal.evaluatool.utils.toast
import timber.log.Timber


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
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
            findPreference<Preference>(resources.getString(R.string.SHARED_PREF_VERSION))?.apply {
                summary = BuildConfig.VERSION_NAME
            }

            findPreference<Preference>(getString(R.string.SHARED_PREF_PRIVACY_POLICY))?.setOnPreferenceClickListener {

                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(getString(R.string.PRIVACY_POLICY_URL))
                    startActivity(this)
                }
                true
            }

            findPreference<Preference>(getString(R.string.contact_key))?.setOnPreferenceClickListener {

                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse(
                        "mailto:${getString(R.string.mail_to_felipe)}" +
                                "?subject=${getString(R.string.email_subject)}"
                    )
                ).apply {
                    putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                    requireActivity().startActivity(
                        Intent.createChooser(this, getString(R.string.email_chooser_title))
                    )
                }
                true
            }
        }

        override fun onSharedPreferenceChanged(preferences: SharedPreferences?, key: String?) {


            //Firebase Crashlytics Preference
            if (key.equals(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY))) {

                //Get saved value
                val result = when (preferences?.getBoolean(
                    getString(R.string.SHARED_PREF_CRASHLYTICS_KEY),
                    true
                )) {
                    true -> {
                        requireActivity().toast(getString(R.string.firebase_crashlytics_on))
                        FirebaseService.runCrashlyticsService()
                        true
                    }

                    else -> {
                        requireActivity().toast(getString(R.string.firebase_crashlytics_off))
                        FirebaseService.stopCrashlyticsService()
                        false
                    }
                }
                preferences?.edit {
                    putBoolean(getString(R.string.SHARED_PREF_CRASHLYTICS_KEY), result)
                }
            }


            if (key.equals(getString(R.string.SHARED_PREF_PERFORMANCE_KEY))) {

                val result = when (preferences?.getBoolean(
                    getString(R.string.SHARED_PREF_PERFORMANCE_KEY),
                    true
                )) {
                    true -> {
                        requireActivity().toast(getString(R.string.firebase_performance_on))
                        FirebaseService.runPerformanceService()
                        true
                    }

                    else -> {
                        requireActivity().toast(getString(R.string.firebase_performance_off))
                        FirebaseService.stopPerformanceService()
                        false
                    }
                }

                preferences?.edit {
                    putBoolean(getString(R.string.SHARED_PREF_PERFORMANCE_KEY), result)
                }
            }
        }

        override fun onResume() {
            super.onResume()
            preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
        }

        override fun onPause() {
            super.onPause()
            preferenceManager.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
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