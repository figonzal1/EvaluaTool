/*
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package
 *
 * Autor: Felipe González
 * Email: felipe.gonzalezalarcon94@gmail.com
 *
 * Copyright (c) 2020
 *
 * Last modified 07-11-20 16:30
 */
package cl.figonzal.evaluatool

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cl.figonzal.evaluatool.dialogs.RewardDialogFragment
import cl.figonzal.evaluatool.evalua.evalua0.Evalua0Activity
import cl.figonzal.evaluatool.evalua.evalua1.Evalua1Activity
import cl.figonzal.evaluatool.evalua.evalua2.Evalua2Activity
import cl.figonzal.evaluatool.evalua.evalua3.Evalua3Activity
import cl.figonzal.evaluatool.evalua.evalua4.Evalua4Activity
import cl.figonzal.evaluatool.evalua.evalua5.Evalua5Activity
import cl.figonzal.evaluatool.evalua.evalua7.Evalua7Activity
import cl.figonzal.evaluatool.utilidades.Utilidades
import com.google.android.material.button.MaterialButton
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TEST_MODE = true
    }

    private lateinit var tvNombreApp: TextView
    private lateinit var tvVersion: TextView
    private lateinit var btnEvalua0: MaterialButton
    private lateinit var btnEvalua1: MaterialButton
    private lateinit var btnEvalua2: MaterialButton
    private lateinit var btnEvalua3: MaterialButton
    private lateinit var btnEvalua4: MaterialButton
    private lateinit var btnEvalua5: MaterialButton
    private lateinit var btnEvalua6: MaterialButton
    private lateinit var btnEvalua7: MaterialButton
    private lateinit var btnEvalua8: MaterialButton
    private lateinit var btnEvalua9: MaterialButton
    private lateinit var btnEvalua10: MaterialButton

    private var sharedPreferences: SharedPreferences? = null
    private var crashlytics: FirebaseCrashlytics? = null
    private var adsService: AdsService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instanciarRecursos()
        loadAds()
        rewardDialog()
        animaciones()
        clickListeners()
    }

    private fun instanciarRecursos() {
        tvNombreApp = findViewById(R.id.tv_nombre_app)
        tvVersion = findViewById(R.id.tv_version)
        tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

        btnEvalua0 = findViewById(R.id.btn_evalua_0)
        btnEvalua1 = findViewById(R.id.btn_evalua_1)
        btnEvalua2 = findViewById(R.id.btn_evalua_2)
        btnEvalua3 = findViewById(R.id.btn_evalua_3)
        btnEvalua4 = findViewById(R.id.btn_evalua_4)
        btnEvalua5 = findViewById(R.id.btn_evalua_5)
        btnEvalua6 = findViewById(R.id.btn_evalua_6)
        btnEvalua7 = findViewById(R.id.btn_evalua_7)
        btnEvalua8 = findViewById(R.id.btn_evalua_8)
        btnEvalua9 = findViewById(R.id.btn_evalua_9)
        btnEvalua10 = findViewById(R.id.btn_evalua_10)

        btnEvalua6.isEnabled = false
        btnEvalua6.alpha = 0.6f

        btnEvalua8.isEnabled = false
        btnEvalua8.alpha = 0.6f

        btnEvalua9.isEnabled = false
        btnEvalua9.alpha = 0.6f

        btnEvalua10.isEnabled = false
        btnEvalua10.alpha = 0.6f

        sharedPreferences = getSharedPreferences(getString(R.string.MAIN_SHARED_PREF), MODE_PRIVATE)
        crashlytics = FirebaseCrashlytics.getInstance()
    }

    private fun loadAds() {
        adsService = AdsService(this, applicationContext, crashlytics)
        adsService!!.loadIntersitial()
        adsService!!.loadRewardVideo(sharedPreferences)
    }

    /**
     * Funcion que realiza la configuracion de reward dialog
     */
    private fun rewardDialog() {

        val rewardDate = Date(sharedPreferences!!.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0))
        val nowDate = Date()

        adsService!!.loadRewardVideo(sharedPreferences)

        //Si la hora del celular es posterior a reward date
        if (nowDate.after(rewardDate)) {

            Timber.d("%s%s", getString(R.string.TAG_REWARD_STATUS), getString(R.string.TAG_REWARD_STATUS_EN_PERIODO))

            //Generar % de aparicion de dialogo
            val showDialog = Utilidades.generateRandomNumber()
            if (showDialog) {

                //Mostrar dialog
                val fragment = RewardDialogFragment(adsService!!)

                fragment.isCancelable = false
                fragment.show(supportFragmentManager, getString(R.string.REWARD_DIALOG))

                Timber.d("%s%s", getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_ON))

            } else {
                Timber.d("%s%s", getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_OFF))
            }
        } else if (nowDate.before(rewardDate)) {
            Timber.d("%s%s", getString(R.string.TAG_REWARD_STATUS), getString(R.string.TAG_REWARD_STATUS_PERIODO_INACTIVO))
        }
    }

    private fun animaciones() {

        val fadeNombreApp = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeVersion = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua0 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua1 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua2 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua3 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua4 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua5 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua6 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua7 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua8 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua9 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)
        val fadeEvalua10 = AnimationUtils.loadAnimation(this, R.anim.anim_fade)

        val offset = 400

        fadeNombreApp.startOffset = offset.toLong()
        fadeVersion.startOffset = offset + 150.toLong()
        fadeEvalua0.startOffset = offset + 300.toLong()
        fadeEvalua1.startOffset = offset + 450.toLong()
        fadeEvalua2.startOffset = offset + 600.toLong()
        fadeEvalua3.startOffset = offset + 750.toLong()
        fadeEvalua4.startOffset = offset + 900.toLong()
        fadeEvalua5.startOffset = offset + 1050.toLong()
        fadeEvalua6.startOffset = offset + 1200.toLong()
        fadeEvalua7.startOffset = offset + 1350.toLong()
        fadeEvalua8.startOffset = offset + 1500.toLong()
        fadeEvalua9.startOffset = offset + 1650.toLong()
        fadeEvalua10.startOffset = offset + 1800.toLong()

        tvNombreApp.startAnimation(fadeNombreApp)
        tvVersion.startAnimation(fadeVersion)
        btnEvalua0.startAnimation(fadeEvalua0)
        btnEvalua1.startAnimation(fadeEvalua1)
        btnEvalua2.startAnimation(fadeEvalua2)
        btnEvalua3.startAnimation(fadeEvalua3)
        btnEvalua4.startAnimation(fadeEvalua4)
        btnEvalua5.startAnimation(fadeEvalua5)
        btnEvalua6.startAnimation(fadeEvalua6)
        btnEvalua7.startAnimation(fadeEvalua7)
        btnEvalua8.startAnimation(fadeEvalua8)
        btnEvalua9.startAnimation(fadeEvalua9)
        btnEvalua10.startAnimation(fadeEvalua10)
    }

    private fun clickListeners() {
        btnEvalua0.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_0))
            checkearPermisoIntersitial(TEST_MODE, Evalua0Activity::class.java)
        }
        btnEvalua1.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_1))
            checkearPermisoIntersitial(TEST_MODE, Evalua1Activity::class.java)
        }
        btnEvalua2.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_2))
            checkearPermisoIntersitial(TEST_MODE, Evalua2Activity::class.java)
        }
        btnEvalua3.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_3))
            checkearPermisoIntersitial(TEST_MODE, Evalua3Activity::class.java)
        }
        btnEvalua4.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_4))
            checkearPermisoIntersitial(TEST_MODE, Evalua4Activity::class.java)
        }
        btnEvalua5.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_5))
            checkearPermisoIntersitial(TEST_MODE, Evalua5Activity::class.java)
        }
        btnEvalua7.setOnClickListener {
            Timber.d("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_7))
            checkearPermisoIntersitial(TEST_MODE, Evalua7Activity::class.java)
        }
    }

    private fun checkearPermisoIntersitial(testMode: Boolean, ActivityToOpen: Class<out Activity?>) {

        val rewardDate = Date(sharedPreferences!!.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0))

        Timber.d("%s%s", getString(R.string.TAG_BTN_REWARD_DATE), Utilidades.dateToString(applicationContext, rewardDate))

        val nowDate = Date()

        //si las 24 horas ya pasaron, cargar los ads nuevamente
        if (nowDate.after(rewardDate) && !testMode) {

            adsService!!.configIntersitialIntents(ActivityToOpen)
            Timber.d("%s%s", getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_PERMITIDOS))

        } else {
            val intent = Intent(this, ActivityToOpen)

            startActivity(intent)

            Timber.d("%s%s", getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_NO_PERMITIDOS))
        }
    }
}