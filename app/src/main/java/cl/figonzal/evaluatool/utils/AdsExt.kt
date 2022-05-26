/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 26-05-22 00:25
 */

package cl.figonzal.evaluatool.utils

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.widget.FrameLayout
import cl.figonzal.evaluatool.R
import com.google.android.gms.ads.*
import timber.log.Timber


/*
 * BANNER SECTION
 */
fun Activity.startAds(frameLayout: FrameLayout, idBanner: String): AdView {

    var initialLayoutComplete = false

    val adView = AdView(this)

    with(frameLayout) {
        addView(adView)
        viewTreeObserver.addOnGlobalLayoutListener {

            if (!initialLayoutComplete) {
                initialLayoutComplete = true
                adView.loadAnchored(this@startAds, idBanner)
            }
        }
    }
    return adView
}

fun AdView.loadAnchored(activity: Activity, idBanner: String) {

    //getAdSize
    adSize = anchoredAddSize(this, activity)

    adUnitId = idBanner

    adListener = object : AdListener() {

        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            Timber.w(activity.getString(R.string.ADMOB_AD_FAILED) + loadAdError)
            visibility = View.GONE
        }

        override fun onAdLoaded() {
            Timber.d(activity.getString(R.string.ADMOB_AD_LOADED))
            visibility = View.VISIBLE
        }

        override fun onAdOpened() {
            Timber.d(activity.getString(R.string.ADMOB_AD_OPEN))
        }
    }
    loadAd(AdRequest.Builder().build())
}

private fun anchoredAddSize(adView: AdView, activity: Activity): AdSize {

    @Suppress("DEPRECATION") val display = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> activity.display
        else -> activity.windowManager.defaultDisplay
    }

    val outMetrics = DisplayMetrics()
    @Suppress("DEPRECATION")
    display?.getMetrics(outMetrics)

    val density = outMetrics.density

    var adWidthPixels = adView.width.toFloat()
    if (adWidthPixels == 0f) {
        adWidthPixels = outMetrics.widthPixels.toFloat()
    }

    val adWidth = (adWidthPixels / density).toInt()
    return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth)
}

