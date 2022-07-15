/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 15-07-22 16:53
 */
package cl.figonzal.evaluatool.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.service.ChangeLogService
import cl.figonzal.evaluatool.service.GooglePlayService
import cl.figonzal.evaluatool.service.InterstitialAdManager
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
import com.google.android.gms.ads.AdView
import com.google.android.material.button.MaterialButton
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPrefUtil: SharedPrefUtil

    //ADS
    private var adView: AdView? = null
    private lateinit var interstitialAdManager: InterstitialAdManager

    private lateinit var binding: ActivityMainBinding
    private val updateCode: Int = 350

    private var buttonList = mutableListOf<MaterialButton>()

    private lateinit var updateService: UpdaterService

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

        //Ads InterstitialAd
        interstitialAdManager = handleAdManager()

        //UPDATER
        updateService = UpdaterService(
            this, AppUpdateManagerFactory.create(this), updateCode
        )

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

    @Deprecated("Deprecated in Java")
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

        updateService.resumeUpdater()
    }

    fun ActivityMainBinding.onButtonClickListeners() {

        with(interstitialAdManager) {

            btnEvalua0.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua0Activity())
                }
            }

            btnEvalua1.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua1Activity())
                }
            }

            btnEvalua2.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua2Activity())
                }
            }

            btnEvalua3.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua3Activity())
                }
            }

            btnEvalua4.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua4Activity())
                }
            }

            btnEvalua5.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua5Activity())
                }
            }

            btnEvalua6.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua6Activity())
                }
            }

            btnEvalua7.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua7Activity())
                }
            }

            btnEvalua8.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua8Activity())
                }
            }

            btnEvalua9.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua9Activity())
                }
            }

            btnEvalua10.setOnClickListener {
                showInterstitial {
                    mainActivityTo(Evalua10Activity())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adView?.destroy()
    }
}