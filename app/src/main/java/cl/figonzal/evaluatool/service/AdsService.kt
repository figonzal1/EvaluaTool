/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26-05-22 16:40
 */

package cl.figonzal.evaluatool.service

import android.app.Activity
import cl.figonzal.evaluatool.R
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import timber.log.Timber


class InterstitialAdManager(
    private val activity: Activity,
    var interstitial: InterstitialAd?,
    var adIsLoading: Boolean
) {

    fun loadInterstitial() {

        val callback = object : InterstitialAdLoadCallback() {

            override fun onAdFailedToLoad(p0: LoadAdError) {

                interstitial = null
                adIsLoading = false

                Timber.e(activity.getString(R.string.ADMOB_INTERSTITIAL_FAILED) + p0)
            }

            override fun onAdLoaded(p0: InterstitialAd) {

                interstitial = p0
                adIsLoading = false

                Timber.d(activity.getString(R.string.ADMOB_INTERSTITIAL_LOADED))
            }
        }

        InterstitialAd.load(
            activity, activity.getString(R.string.ADMOB_ID_INTERSTITIAL),
            AdRequest.Builder().build(), callback
        )
    }


    fun showInterstitial(
        navigateListener: () -> Unit
    ) {

        when {
            interstitial != null -> {

                interstitial?.fullScreenContentCallback = object : FullScreenContentCallback() {

                    override fun onAdDismissedFullScreenContent() {

                        Timber.d(activity.getString(R.string.fullscreen_interstitial_dismiss))
                        interstitial = null

                        //Load ad again
                        loadInterstitial()

                        navigateListener()
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {

                        Timber.e(activity.getString(R.string.fullscreen_interstitial_failed_load) + p0)
                        interstitial = null
                    }

                    override fun onAdShowedFullScreenContent() {
                        Timber.d(activity.getString(R.string.fullscreen_interstitial_showed))
                    }

                }
                interstitial?.show(activity)

            }
            else -> {
                Timber.e(activity.getString(R.string.interstitial_null))

                navigateListener()
            }
        }
    }
}