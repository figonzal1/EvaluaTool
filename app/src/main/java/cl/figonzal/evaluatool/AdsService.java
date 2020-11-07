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
 Last modified 07-11-20 19:59                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Date;

import cl.figonzal.evaluatool.utilidades.Utilidades;

public class AdsService {

    private InterstitialAd interstitialAd;
    private RewardedVideoAd rewardedVideoAd;
    private final Context context;
    private final Activity activity;

    public AdsService(Activity activity, Context context) {

        MobileAds.initialize(context);
        this.context = context;
        this.activity = activity;
    }


    //INTERSITIAL
    public void loadIntersitial() {

        if (interstitialAd == null) {
            interstitialAd = new InterstitialAd(context);
            interstitialAd.setAdUnitId(context.getString(R.string.ADMOB_ID_INTERSITIAL));
        }
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void configIntersitialIntents(Class<? extends Activity> ActivityToOpen) {

        if (interstitialAd.isLoaded()) {

            Log.d(context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CARGADO));

            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();

                    Log.d(context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_CERRADO));

                    Intent intent = new Intent(context, ActivityToOpen);
                    context.startActivity(intent);

                    //Cargar el siguiente
                    loadIntersitial();
                }

                @Override
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);

                    Log.d(context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_FALLADO));

                    Intent intent = new Intent(context, ActivityToOpen);
                    context.startActivity(intent);
                }
            });

            getInterstitialAd().show();

        } else {
            Log.d(context.getString(R.string.TAG_INTERSITIAL_STATUS), context.getString(R.string.INTERSITIAL_NO_CARGADO));

            Intent intent = new Intent(context, ActivityToOpen);
            context.startActivity(intent);
        }
    }


    //REWARDS VIDEO
    public void loadRewardVideo(SharedPreferences sharedPreferences) {
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context);
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Log.d(context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_LOADED));

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
                Log.d(context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_REWARDED));
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Log.d(context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_FAILED));

            }

            @Override
            public void onRewardedVideoCompleted() {

                Log.d(context.getString(R.string.TAG_VIDEO_REWARD_STATUS), context.getString(R.string.TAG_VIDEO_REWARD_STATUS_COMPLETED));

                Date date_now = new Date();

                Log.d(context.getString(R.string.TAG_HORA_AHORA), Utilidades.dateToString(context, date_now));

                //sumar 1 horas al tiempo del celular
                Date date_new = Utilidades.addHoursToJavaUtilDate(date_now, 1);

                Log.d(context.getString(R.string.TAG_HORA_REWARD), Utilidades.dateToString(context, date_new));

                //Guardar fecha de termino de reward
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong(context.getString(R.string.SHARED_PREF_END_REWARD_TIME), date_new.getTime()).apply();
                activity.recreate();
            }
        });
        rewardedVideoAd.loadAd(context.getString(R.string.ADMOB_ID_VIDEO), new AdRequest.Builder().build());
    }

    //GETTERS

    public RewardedVideoAd getRewardedVideoAd() {
        return rewardedVideoAd;
    }

    public InterstitialAd getInterstitialAd() {
        return interstitialAd;
    }
}
