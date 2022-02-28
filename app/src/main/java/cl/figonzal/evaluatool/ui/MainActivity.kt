/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:27
 */
package cl.figonzal.evaluatool.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import cl.figonzal.evaluatool.BuildConfig
import cl.figonzal.evaluatool.R
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.service.ChangeLogService
import cl.figonzal.evaluatool.service.NightModeService
import cl.figonzal.evaluatool.service.UpdaterService
import cl.figonzal.evaluatool.utils.SharedPrefUtil
import cl.figonzal.evaluatool.utils.configureFABWsp
import cl.figonzal.evaluatool.utils.setUpCardViewCustomCorners
import cl.figonzal.evaluatool.utils.toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPrefUtil: SharedPrefUtil

    private lateinit var binding: ActivityMainBinding
    private val updateCode: Int = 350
    val test: Boolean = false

    //View Attributes
    private lateinit var switchDarkMode: SwitchMaterial
    private lateinit var tvAppName: TextView
    private lateinit var tvVersion: TextView
    private var buttonList = mutableListOf<MaterialButton>()

    private lateinit var updateService: UpdaterService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefUtil = SharedPrefUtil(this)

        //Night mode
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.Q -> {
                Timber.d("ANDROID_VERSION < Q: ${Build.VERSION.SDK_INT}")
                lifecycle.addObserver(NightModeService(this))

                setUpSwitchDarkMode()
            }
            else -> Timber.d("ANDROID_VERSION > Q: ${Build.VERSION.SDK_INT}")
        }

        //Change Log Service
        lifecycle.addObserver(ChangeLogService(this, SharedPrefUtil(this)))


        //UPDATEr
        /*
        with(SharedPrefUtil(this)) {
            updateService = UpdaterService(
                this@MainActivity, AppUpdateManagerFactory.create(this@MainActivity), updateCode
            )
        }*/

        bindingResources()
    }

    /**
     * Function that init resources that are used in this activity
     *
     * @return Unit
     */
    private fun bindingResources() {

        with(binding) {
            switchDarkMode = includeSwitch.switchMaterial

            this@MainActivity.tvAppName = tvNombreApp
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


            //Set Up view animations
            setUpAnimations()

            //Set up buttons for view
            //setUpButtons(buttonList, setUpAds(SharedPrefUtil))

            //Set up card view custom corners
            mainCardView.setUpCardViewCustomCorners()

            //Setup Settings button
            ivSettings.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }

            //handlePrivacyPolicy(SharedPrefUtil, test)

            configureFABWsp(fabWsp)
        }
    }

    /*
    private fun handlePrivacyPolicy(SharedPrefUtil: SharedPrefUtil, test: Boolean) {

        if (!test) {
            val privacyDialogShowed: Boolean = SharedPrefUtil.getData(
                getString(R.string.SHARED_PREF_PRIVACY_POLICY),
                false
            ) as Boolean

            if (!privacyDialogShowed) {
                FirebaseDialogFragment(
                    SharedPrefUtil,
                    this@MainActivity
                ).show(supportFragmentManager, "Dialog Fragment")

                Timber.d("Mostrando privacy policy dialog")
            } else {
                Timber.d("Privacy policy dialog ya mostrado")
            }
        }
    }*/

    /**
     * Function that config animations for Main Actvity
     *
     * @return Unit
     */
    private fun setUpAnimations() {

        val fadeList = mutableListOf<Animation>()
        val offset = 400L
        val step = 150L

        for (i in 0..12) {
            fadeList.add(AnimationUtils.loadAnimation(this, R.anim.anim_fade).also {
                when (i) {
                    0 -> it.startOffset = offset
                    else -> it.startOffset = offset + step * (i + 1)
                }
            })
        }

        //Start animations
        tvAppName.startAnimation(fadeList[0])
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
    private fun setUpSwitchDarkMode() {

        val nightMode =
            sharedPrefUtil.getData(getString(R.string.NIGHT_MODE_KEY), false) as Boolean

        with(switchDarkMode) {

            isChecked = nightMode
            setOnCheckedChangeListener { _, isChecked ->

                when {
                    isChecked -> {
                        toast(context.getString(R.string.NIGHT_MODE_ON))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                        sharedPrefUtil.saveData(getString(R.string.NIGHT_MODE_KEY), true)
                    }
                    else -> {
                        toast(context.getString(R.string.NIGHT_MODE_OFF))
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                        sharedPrefUtil.saveData(getString(R.string.NIGHT_MODE_KEY), false)
                    }
                }
            }
        }
    }

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

        //updateService.resumeUpdater()
    }
}