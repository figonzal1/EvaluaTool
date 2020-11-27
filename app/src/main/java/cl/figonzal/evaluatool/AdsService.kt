/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2020

 Last modified 27-11-20 17:31
 */
package cl.figonzal.evaluatool

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import cl.figonzal.evaluatool.utilidades.DateHandler
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import timber.log.Timber
import java.util.*

class AdsService(activity: Activity, context: Context, sharedPreferences: SharedPreferences) {

    private lateinit var interstitialAd: InterstitialAd
    private lateinit var rewardedAd: RewardedAd
    private val context: Context
    private val activity: Activity
    private val sharedPreferences: SharedPreferences

    //INTERSITIAL
    fun loadIntersitial() {
        interstitialAd = InterstitialAd(context)
        interstitialAd.adUnitId = context.getString(R.string.ADMOB_ID_INTERSITIAL)
        interstitialAd.loadAd(AdRequest.Builder().build())
    }

    fun getIntersitial(): InterstitialAd {
        return interstitialAd
    }

    fun showIntersitial(ActivityToOpen: Class<out Activity?>?) {

        if (interstitialAd.isLoaded) {

            Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CARGADO))
            interstitialAd.adListener = object : AdListener() {

                override fun onAdClosed() {
                    super.onAdClosed()

                    Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CERRADO))
                    val intent = Intent(context, ActivityToOpen)
                    context.startActivity(intent)

                    //Cargar el siguiente
                    loadIntersitial()
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    Timber.e("%s%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_FALLADO), loadAdError.responseInfo)
                    val intent = Intent(context, ActivityToOpen)
                    context.startActivity(intent)
                }
            }

            //Lanzar intersitial
            interstitialAd.show()

        } else {
            Timber.i("%s%s", context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_NO_CARGADO))

            val intent = Intent(context, ActivityToOpen)
            context.startActivity(intent)
        }
    }

    //REWARDS VIDEO
    fun loadRewardVideo() {

        rewardedAd = RewardedAd(context, context.getString(R.string.ADMOB_ID_VIDEO))

        val adLoadCallback: RewardedAdLoadCallback = object : RewardedAdLoadCallback() {

            override fun onRewardedAdLoaded() {
                super.onRewardedAdLoaded()
                Timber.i("%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_LOADED))

                //Try to show dialog
                (activity as MainActivity).rewardDialog()
            }

            override fun onRewardedAdFailedToLoad(loadAdError: LoadAdError) {
                super.onRewardedAdFailedToLoad(loadAdError)
                Timber.e("%s%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_FAILED), loadAdError.responseInfo)
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
    }

    fun showRewardVideo() {

        val rewardedAdCallback: RewardedAdCallback = object : RewardedAdCallback() {

            override fun onUserEarnedReward(rewardItem: RewardItem) {

                val dateHandler = DateHandler()

                Timber.i("%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_REWARDED))

                val dateNow = Date()
                Timber.i("%s%s", context.getString(R.string.TAG_HORA_AHORA), dateHandler.dateToString(context, dateNow))

                //sumar 1 horas al tiempo del celular
                val dateNew = dateHandler.addHoursToJavaUtilDate(dateNow, 1)
                Timber.i("%s%s", context.getString(R.string.TAG_HORA_REWARD), dateHandler.dateToString(context, dateNew))

                //Guardar fecha de termino de reward
                val editor = sharedPreferences.edit()
                editor.putLong(context.getString(R.string.SHARED_PREF_END_REWARD_TIME), dateNew.time).apply()
            }

            override fun onRewardedAdClosed() {
                super.onRewardedAdClosed()
                Timber.i("%s%s", context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_CLOSED))
                activity.recreate()
            }
        }
        rewardedAd.show(activity, rewardedAdCallback)
    }

    init {
        MobileAds.initialize(context)
        this.context = context
        this.activity = activity
        this.sharedPreferences = sharedPreferences
    }
}