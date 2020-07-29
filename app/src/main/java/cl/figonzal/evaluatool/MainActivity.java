/*-----------------------------------------------------------------------------
                                                                              -
 This file is subject to the terms and conditions defined in                  -
 file 'LICENSE', which is part of this source code package                    -
                                                                              -
 Autor: Felipe González                                                       -
 Email: felipe.gonzalezalarcon94@gmail.com                                    -
                                                                              -
 Copyright (c) 2020                                                           -
                                                                              -
 Last modified 28-07-20 21:13                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Date;

import cl.figonzal.evaluatool.dialogs.RewardDialogFragment;
import cl.figonzal.evaluatool.evalua0.Evalua0Activity;
import cl.figonzal.evaluatool.evalua1.Evalua1Activity;
import cl.figonzal.evaluatool.evalua2.Evalua2Activity;
import cl.figonzal.evaluatool.evalua3.Evalua3Activity;
import cl.figonzal.evaluatool.evalua4.Evalua4Activity;
import cl.figonzal.evaluatool.evalua5.Evalua5Activity;
import cl.figonzal.evaluatool.evalua7.Evalua7Activity;

public class MainActivity extends AppCompatActivity {

    private final Boolean TEST_MODE = true; //TODO: Cambiar en produccion
    private TextView tv_nombre_app;
    private TextView tv_version;
    private MaterialButton btn_evalua_0;
    private MaterialButton btn_evalua_1;
    private MaterialButton btn_evalua_2;
    private MaterialButton btn_evalua_3;
    private MaterialButton btn_evalua_4;
    private MaterialButton btn_evalua_5;
    private MaterialButton btn_evalua_6;
    private MaterialButton btn_evalua_7;
    private MaterialButton btn_evalua_8;
    private MaterialButton btn_evalua_9;
    private MaterialButton btn_evalua_10;

    private SharedPreferences sharedPreferences;

    private FirebaseCrashlytics crashlytics;

    private Admob admob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instanciarRecursos();

        loadAds();

        rewardDialog();

        animaciones();

        clickListeners();
    }

    private void instanciarRecursos() {
        tv_nombre_app = findViewById(R.id.tv_nombre_app);

        tv_version = findViewById(R.id.tv_version);
        tv_version.setText(String.format("v%s", BuildConfig.VERSION_NAME));

        btn_evalua_0 = findViewById(R.id.btn_evalua_0);

        btn_evalua_1 = findViewById(R.id.btn_evalua_1);

        btn_evalua_2 = findViewById(R.id.btn_evalua_2);

        btn_evalua_3 = findViewById(R.id.btn_evalua_3);

        btn_evalua_4 = findViewById(R.id.btn_evalua_4);

        btn_evalua_5 = findViewById(R.id.btn_evalua_5);

        btn_evalua_6 = findViewById(R.id.btn_evalua_6);
        btn_evalua_6.setEnabled(false);
        btn_evalua_6.setAlpha(0.6f);

        btn_evalua_7 = findViewById(R.id.btn_evalua_7);

        btn_evalua_8 = findViewById(R.id.btn_evalua_8);
        btn_evalua_8.setEnabled(false);
        btn_evalua_8.setAlpha(0.6f);

        btn_evalua_9 = findViewById(R.id.btn_evalua_9);
        btn_evalua_9.setEnabled(false);
        btn_evalua_9.setAlpha(0.6f);

        btn_evalua_10 = findViewById(R.id.btn_evalua_10);
        btn_evalua_10.setEnabled(false);
        btn_evalua_10.setAlpha(0.6f);

        sharedPreferences = getSharedPreferences(getString(R.string.MAIN_SHARED_PREF), Context.MODE_PRIVATE);

        crashlytics = FirebaseCrashlytics.getInstance();
    }

    private void loadAds() {
        admob = new Admob(this, getApplicationContext(), crashlytics);
        admob.loadIntersitial();
        admob.loadRewardVideo(sharedPreferences);
    }

    /**
     * Funcion que realiza la configuracion de reward dialog
     */
    private void rewardDialog() {

        Date reward_date = new Date(sharedPreferences.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0));
        Date now_date = new Date();

        admob.loadRewardVideo(sharedPreferences);

        //Si la hora del celular es posterior a reward date
        if (now_date.after(reward_date)) {

            Log.d(getString(R.string.TAG_REWARD_STATUS), getString(R.string
                    .TAG_REWARD_STATUS_EN_PERIODO));
            crashlytics.log(getString(R.string.TAG_REWARD_STATUS) + getString(R.string
                    .TAG_REWARD_STATUS_EN_PERIODO));

            //Generar % de aparicion de dialogo
            boolean showDialog = Utilidades.generateRandomNumber();
            if (showDialog) {

                //Mostrar dialog
                RewardDialogFragment fragment = new RewardDialogFragment(admob, crashlytics);
                fragment.setCancelable(false);
                fragment.show(getSupportFragmentManager(), getString(R.string.REWARD_DIALOG));

                Log.d(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_ON));
                crashlytics.log(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG) + getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_ON));
            } else {
                Log.d(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_OFF));
                crashlytics.log(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG) + getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_OFF));
            }
        }
        //Si el periodo de reward aun no pasa
        else if (now_date.before(reward_date)) {
            Log.d(getString(R.string.TAG_REWARD_STATUS), getString(R.string
                    .TAG_REWARD_STATUS_PERIODO_INACTIVO));
            crashlytics.log(getString(R.string.TAG_REWARD_STATUS) + getString(R.string
                    .TAG_REWARD_STATUS_PERIODO_INACTIVO));
        }
    }

    private void animaciones() {

        Animation fade_nombre_app = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_version = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_0 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_1 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_2 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_3 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_4 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_5 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_6 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_7 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_8 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_9 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        Animation fade_evalua_10 = AnimationUtils.loadAnimation(this, R.anim.anim_fade);

        int offset = 400;
        fade_nombre_app.setStartOffset(offset);
        fade_version.setStartOffset(offset + 150);
        fade_evalua_0.setStartOffset(offset + 300);
        fade_evalua_1.setStartOffset(offset + 450);
        fade_evalua_2.setStartOffset(offset + 600);
        fade_evalua_3.setStartOffset(offset + 750);
        fade_evalua_4.setStartOffset(offset + 900);
        fade_evalua_5.setStartOffset(offset + 1050);
        fade_evalua_6.setStartOffset(offset + 1200);
        fade_evalua_7.setStartOffset(offset + 1350);
        fade_evalua_8.setStartOffset(offset + 1500);
        fade_evalua_9.setStartOffset(offset + 1650);
        fade_evalua_10.setStartOffset(offset + 1800);


        tv_nombre_app.startAnimation(fade_nombre_app);
        tv_version.startAnimation(fade_version);

        btn_evalua_0.startAnimation(fade_evalua_0);
        btn_evalua_1.startAnimation(fade_evalua_1);
        btn_evalua_2.startAnimation(fade_evalua_2);
        btn_evalua_3.startAnimation(fade_evalua_3);
        btn_evalua_4.startAnimation(fade_evalua_4);
        btn_evalua_5.startAnimation(fade_evalua_5);
        btn_evalua_6.startAnimation(fade_evalua_6);
        btn_evalua_7.startAnimation(fade_evalua_7);
        btn_evalua_8.startAnimation(fade_evalua_8);
        btn_evalua_9.startAnimation(fade_evalua_9);
        btn_evalua_10.startAnimation(fade_evalua_10);
    }

    private void clickListeners() {
        btn_evalua_0.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_0));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_0));

            checkearPermisoIntersitial(TEST_MODE, Evalua0Activity.class);
        });

        btn_evalua_1.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_1));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_1));

            checkearPermisoIntersitial(TEST_MODE, Evalua1Activity.class);
        });

        btn_evalua_2.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_2));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_2));

            checkearPermisoIntersitial(TEST_MODE, Evalua2Activity.class);
        });

        btn_evalua_3.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_3));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_3));

            checkearPermisoIntersitial(TEST_MODE, Evalua3Activity.class);
        });

        btn_evalua_4.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_4));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_4));

            checkearPermisoIntersitial(TEST_MODE, Evalua4Activity.class);
        });

        btn_evalua_5.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_5));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_5));

            checkearPermisoIntersitial(TEST_MODE, Evalua5Activity.class);
        });

        btn_evalua_7.setOnClickListener(v -> {
            Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_7));

            crashlytics.log(getString(R.string.BUTTON_MAIN) + getString(R.string.BTN_EVALUA_7));

            checkearPermisoIntersitial(TEST_MODE, Evalua7Activity.class);
        });
    }

    private void checkearPermisoIntersitial(boolean testMode, Class<? extends Activity> ActivityToOpen) {
        Date reward_date =
                new Date(sharedPreferences.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0));

        Log.d(getString(R.string.TAG_BTN_REWARD_DATE), Utilidades.dateToString(getApplicationContext(), reward_date));

        crashlytics.log(getString(R.string.TAG_BTN_REWARD_DATE) + Utilidades.dateToString(getApplicationContext(), reward_date));

        Date now_date = new Date();

        //si las 24 horas ya pasaron, cargar los ads nuevamente
        if (now_date.after(reward_date) && !testMode) {

            admob.configIntersitialIntents(ActivityToOpen);

            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_PERMITIDOS));
            crashlytics.log(getString(R.string.TAG_INTERSITIAL_STATUS) + getString(R.string.TAG_ADS_PERMITIDOS));

        } else {
            Intent intent = new Intent(MainActivity.this, ActivityToOpen);
            startActivity(intent);

            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_NO_PERMITIDOS));
            crashlytics.log(getString(R.string.TAG_INTERSITIAL_STATUS) + getString(R.string.TAG_ADS_NO_PERMITIDOS));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //rewardDialog();
    }
}
