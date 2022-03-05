/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 05-03-22 12:02
 */
package cl.figonzal.evaluatool.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.service.ChangeLogService
import cl.figonzal.evaluatool.service.GooglePlayService
import cl.figonzal.evaluatool.service.NightModeService
import cl.figonzal.evaluatool.service.UpdaterService
import cl.figonzal.evaluatool.utils.*
import com.google.android.gms.ads.AdView
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var adView: AdView

    private lateinit var sharedPrefUtil: SharedPrefUtil

    private lateinit var binding: ActivityMainBinding
    private val updateCode: Int = 350

    //View Attributes
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var tvAppName: TextView
    private lateinit var tvVersion: TextView
    private var buttonList = mutableListOf<MaterialButton>()

    private lateinit var updateService: UpdaterService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefUtil = SharedPrefUtil(this)

        //Night mode
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.Q -> {
                Timber.d("ANDROID_VERSION < Q: ${Build.VERSION.SDK_INT}")
                //NightMode service for old versions
                lifecycle.addObserver(NightModeService(this, sharedPrefUtil))

                setUpSwitchDarkMode(binding)
            }
            else -> {
                Timber.d("ANDROID_VERSION > Q: ${Build.VERSION.SDK_INT}")
                binding.hideSwitchNightMode()
            }
        }

        //GP services
        lifecycle.addObserver(GooglePlayService(this))

        //Change Log Service
        lifecycle.addObserver(ChangeLogService(this, SharedPrefUtil(this)))


        //UPDATEr
        /*
        with(SharedPrefUtil(this)) {
            updateService = UpdaterService(
                this@MainActivity, AppUpdateManagerFactory.create(this@MainActivity), updateCode
            )
        }*/

        bindingResources()
    }

    /**
     * Function that init resources that are used in this activity
     *
     * @return Unit
     */
    private fun bindingResources() {

        with(binding) {

            tvAppName = tvNombreApp
            this@MainActivity.tvVersion = tvVersion
            tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

            (0 until 11).forEach {
                buttonList.add(
                    when (it) {
                        0 -> btnEvalua0
                        1 -> btnEvalua1
                        2 -> btnEvalua2
                        3 -> btnEvalua3
                        4 -> btnEvalua4
                        5 -> btnEvalua5
                        6 -> btnEvalua6
                        7 -> btnEvalua7
                        8 -> btnEvalua8
                        9 -> btnEvalua9
                        10 -> btnEvalua10
                        else -> btnEvalua0
                    }
                )
            }

            //Set up buttons for view
            setUpMainButtons(buttonList, this)

            //Set up card view custom corners
            mainCardView.setUpCardViewCustomCorners()

            //Setup Settings button
            ivSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }

            handlePrivacyPolicy(sharedPrefUtil)

            configureFABWsp(fabWsp)

            adView = startAds(binding.adViewContainer)
        }
    }

    /**
     * Function that handle the switchDarkMode in the main Activity
     *
     * @return Unit
     */
    private fun setUpSwitchDarkMode(binding: ActivityMainBinding) {

        switchDarkMode = binding.includeSwitch.switchMaterial

        val nightMode =
            sharedPrefUtil.getData(getString(R.string.NIGHT_MODE_KEY), false) as Boolean

        with(switchDarkMode) {

            isChecked = nightMode
            setOnCheckedChangeListener { _, isChecked ->

                when {
                    isChecked -> {
                        toast(context.getString(R.string.NIGHT_MODE_ON))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                        sharedPrefUtil.saveData(getString(R.string.NIGHT_MODE_KEY), true)
                    }
                    else -> {
                        toast(context.getString(R.string.NIGHT_MODE_OFF))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                        sharedPrefUtil.saveData(getString(R.string.NIGHT_MODE_KEY), false)
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == updateCode) {
            if (resultCode != RESULT_OK) {
                Timber.e(getString(R.string.UPDATE_FAIL))
            }
        }
    }

    override fun onResume() {
        super.onResume()

        //updateService.resumeUpdater()
    }
}