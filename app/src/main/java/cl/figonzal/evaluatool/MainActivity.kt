/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-05-21 18:52
 */
package cl.figonzal.evaluatool

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.evalua.evalua0.Evalua0Activity
import cl.figonzal.evaluatool.evalua.evalua1.Evalua1Activity
import cl.figonzal.evaluatool.evalua.evalua10.Evalua10Activity
import cl.figonzal.evaluatool.evalua.evalua2.Evalua2Activity
import cl.figonzal.evaluatool.evalua.evalua3.Evalua3Activity
import cl.figonzal.evaluatool.evalua.evalua4.Evalua4Activity
import cl.figonzal.evaluatool.evalua.evalua5.Evalua5Activity
import cl.figonzal.evaluatool.evalua.evalua6.Evalua6Activity
import cl.figonzal.evaluatool.evalua.evalua7.Evalua7Activity
import cl.figonzal.evaluatool.evalua.evalua8.Evalua8Activity
import cl.figonzal.evaluatool.servicios.AdsService
import cl.figonzal.evaluatool.servicios.NightModeService
import cl.figonzal.evaluatool.servicios.SharedPrefService
import cl.figonzal.evaluatool.utilidades.DateHandler
import cl.figonzal.evaluatool.utilidades.disable
import cl.figonzal.evaluatool.utilidades.logInfo
import cl.figonzal.evaluatool.utilidades.toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.*

class MainActivity : AppCompatActivity() {

    val test: Boolean = false

    //ViewBinding
    private lateinit var binding: ActivityMainBinding

    //View Attributes
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var tvNombreApp: TextView
    private lateinit var tvVersion: TextView
    private var buttonList = mutableListOf<MaterialButton>()

    //Services & Handlers
    private lateinit var adsService: AdsService
    private lateinit var sharedPrefService: SharedPrefService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Checkear night mode
        sharedPrefService = SharedPrefService(this)
        NightModeService(this, this.lifecycle, sharedPrefService)

