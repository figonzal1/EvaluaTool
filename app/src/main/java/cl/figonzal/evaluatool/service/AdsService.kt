/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 13-08-21 18:44
 */
package cl.figonzal.evaluatool.service

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.activities.MainActivity
import cl.figonzal.evaluatool.utilities.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import timber.log.Timber
import java.util.*

/**
 * Class that provide AdMob service
 *
 * @param activity Activity that need ads
 * @param supportFragmentManager Fragment manager for dialogFragment
 * @param sharedPrefService SharedPref to save data
 *
 * @version 12-06-2021
 */
class AdsService(
    private val activity: MainActivity,
    private val supportFragmentManager: FragmentManager,
    private val sharedPrefService: SharedPrefService,
) {

    private var interstitialAd: InterstitialAd? = null

    /**
     * Function that configure callbacks for intersitial ad
     *
     * @return Unit
     */
    fun loadIntersitial() {

        InterstitialAd.load(
            activity.applicationContext,
            EvaluaUtils.get(R.string.ADMOB_ID_INTERSITIAL),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    interstitialAd = p0
                    Timber.d(activity.getString(R.string.INTERSITIAL_CARGADO))

                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Timber.d(activity.getString(R.string.INTERSITIAL_NO_CARGADO))
                }
            }
        )
    }

    fun getIntersitial(): InterstitialAd? {
        return interstitialAd
    }

    /**
     * Function that show intersitial in screen
     *
     * @param destActivity Destination activity
     */
    private fun showIntersitial(destActivity: Class<out Activity?>?) {

        with(activity) {
            interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                    interstitialAd = null

                    Timber.d(getString(R.string.INTERSITIAL_NO_MOSTRADO))
                    startActivity(Intent(this@with, destActivity))
                }


                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                    Timber.d(getString(R.string.INTERSITIAL_MOSTRADO))
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    loadIntersitial()

                    Timber.d(getString(R.string.INTERSITIAL_CERRADO))
                    startActivity(Intent(this@with, destActivity))
                }
            }

            interstitialAd?.show(this)
        }
    }

    /**
     * Function that show the interstitial ad based on if reward date has past
     *
     * @param activityToOpen The destination activity
     * @return Unit
     */
    fun checkIntersitialOnStart(
        activityToOpen: Class<out Activity?>?,
        test: Boolean
    ) {
        //si las 24 horas ya pasaron, cargar los ads nuevamente
        with(activity, {
            when {
                !test && isAdsAllowed(sharedPrefService) -> {
                    Timber.d(getString(R.string.ADS_PERMITIDOS))
                    showIntersitial(activityToOpen)
                }
                else -> {
                    Timber.d(getString(R.string.ADS_NO_PERMITIDOS))
                    startActivity(Intent(this, activityToOpen))
                }
            }
        })
    }

    init {
        MobileAds.initialize(activity.applicationContext) {
            Timber.d(activity.getString(R.string.MOBILE_ADS_COMPLETE))
        }
    }
}