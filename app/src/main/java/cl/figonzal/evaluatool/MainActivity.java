/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 17:21                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.button.MaterialButton;

import java.util.Date;

import cl.figonzal.evaluatool.dialogs.RewardDialogFragment;
import cl.figonzal.evaluatool.evalua0.Evalua0Activity;
import cl.figonzal.evaluatool.evalua3.Evalua3Activity;
import cl.figonzal.evaluatool.evalua7.Evalua7Activity;

public class MainActivity extends AppCompatActivity {

    private final Boolean testMode = false;
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
    private RewardedVideoAd rewardedVideoAd;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.ADMOB_MASTER_KEY));

        InterstitialAd mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ADMOB_ID_INTERSITIAL));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        instanciarRecursos();

        rewardDialog();

        animaciones();

        clickListeners(mInterstitialAd);
    }

    private void clickListeners(final InterstitialAd mInterstitialAd) {
        btn_evalua_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_0));

                Crashlytics.log(Log.DEBUG, getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_0));

                checkearPermisoIntersitial(testMode, mInterstitialAd, Evalua0Activity.class);
            }
        });

        btn_evalua_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_3));

                Crashlytics.log(Log.DEBUG, getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_3));

                checkearPermisoIntersitial(testMode, mInterstitialAd, Evalua3Activity.class);
            }
        });

        btn_evalua_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_7));

                Crashlytics.log(Log.DEBUG, getString(R.string.BUTTON_MAIN), getString(R.string.BTN_EVALUA_7));

                checkearPermisoIntersitial(testMode, mInterstitialAd, Evalua7Activity.class);
            }
        });
    }

    private void checkearPermisoIntersitial(boolean testMode, InterstitialAd mInterstitialAd, Class<? extends Activity> ActivityToOpen) {
        Date reward_date =
                new Date(sharedPreferences.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0));

        Log.d(getString(R.string.TAG_BTN_REWARD_DATE), Utilidades.dateToString(getApplicationContext(), reward_date));

        Date now_date = new Date();

        //si las 24 horas ya pasaron, cargar los ads nuevamente
        if (now_date.after(reward_date) && !testMode) {
            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_PERMITIDOS));

            configurarIntersitial(mInterstitialAd, ActivityToOpen);

        } else {
            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.TAG_ADS_NO_PERMITIDOS));

            Intent intent = new Intent(MainActivity.this, ActivityToOpen);
            startActivity(intent);
        }
    }

    private void instanciarRecursos() {
        tv_nombre_app = findViewById(R.id.tv_nombre_app);

        tv_version = findViewById(R.id.tv_version);
        tv_version.setText(String.format("v%s", BuildConfig.VERSION_NAME));

        btn_evalua_0 = findViewById(R.id.btn_evalua_0);

        btn_evalua_1 = findViewById(R.id.btn_evalua_1);
        btn_evalua_1.setEnabled(false);
        btn_evalua_1.setAlpha(0.6f);

        btn_evalua_2 = findViewById(R.id.btn_evalua_2);
        btn_evalua_2.setEnabled(false);
        btn_evalua_2.setAlpha(0.6f);

        btn_evalua_3 = findViewById(R.id.btn_evalua_3);

        btn_evalua_4 = findViewById(R.id.btn_evalua_4);
        btn_evalua_4.setEnabled(false);
        btn_evalua_4.setAlpha(0.6f);

        btn_evalua_5 = findViewById(R.id.btn_evalua_5);
        btn_evalua_5.setEnabled(false);
        btn_evalua_5.setAlpha(0.6f);

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

    private void configurarIntersitial(final InterstitialAd interstitialAd, final Class<? extends Activity> ActivityToOpen) {

        if (interstitialAd.isLoaded()) {

            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.INTERSITIAL_CARGADO));

            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();

                    Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.INTERSITIAL_CERRADO));
                    Intent intent = new Intent(MainActivity.this, ActivityToOpen);
                    startActivity(intent);

                    interstitialAd.loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);

                    Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.INTERSITIAL_FALLADO));
                    Intent intent = new Intent(MainActivity.this, ActivityToOpen);
                    startActivity(intent);
                }
            });
            interstitialAd.show();
        } else {
            Log.d(getString(R.string.TAG_INTERSITIAL_STATUS), getString(R.string.INTERSITIAL_NO_CARGADO));

            Intent intent = new Intent(MainActivity.this, ActivityToOpen);
            startActivity(intent);
        }
    }

    /**
     * Funcion que realiza la configuracion de reward dialog
     */
    private void rewardDialog() {

        Date reward_date = new Date(sharedPreferences.getLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), 0));
        Date now_date = new Date();

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.d(getString(R.string.TAG_VIDEO_REWARD_STATUS), getString(R.string
                        .TAG_VIDEO_REWARD_STATUS_LOADED));
            }

            @Override
            public void onRewardedVideoAdOpened() {
            }

            @Override
            public void onRewardedVideoStarted() {
            }

            @Override
            public void onRewardedVideoAdClosed() {
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Log.d(getString(R.string.TAG_VIDEO_REWARD_STATUS), getString(R.string
                        .TAG_VIDEO_REWARD_STATUS_REWARDED));
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Log.d(getString(R.string.TAG_VIDEO_REWARD_STATUS), getString(R.string
                        .TAG_VIDEO_REWARD_STATUS_FAILED));
            }

            @Override
            public void onRewardedVideoCompleted() {

                Log.d(getString(R.string.TAG_VIDEO_REWARD_STATUS), getString(R.string
                        .TAG_VIDEO_REWARD_STATUS_COMPLETED));
                Date date_now = new Date();

                Log.d(getString(R.string.TAG_HORA_AHORA), Utilidades.dateToString(getApplicationContext(), date_now));

                //sumar 1 horas al tiempo del celular
                Date date_new = Utilidades.addHoursToJavaUtilDate(date_now, 1);

                Log.d(getString(R.string.TAG_HORA_REWARD), Utilidades.dateToString(getApplicationContext(), date_new));

                //Guardar fecha de termino de reward
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong(getString(R.string.SHARED_PREF_END_REWARD_TIME), date_new.getTime()).apply();
                recreate();
            }
        });

        //Si la hora del celular es posterior a reward date
        if (now_date.after(reward_date)) {

            Log.d(getString(R.string.TAG_REWARD_STATUS), getString(R.string
                    .TAG_REWARD_STATUS_EN_PERIODO));

            //Cargar video
            loadRewardedVideo();

            //Generar % de aparicion de dialogo
            boolean showDialog = Utilidades.generateRandomNumber();
            if (showDialog) {

                //Cargar dialog
                mostrarDialog();

                Log.d(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_ON));
            } else {
                Log.d(getString(R.string.TAG_RANDOM_SHOW_REWARD_DIALOG), getString(R.string
                        .TAG_RANDOM_SHOW_REWARD_DIALOG_OFF));
            }
        }
        //Si el periodo de reward aun no pasa
        else if (now_date.before(reward_date)) {
            Log.d(getString(R.string.TAG_REWARD_STATUS), getString(R.string
                    .TAG_REWARD_STATUS_PERIODO_INACTIVO));
        }
    }

    /**
     * Funcion encargada
     * de cargar
     * el video
     * de bonificacion
     */
    private void loadRewardedVideo() {
        rewardedVideoAd.loadAd(getString(R.string.ADMOB_ID_VIDEO), new AdRequest.Builder()
                .build());
    }

    /**
     * Funcion encargada de mostrar el dialog de rewards
     */
    private void mostrarDialog() {

        RewardDialogFragment fragment = new RewardDialogFragment(rewardedVideoAd);
        fragment.setCancelable(false);
        fragment.show(getSupportFragmentManager(), getString(R.string.REWARD_DIALOG));
    }
}