        initResources()
        loadAds()
        configAnimations()
        clickListeners()
        switchDarkModeListener()
    }

    /**
     * Function that init resources that are used in this activity
     *
     * @return Unit
     */
    private fun initResources() {

        switchDarkMode = binding.includeSwitch.switchMaterial

        tvNombreApp = binding.tvNombreApp
        tvVersion = binding.tvVersion
        tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

        configButtons()
    }

    /**
     * Binding Buttons & Disable Evalua's buttons that are not implemented yet
     *
     * @return Unit
     */
    private fun configButtons() {

        buttonList = mutableListOf(
            MaterialButton(this), //EV0
            MaterialButton(this), //EV1
            MaterialButton(this), //EV2
            MaterialButton(this), //EV3
            MaterialButton(this), //EV4
            MaterialButton(this), //EV5
            MaterialButton(this), //EV6
            MaterialButton(this), //EV7
            MaterialButton(this), //EV8
            MaterialButton(this), //EV9
            MaterialButton(this) //EV10
        )

        //binding buttons
        (0 until buttonList.size).forEach { i ->
            buttonList[i] = when (i) {
                0 -> binding.btnEvalua0
                1 -> binding.btnEvalua1
                2 -> binding.btnEvalua2
                3 -> binding.btnEvalua3
                4 -> binding.btnEvalua4
                5 -> binding.btnEvalua5
                6 -> binding.btnEvalua6
                7 -> binding.btnEvalua7
                8 -> binding.btnEvalua8
                9 -> binding.btnEvalua9
                10 -> binding.btnEvalua10
                else -> binding.btnEvalua0
            }
        }

        //Disable buttons
        buttonList.apply {
            this[9].disable() //Evalua 9
        }
    }

    /**
     * Function in charge of start Admob Service
     *
     * @return Unit
     */
    private fun loadAds() {

        if (!test) {
            adsService = AdsService(this, supportFragmentManager, sharedPrefService).apply {
                loadIntersitial()
                loadRewardVideo()
            }
        }
    }

    /**
     * Function that config animations for Main Actvity
     *
     * @return Unit
     */
    private fun configAnimations() {

        val fadeList = mutableListOf<Animation>()
        val offset = 400L
        val step = 150L

        (0..12).forEach { i ->
            fadeList.add(AnimationUtils.loadAnimation(this, R.anim.anim_fade).also {
                when (i) {
                    0 -> it.startOffset = offset
                    else -> it.startOffset = offset + (step * (i + 1))
                }
            })
        }

        //Start animations
        tvNombreApp.startAnimation(fadeList[0])
        tvVersion.startAnimation(fadeList[1])
        buttonList[0].startAnimation(fadeList[2])
        buttonList[1].startAnimation(fadeList[3])
        buttonList[2].startAnimation(fadeList[4])
        buttonList[3].startAnimation(fadeList[5])
        buttonList[4].startAnimation(fadeList[6])
        buttonList[5].startAnimation(fadeList[7])
        buttonList[6].startAnimation(fadeList[8])
        buttonList[7].startAnimation(fadeList[9])
        buttonList[8].startAnimation(fadeList[10])
        buttonList[9].startAnimation(fadeList[11])
        buttonList[10].startAnimation(fadeList[12])

    }

    /**
     * Function that handle listener for buttons in Main Activity
     *
     * @return Unit
     */
    private fun clickListeners() {

        (0 until buttonList.size).forEach { i ->

            buttonList[i].setOnClickListener {

                var activityToOpen: Class<out Activity?>? = null

                when (i) {
                    0 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_0)
                        activityToOpen = Evalua0Activity::class.java
                    }
                    1 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_1)
                        activityToOpen = Evalua1Activity::class.java
                    }
                    2 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_2)
                        activityToOpen = Evalua2Activity::class.java
                    }
                    3 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_3)
                        activityToOpen = Evalua3Activity::class.java
                    }
                    4 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_4)
                        activityToOpen = Evalua4Activity::class.java
                    }
                    5 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_5)
                        activityToOpen = Evalua5Activity::class.java
                    }
                    6 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_6)
                        activityToOpen = Evalua6Activity::class.java
                    }
                    7 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_7)
                        activityToOpen = Evalua7Activity::class.java
                    }
                    8 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_8)
                        activityToOpen = Evalua8Activity::class.java
                    }
                    10 -> {
                        logInfo(R.string.BUTTON_MAIN, R.string.BTN_EVALUA_10)
                        activityToOpen = Evalua10Activity::class.java
                    }
                }
                checkIntersitialLaunch(activityToOpen, test)

            }
        }

    }

    /**
     * Function that show the interstitial ad based on if reward date has past
     *
     * @param activityToOpen The destination activity
     * @return Unit
     */
    private fun checkIntersitialLaunch(activityToOpen: Class<out Activity?>?, test: Boolean) {

        val nowDate = Date()
        val rewardDate = Date(
            sharedPrefService.getData(
                getString(R.string.SHARED_PREF_END_REWARD_TIME),
                0L
            ) as Long
        )

        logInfo(R.string.TAG_BTN_REWARD_DATE, DateHandler.dateToString(rewardDate))

        //si las 24 horas ya pasaron, cargar los ads nuevamente
        when {
            test -> {
                val intent = Intent(this, activityToOpen)
                startActivity(intent)
            }
            nowDate.after(rewardDate) -> {

                logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.TAG_ADS_PERMITIDOS)
                adsService.showIntersitial(activityToOpen)
            }
            else -> {
                logInfo(R.string.TAG_INTERSITIAL_STATUS, R.string.TAG_ADS_NO_PERMITIDOS)

                val intent = Intent(this, activityToOpen)
                startActivity(intent)

            }
        }
    }

    /**
     * Function that handle the switchDarkMode in the main Activity
     *
     * @return Unit
     */
    private fun switchDarkModeListener() {

        val nightMode =
            sharedPrefService.getData(getString(R.string.NIGHT_MODE_KEY), false) as Boolean

        with(switchDarkMode, {
            this.isChecked = nightMode
            this.setOnCheckedChangeListener { _, isChecked ->

                when {
                    isChecked -> {
                        toast(context.getString(R.string.NIGHT_MODE_ON))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                        sharedPrefService.saveData(getString(R.string.NIGHT_MODE_KEY), true)
                    }
                    else -> {
                        toast(context.getString(R.string.NIGHT_MODE_OFF))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                        sharedPrefService.saveData(getString(R.string.NIGHT_MODE_KEY), false)
                    }
                }
            }
        })
    }
}