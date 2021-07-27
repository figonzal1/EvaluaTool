/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 26-07-21 15:44
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
     * Function that configure callbacks for rewardView
     *
     * @return Unit
     */
    fun loadRewardVideo() {

        //LOAD VIDEO REWARD
        RewardedAd.load(
            activity.applicationContext,
            EvaluaUtils.get(R.string.ADMOB_ID_VIDEO),
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {

                override fun onAdLoaded(p0: RewardedAd) {
                    rewardedAd = p0
                    Timber.d(activity.getString(R.string.VIDEO_REWARD_STATUS_LOADED))

                    //Try to show dialog
                    try {
                        rewardDialog()
                    } catch (e: IllegalStateException) {
                        Timber.e(e, "Error al llamar dialog")
                    }
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Timber.w(activity.getString(R.string.VIDEO_REWARD_STATUS_FAILED))
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

                Timber.d(getString(R.string.VIDEO_REWARD_STATUS_REWARDED))

                val dateNow = Date()
                Timber.d(
                    String.format(
                        "%s%s",
                        getString(R.string.HORA_AHORA),
                        DateHandler.dateToString(dateNow)
                    )
                )

                //sumar 24 horas al tiempo del celular
                val dateNew = DateHandler.addHoursToDate(dateNow, 24)
                Timber.d(
                    String.format(
                        "%s%s",
                        getString(R.string.HORA_REWARD),
                        DateHandler.dateToString(dateNew)
                    )
                )

                //Guardar fecha de termino de reward
                sharedPrefService.saveData(
                    EvaluaUtils.get(R.string.SHARED_PREF_END_REWARD_TIME),
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
                EvaluaUtils.get(R.string.SHARED_PREF_END_REWARD_TIME),
                0L
            ) as Long
        )
        val nowDate = Date()

        with(activity) {
            //Si la hora del celular es posterior a reward date
            when {
                nowDate.after(rewardDate) -> {
                    Timber.d(getString(R.string.REWARD_STATUS_EN_PERIODO))
                    //Generar % de aparicion de dialogo
                    when {
                        EvaluaUtils.generateRandomNumber() -> {
                            //Mostrar dialog
                            confirmationDialogReward(this@AdsService)
                            Timber.d(getString(R.string.RANDOM_SHOW_REWARD_DIALOG_ON))
                        }
                        else -> {
                            Timber.d(getString(R.string.RANDOM_SHOW_REWARD_DIALOG_OFF))
                        }
                    }
                }
                nowDate.before(rewardDate) -> {
                    Timber.d(getString(R.string.REWARD_STATUS_PERIODO_INACTIVO))
                }
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