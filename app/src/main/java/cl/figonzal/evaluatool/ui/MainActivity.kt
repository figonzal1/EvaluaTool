/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2024

 Last modified 09-11-24, 22:36
 */
package cl.figonzal.evaluatool.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.service.ChangeLogService
import cl.figonzal.evaluatool.service.GooglePlayService
import cl.figonzal.evaluatool.service.UpdaterService
import cl.figonzal.evaluatool.ui.evaluas.evalua0.Evalua0Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua1.Evalua1Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua10.Evalua10Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua2.Evalua2Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua3.Evalua3Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua4.Evalua4Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua5.Evalua5Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua6.Evalua6Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua7.Evalua7Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua8.Evalua8Activity
import cl.figonzal.evaluatool.ui.evaluas.evalua9.Evalua9Activity
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import cl.figonzal.evaluatool.utils.handleNightMode
import cl.figonzal.evaluatool.utils.mainActivityTo
import cl.figonzal.evaluatool.utils.setUpAnimations
import cl.figonzal.evaluatool.utils.setUpCardViewCustomCorners
import com.google.android.material.button.MaterialButton
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPrefUtil: SharedPrefUtil

    private lateinit var binding: ActivityMainBinding

    private var updaterService: UpdaterService? = null

    private var buttonList = mutableListOf<MaterialButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefUtil = SharedPrefUtil(this)

        //Night mode
        handleNightMode(binding, sharedPrefUtil)

        //GP services
        lifecycle.addObserver(GooglePlayService(this))

        //Change Log Service
        lifecycle.addObserver(ChangeLogService(this, sharedPrefUtil))

        //UPDATER
        updaterService = UpdaterService(this, activityResultLauncher)
        updaterService!!.checkAvailability()

        bindingResources()
    }

    /**
     * Function that init resources that are used in this activity
     *
     * @return Unit
     */
    private fun bindingResources() {

        with(binding) {

            tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

            //Set up buttons for view & interstitial
            onButtonClickListeners()
            buttonList.setUpAnimations(binding, this@MainActivity)

            //Set up card view custom corners
            mainCardView.setUpCardViewCustomCorners()

            //Setup Settings button
            ivSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }

            //handlePrivacyPolicy(sharedPrefUtil)
        }
    }

    @Deprecated("Deprecated in Java")
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == UpdaterService.UPDATE_CODE) {
            when (resultCode) {
                RESULT_OK -> Timber.d(getString(R.string.UPDATE_OK))
                else -> Timber.e(getString(R.string.UPDATE_FAILED), resultCode)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        updaterService?.resumeUpdater()
    }

    fun ActivityMainBinding.onButtonClickListeners() {

        btnEvalua0.setOnClickListener {
            mainActivityTo(Evalua0Activity())
        }

        btnEvalua1.setOnClickListener {
            mainActivityTo(Evalua1Activity())
        }

        btnEvalua2.setOnClickListener {
            mainActivityTo(Evalua2Activity())
        }

        btnEvalua3.setOnClickListener {
            mainActivityTo(Evalua3Activity())
        }

        btnEvalua4.setOnClickListener {
            mainActivityTo(Evalua4Activity())
        }

        btnEvalua5.setOnClickListener {
            mainActivityTo(Evalua5Activity())
        }

        btnEvalua6.setOnClickListener {
            mainActivityTo(Evalua6Activity())
        }

        btnEvalua7.setOnClickListener {
            mainActivityTo(Evalua7Activity())
        }

        btnEvalua8.setOnClickListener {
            mainActivityTo(Evalua8Activity())
        }

        btnEvalua9.setOnClickListener {
            mainActivityTo(Evalua9Activity())
        }

        btnEvalua10.setOnClickListener {
            mainActivityTo(Evalua10Activity())
        }

    }

    private val activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            when (val resultCode = result.resultCode) {
                Activity.RESULT_OK -> Timber.d("Lqch-apk updated successfully")
                Activity.RESULT_CANCELED -> Timber.d("User cancelled Update flow!")
                else -> Timber.e("Lqch-apk update flow failed! Result code: %s", resultCode)
            }
        }
}