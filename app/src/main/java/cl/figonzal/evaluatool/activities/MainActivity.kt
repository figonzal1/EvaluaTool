/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 23-07-21 14:35
 */
package cl.figonzal.evaluatool.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
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
import cl.figonzal.evaluatool.evalua.evalua9.Evalua9Activity
import cl.figonzal.evaluatool.service.*
import cl.figonzal.evaluatool.utilities.isAdsAllowed
import cl.figonzal.evaluatool.utilities.logInfo
import cl.figonzal.evaluatool.utilities.toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.play.core.appupdate.AppUpdateManagerFactory


class MainActivity : AppCompatActivity() {

    private val updateCode: Int = 350
    val test: Boolean = false

    //View Attributes
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var tvNombreApp: TextView
    private lateinit var tvVersion: TextView
    private var buttonList = mutableListOf<MaterialButton>()

    private lateinit var updateService: UpdaterService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Checkear night mode
        with(SharedPrefService(this), {

            NightModeService(this@MainActivity, this@MainActivity.lifecycle, this)

            ChangeLogService(this@MainActivity, this@MainActivity, this).checkChangeLogVersion()

            updateService = UpdaterService(
                this@MainActivity, AppUpdateManagerFactory.create(this@MainActivity), updateCode
            )

            //Init resources for Main Activity
            initResources(binding, this)
        })
    }

    /**
     * Function that init resources that are used in this activity
     *
     * @return Unit
     */
    private fun initResources(binding: ActivityMainBinding, sharedPrefService: SharedPrefService) {

        with(binding, {
            switchDarkMode = includeSwitch.switchMaterial

            this@MainActivity.tvNombreApp = tvNombreApp
            this@MainActivity.tvVersion = tvVersion
            tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

            buttonList = mutableListOf(
                MaterialButton(this@MainActivity), //EV0
                MaterialButton(this@MainActivity), //EV1
                MaterialButton(this@MainActivity), //EV2
                MaterialButton(this@MainActivity), //EV3
                MaterialButton(this@MainActivity), //EV4
                MaterialButton(this@MainActivity), //EV5
                MaterialButton(this@MainActivity), //EV6
                MaterialButton(this@MainActivity), //EV7
                MaterialButton(this@MainActivity), //EV8
                MaterialButton(this@MainActivity), //EV9
                MaterialButton(this@MainActivity) //EV10
            )

            //binding buttons
            (0 until buttonList.size).forEach { i ->
                buttonList[i] = when (i) {
                    0 -> btnEvalua0
                    1 -> btnEvalua1
                    2 -> btnEvalua2
                    3 -> btnEvalua3
                    4 -> btnEvalua4
                    5 -> btnEvalua5
                    6 -> btnEvalua6
                    7 -> btnEvalua7
                    8 -> btnEvalua8
                    9 -> btnEvalua9
                    10 -> btnEvalua10
                    else -> btnEvalua0
                }
            }
        })

        setUpResources(binding, sharedPrefService)
    }

    private fun setUpResources(binding: ActivityMainBinding, sharedPrefService: SharedPrefService) {

        //Set Up view animations
        setUpAnimations()

        //Set up buttons for view
        setUpButtons(buttonList, setUpAds(sharedPrefService))

        //Set up night mode listener
        setUpSwitchDarkMode(sharedPrefService)

        //Set up card view custom corners
        setUpCardViewCustomCorners(binding.mainCardView)
    }

    /**
     * Function in charge of start Admob Service
     *
     * If rewardDate is Active or is in TestMode the ads wont load
     *
     * @param sharedPrefService
     * @return Unit
     */
    private fun setUpAds(sharedPrefService: SharedPrefService): AdsService {

        val adsService = AdsService(this, supportFragmentManager, sharedPrefService)

        when {
            !test && isAdsAllowed(sharedPrefService) -> adsService.apply {

                logInfo(R.string.ADS_CARGADOS)

                //Load Ads
                loadIntersitial()
                loadRewardVideo()
            }
            else -> logInfo(R.string.ADS_NO_CARGADOS)
        }
        return adsService
    }

    /**
     * Function that config animations for Main Actvity
     *
     * @return Unit
     */
    private fun setUpAnimations() {

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
     * Function that handle the switchDarkMode in the main Activity
     *
     * @return Unit
     */
    private fun setUpSwitchDarkMode(sharedPrefService: SharedPrefService) {

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

    /**
     * Function that set a custom corners for a Material CardView
     *
     * @param materialCardView
     * @return Unit
     */
    private fun setUpCardViewCustomCorners(materialCardView: MaterialCardView) {
        //Custom card view corners
        materialCardView.shapeAppearanceModel
            .toBuilder()
            .setBottomLeftCorner(CornerFamily.ROUNDED, 32f)
            .setBottomRightCorner(CornerFamily.ROUNDED, 32f)
            .setTopRightCornerSize(0f)
            .setTopLeftCornerSize(0f)
            .build().also { materialCardView.shapeAppearanceModel = it }
    }

    /**
     * Function that handle listener for buttons in Main Activity
     *
     * @return Unit
     */
    private fun setUpButtons(
        buttonList: MutableList<MaterialButton>,
        adsService: AdsService
    ) {

        (0 until buttonList.size).forEach { i ->

            buttonList[i].setOnClickListener {

                var activityToOpen: Class<out Activity?>? = null

                when (i) {
                    0 -> {
                        logInfo(R.string.BTN_EVALUA_0)
                        activityToOpen = Evalua0Activity::class.java
                    }
                    1 -> {
                        logInfo(R.string.BTN_EVALUA_1)
                        activityToOpen = Evalua1Activity::class.java
                    }
                    2 -> {
                        logInfo(R.string.BTN_EVALUA_2)
                        activityToOpen = Evalua2Activity::class.java
                    }
                    3 -> {
                        logInfo(R.string.BTN_EVALUA_3)
                        activityToOpen = Evalua3Activity::class.java
                    }
                    4 -> {
                        logInfo(R.string.BTN_EVALUA_4)
                        activityToOpen = Evalua4Activity::class.java
                    }
                    5 -> {
                        logInfo(R.string.BTN_EVALUA_5)
                        activityToOpen = Evalua5Activity::class.java
                    }
                    6 -> {
                        logInfo(R.string.BTN_EVALUA_6)
                        activityToOpen = Evalua6Activity::class.java
                    }
                    7 -> {
                        logInfo(R.string.BTN_EVALUA_7)
                        activityToOpen = Evalua7Activity::class.java
                    }
                    8 -> {
                        logInfo(R.string.BTN_EVALUA_8)
                        activityToOpen = Evalua8Activity::class.java
                    }
                    9 -> {
                        logInfo(R.string.BTN_EVALUA_9)
                        activityToOpen = Evalua9Activity::class.java
                    }
                    10 -> {
                        logInfo(R.string.BTN_EVALUA_10)
                        activityToOpen = Evalua10Activity::class.java
                    }
                }
                adsService.checkIntersitialOnStart(activityToOpen, test)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == updateCode) {
            if (resultCode != RESULT_OK) {
                logInfo(R.string.UPDATE_FAIL)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        updateService.resumeUpdater()
    }
}