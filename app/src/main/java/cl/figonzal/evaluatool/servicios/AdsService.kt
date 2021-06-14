/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 13-06-21 20:16
 */
package cl.figonzal.evaluatool.servicios

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentManager
import cl.figonzal.evaluatool.MainActivity
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.utilidades.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
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
    private lateinit var rewardedAd: RewardedAd

    /**
     * Function that configure callbacks for intersitial ad
     *
     * @return Unit
     */
    fun loadIntersitial() {

        InterstitialAd.load(
            activity.applicationContext,
            Utils.get(R.string.ADMOB_ID_INTERSITIAL),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    interstitialAd = p0
                    activity.logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.INTERSITIAL_CARGADO)

                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    activity.logInfo(
                        R.string.TAG_INTERSITIAL_STATUS,
                        R.string.INTERSITIAL_NO_CARGADO
                    )
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

        interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                super.onAdFailedToShowFullScreenContent(p0)
                interstitialAd = null

                with(activity, {
                    logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.INTERSITIAL_NO_MOSTRADO)
                    startActivity(Intent(this, destActivity))
                })
            }

            override fun onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent()
                activity.logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.INTERSITIAL_MOSTRADO)
            }

            override fun onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent()
                loadIntersitial()

                with(activity, {
                    logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.INTERSITIAL_CERRADO)
                    startActivity(Intent(this, destActivity))
                })
            }
        }
        interstitialAd?.show(activity)
    }

    /**
     * Function that configure callbacks for rewardView
     *
     * @return Unit
     */
    fun loadRewardVideo() {

        //LOAD VIDEO REWARD
        RewardedAd.load(
            activity.applicationContext,
            Utils.get(R.string.ADMOB_ID_VIDEO),
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {

                override fun onAdLoaded(p0: RewardedAd) {
                    rewardedAd = p0
                    activity.logInfo(
                        R.string.TAG_VIDEO_REWARD_STATUS,
                        R.string.TAG_VIDEO_REWARD_STATUS_LOADED
                    )

                    //Try to show dialog
                    try {
                        rewardDialog()
                    } catch (e: IllegalStateException) {
                        Timber.e(e, "Error al llamar dialog")
                    }
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    activity.logInfo(
                        R.string.TAG_VIDEO_REWARD_STATUS,
                        R.string.TAG_VIDEO_REWARD_STATUS_FAILED
                    )
                }
            }
        )
    }

    /**
     * Function that show reward video in screen
     *
     * @return Unit
     */
    fun showRewardVideo() {

        with(activity, {

            rewardedAd.show(this) {

                logInfo(R.string.TAG_VIDEO_REWARD_STATUS, R.string.TAG_VIDEO_REWARD_STATUS_REWARDED)

                val dateNow = Date()
                logInfo(R.string.TAG_HORA_AHORA, DateHandler.dateToString(dateNow))

                //sumar 24 horas al tiempo del celular
                val dateNew = DateHandler.addHoursToDate(dateNow, 24)
                logInfo(R.string.TAG_HORA_REWARD, DateHandler.dateToString(dateNew))

                //Guardar fecha de termino de reward
                sharedPrefService.saveData(
                    Utils.get(R.string.SHARED_PREF_END_REWARD_TIME),
                    dateNew.time
                )

                toast(getString(R.string.DIA_LIBRE))
            }
        })

    }

    /**
     * Function that configure the reward dialog
     *
     * @return Unit
     */
    fun rewardDialog() {

        val rewardDate = Date(
            sharedPrefService.getData(
                Utils.get(R.string.SHARED_PREF_END_REWARD_TIME),
                0L
            ) as Long
        )
        val nowDate = Date()

        //Si la hora del celular es posterior a reward date
        when {
            nowDate.after(rewardDate) -> {
                activity.logInfo(R.string.TAG_REWARD_STATUS, R.string.TAG_REWARD_STATUS_EN_PERIODO)
                //Generar % de aparicion de dialogo
                when {
                    Utils.generateRandomNumber() -> {
                        //Mostrar dialog
                        activity.confirmationDialogReward(this)
                        activity.logInfo(
                            R.string.TAG_RANDOM_SHOW_REWARD_DIALOG,
                            R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_ON
                        )
                    }
                    else -> {
                        activity.logInfo(
                            R.string.TAG_RANDOM_SHOW_REWARD_DIALOG,
                            R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_OFF
                        )
                    }
                }
            }
            nowDate.before(rewardDate) -> {
                activity.logInfo(
                    R.string.TAG_REWARD_STATUS,
                    R.string.TAG_REWARD_STATUS_PERIODO_INACTIVO
                )
            }
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
                    logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.TAG_ADS_PERMITIDOS)
                    showIntersitial(activityToOpen)
                }
                else -> {
                    logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.TAG_ADS_NO_PERMITIDOS)
                    startActivity(Intent(this, activityToOpen))
                }
            }
        })
    }

    init {
        MobileAds.initialize(activity.applicationContext)
    }
}