/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 07-03-22 11:59
 */
package cl.figonzal.evaluatool.ui

import android.app.Activity
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
import cl.figonzal.evaluatool.utils.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    //ADS
    private var adView: AdView? = null
    private var interstitial: InterstitialAd? = null
    private var adIsLoading: Boolean = false

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

        //RequestConfiguration.Builder()
        //    .setTestDeviceIds(Arrays.asList(""))

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

        //Ads InterstitialAd
        if (!adIsLoading && interstitial == null) {
            adIsLoading = true
            loadAd()
        }

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

            //Banner
            adView = startAds(binding.adViewContainer, getString(R.string.ADMOB_ID_BANNER_MAIN))

            //Set up buttons for view & interstitial
            onButtonClickListeners()
            buttonList.setUpAnimations(binding, this@MainActivity)

            //Set up card view custom corners
            mainCardView.setUpCardViewCustomCorners()

            //Setup Settings button
            ivSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }

            handlePrivacyPolicy(sharedPrefUtil)

            configureFABWsp(fabWsp)
        }
    }

    /**
     * Function that load night mode in devices < Q from SharedPreferences
     *
     * @param binding Main Activity Binding
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

    //INTERSTITIAL
    private fun loadAd() {

        val callback = object : InterstitialAdLoadCallback() {

            override fun onAdFailedToLoad(p0: LoadAdError) {

                interstitial = null
                adIsLoading = false

                Timber.w(getString(R.string.ADMOB_INTERSTITIAL_FAILED) + p0)
            }

            override fun onAdLoaded(p0: InterstitialAd) {

                interstitial = p0
                adIsLoading = false

                Timber.d(getString(R.string.interstitial_loaded))
            }
        }

        InterstitialAd.load(
            this@MainActivity, getString(R.string.ADMOB_ID_INTERSTITIAL),
            AdRequest.Builder().build(), callback
        )
    }

    fun ActivityMainBinding.onButtonClickListeners() {

        btnEvalua0.setOnClickListener {
            showInterstitial<Evalua0Activity>()
        }

        btnEvalua1.setOnClickListener {
            showInterstitial<Evalua1Activity>()
        }

        btnEvalua2.setOnClickListener {
            showInterstitial<Evalua2Activity>()
        }

        btnEvalua3.setOnClickListener {
            showInterstitial<Evalua3Activity>()
        }

        btnEvalua4.setOnClickListener {
            showInterstitial<Evalua4Activity>()
        }

        btnEvalua5.setOnClickListener {
            showInterstitial<Evalua5Activity>()
        }

        btnEvalua6.setOnClickListener {
            showInterstitial<Evalua6Activity>()
        }

        btnEvalua7.setOnClickListener {
            showInterstitial<Evalua7Activity>()
        }

        btnEvalua8.setOnClickListener {
            showInterstitial<Evalua8Activity>()
        }

        btnEvalua9.setOnClickListener {
            showInterstitial<Evalua9Activity>()
        }

        btnEvalua10.setOnClickListener {
            showInterstitial<Evalua10Activity>()
        }
    }

    private inline fun <reified T : Activity> showInterstitial() {

        val intent = Intent(this@MainActivity, T::class.java)

        if (interstitial != null) {

            interstitial?.fullScreenContentCallback = object : FullScreenContentCallback() {

                override fun onAdDismissedFullScreenContent() {

                    Timber.d(getString(R.string.fullscreen_interstitial_dismiss))
                    interstitial = null

                    //Load ad again
                    loadAd()

                    startActivity(intent)
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {

                    Timber.w(getString(R.string.fullscreen_interstitial_failed_load) + p0)
                    interstitial = null
                }

                override fun onAdShowedFullScreenContent() {
                    Timber.d(getString(R.string.fullscreen_interstitial_showed))
                }

            }
            interstitial?.show(this)

        } else {
            Timber.w(getString(R.string.interstitial_null))

            //Open activity without ads
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adView?.destroy()
    }
}