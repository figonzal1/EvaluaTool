/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 24-03-21 18:32
 */
package cl.figonzal.evaluatool

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import cl.figonzal.evaluatool.databinding.ActivityMainBinding
import cl.figonzal.evaluatool.dialogs.RewardDialogFragment
import cl.figonzal.evaluatool.evalua.evalua0.Evalua0Activity
import cl.figonzal.evaluatool.evalua.evalua1.Evalua1Activity
import cl.figonzal.evaluatool.evalua.evalua2.Evalua2Activity
import cl.figonzal.evaluatool.evalua.evalua3.Evalua3Activity
import cl.figonzal.evaluatool.evalua.evalua4.Evalua4Activity
import cl.figonzal.evaluatool.evalua.evalua5.Evalua5Activity
import cl.figonzal.evaluatool.evalua.evalua7.Evalua7Activity
import cl.figonzal.evaluatool.servicios.AdsService
import cl.figonzal.evaluatool.servicios.NightModeService
import cl.figonzal.evaluatool.servicios.SharedPrefService
import cl.figonzal.evaluatool.utilidades.ConfigRoutes
import cl.figonzal.evaluatool.utilidades.DateHandler
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import timber.log.Timber
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPrefService: SharedPrefService
    private lateinit var switchDarkMode: SwitchMaterial
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

    private lateinit var adsService: AdsService
    private lateinit var dateHandler: DateHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Checkear night mode
        sharedPrefService = SharedPrefService(this)
        NightModeService(this, this.lifecycle, sharedPrefService)

        instanciarRecursos()
        loadAds()
        animaciones()
        clickListeners()
        switchDarkModeListener()
    }

    private fun instanciarRecursos() {

        dateHandler = DateHandler()

        ConfigRoutes.setContext(applicationContext)

        switchDarkMode = binding.includeSwitch.switchMaterial

        tvNombreApp = binding.tvNombreApp
        tvVersion = binding.tvVersion
        tvVersion.text = String.format("v%s", BuildConfig.VERSION_NAME)

        btnEvalua0 = binding.btnEvalua0
        btnEvalua1 = binding.btnEvalua1
        btnEvalua2 = binding.btnEvalua2
        btnEvalua3 = binding.btnEvalua3
        btnEvalua4 = binding.btnEvalua4
        btnEvalua5 = binding.btnEvalua5
        btnEvalua6 = binding.btnEvalua6
        btnEvalua7 = binding.btnEvalua7
        btnEvalua8 = binding.btnEvalua8
        btnEvalua9 = binding.btnEvalua9
        btnEvalua10 = binding.btnEvalua10

        btnEvalua6.isEnabled = false
        btnEvalua6.alpha = 0.6f

        btnEvalua8.isEnabled = false
        btnEvalua8.alpha = 0.6f

        btnEvalua9.isEnabled = false
        btnEvalua9.alpha = 0.6f

        btnEvalua10.isEnabled = false
        btnEvalua10.alpha = 0.6f
    }

    private fun loadAds() {
        adsService = AdsService(this, supportFragmentManager, applicationContext, sharedPrefService)
        adsService.loadIntersitial()
        adsService.loadRewardVideo()
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
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_0))
            checkearPermisoIntersitial(Evalua0Activity::class.java)
        }
        btnEvalua1.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_1))
            checkearPermisoIntersitial(Evalua1Activity::class.java)
        }
        btnEvalua2.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_2))
            checkearPermisoIntersitial(Evalua2Activity::class.java)
        }
        btnEvalua3.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_3))
            checkearPermisoIntersitial(Evalua3Activity::class.java)
        }
        btnEvalua4.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_4))
            checkearPermisoIntersitial(Evalua4Activity::class.java)
        }
        btnEvalua5.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_5))
            checkearPermisoIntersitial(Evalua5Activity::class.java)
        }
        btnEvalua7.setOnClickListener {
            Timber.i("%s%s", getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_7))
            checkearPermisoIntersitial(Evalua7Activity::class.java)
        }
    }

    private fun checkearPermisoIntersitial(ActivityToOpen: Class<out Activity?>) {

        val rewardDate = Date(sharedPrefService.getData(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0L) as Long)

        Timber.i("%s%s", getString(R.string.TAG_BTN_REWARD_DATE), dateHandler.dateToString(applicationContext, rewardDate))

        val nowDate = Date()

        //si las 24 horas ya pasaron, cargar los ads nuevamente
        if (nowDate.after(rewardDate)) {

            adsService.showIntersitial(ActivityToOpen)
            Timber.i("%s%s", getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_PERMITIDOS))

        } else {
            val intent = Intent(this, ActivityToOpen)

            startActivity(intent)

            Timber.i("%s%s", getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_NO_PERMITIDOS))
        }
    }

    /**
     * Funcion que realiza la configuracion de reward dialog
     */
    fun rewardDialog() {

        val rewardDate = Date(sharedPrefService.getData(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0L) as Long)
        val nowDate = Date()

        //Si la hora del celular es posterior a reward date
        if (nowDate.after(rewardDate)) {

            Timber.d("%s%s", getString(R.string.TAG_REWARD_STATUS), getString(R.string.TAG_REWARD_STATUS_EN_PERIODO))

            //Generar % de aparicion de dialogo
            val showDialog = generateRandomNumber()
            if (showDialog) {

                //Mostrar dialog
                RewardDialogFragment(adsService).show(supportFragmentManager, getString(R.string.REWARD_DIALOG))

                Timber.d("%s%s", getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_ON))

            } else {
                Timber.d("%s%s", getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG_OFF))
            }
        } else if (nowDate.before(rewardDate)) {
            Timber.d("%s%s", getString(R.string.TAG_REWARD_STATUS), getString(R.string.TAG_REWARD_STATUS_PERIODO_INACTIVO))
        }
    }

    private fun switchDarkModeListener() {

        val nightMode = sharedPrefService.getData(getString(R.string.NIGHT_MODE_KEY), false) as Boolean
        switchDarkMode.isChecked = nightMode

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                Toast.makeText(this, "Modo noche activado", Toast.LENGTH_LONG).show()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                sharedPrefService.saveData(getString(R.string.NIGHT_MODE_KEY), true)

            } else {
                Toast.makeText(this, "Modo noche desactivado", Toast.LENGTH_LONG).show()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                sharedPrefService.saveData(getString(R.string.NIGHT_MODE_KEY), false)
            }
        }
    }

    /**
     * Funcion encargada de generar un numero aleatorio para dialogs.
     *
     * @return Booleano con el resultado
     */
    private fun generateRandomNumber(): Boolean {
        val random = Random()
        val item = random.nextInt(10)
        return item % 3 == 0
    }
}