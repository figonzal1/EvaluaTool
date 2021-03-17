/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 17-03-21 19:46
 */
package cl.figonzal.evaluatool.servicios

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import cl.figonzal.evaluatool.MainActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.DateHandler
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import timber.log.Timber
import java.util.*

class AdsService(private var activity: MainActivity,
                 private var context: Context,
                 private var sharedPrefService: SharedPrefService) {

    private var interstitialAd: InterstitialAd? = null
    private lateinit var rewardedAd: RewardedAd


    fun loadIntersitial() {

        val interstitialAdLoadCallback = object : InterstitialAdLoadCallback() {

            override fun onAdLoaded(p0: InterstitialAd) {
                super.onAdLoaded(p0)
                interstitialAd = p0
                Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CARGADO))

            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Timber.e("%s%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_NO_CARGADO), p0.responseInfo)
            }

        }

        InterstitialAd.load(
                context,
                context.getString(R.string.ADMOB_ID_INTERSITIAL),
                AdRequest.Builder().build(),
                interstitialAdLoadCallback
        )
    }

    fun getIntersitial(): InterstitialAd? {
        return interstitialAd
    }

    fun showIntersitial(ActivityToOpen: Class<out Activity?>?) {

        interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {

            override fun onAdFailedToShowFullScreenContent(p0: AdError?) {
                super.onAdFailedToShowFullScreenContent(p0)
                interstitialAd = null

                Timber.e("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_NO_MOSTRADO))

                val intent = Intent(activity, ActivityToOpen)
                activity.startActivity(intent)
            }

            override fun onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent()
                Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_MOSTRADO))
            }

            override fun onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent()
                loadIntersitial()

                Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CERRADO))

                val intent = Intent(activity, ActivityToOpen)
                activity.startActivity(intent)
            }
        }

        interstitialAd?.show(activity)
    }


    /**
     * Funcion encargada de cargar el video publicitario
     */
    fun loadRewardVideo() {

        val adLoadCallback: RewardedAdLoadCallback = object : RewardedAdLoadCallback() {

            override fun onAdLoaded(p0: RewardedAd) {
                rewardedAd = p0
                Timber.i("%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_LOADED))

                //Try to show dialog
                activity.rewardDialog()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Timber.e("%s%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_FAILED), p0.responseInfo)
            }
        }

        //LOAD VIDEO REWARD
        RewardedAd.load(
                context,
                context.getString(R.string.ADMOB_ID_VIDEO),
                AdRequest.Builder().build(),
                adLoadCallback
        )
    }

    /**
     * Funcion encargada de mostrar en pantalla el video rewarded
     */
    fun showRewardVideo() {

        val userEarnedRewardListener = OnUserEarnedRewardListener {
            val dateHandler = DateHandler()

            Timber.i("%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_REWARDED))

            val dateNow = Date()
            Timber.i("%s%s", context.getString(R.string.TAG_HORA_AHORA), dateHandler.dateToString(context, dateNow))

            //sumar 1 horas al tiempo del celular
            val dateNew = dateHandler.addHoursToJavaUtilDate(dateNow, 1)
            Timber.i("%s%s", context.getString(R.string.TAG_HORA_REWARD), dateHandler.dateToString(context, dateNew))

            //Guardar fecha de termino de reward
            sharedPrefService.saveData(context.getString(R.string.SHARED_PREF_END_REWARD_TIME), dateNew.time)

            Toast.makeText(context, "¡Dia libre de publicidad!", Toast.LENGTH_LONG).show()
        }

        rewardedAd.show(activity, userEarnedRewardListener)
    }

    init {
        MobileAds.initialize(context)
    }
}