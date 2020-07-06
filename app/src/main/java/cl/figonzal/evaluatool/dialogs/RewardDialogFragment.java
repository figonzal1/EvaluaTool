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
 Last modified 05-07-20 23:54                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.dialogs;


import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Objects;

import cl.figonzal.evaluatool.Admob;
import cl.figonzal.evaluatool.R;

public class RewardDialogFragment extends DialogFragment {

    private Admob admob;
    private FirebaseCrashlytics crashlytics;

    public RewardDialogFragment(Admob admob, FirebaseCrashlytics crashlytics) {
        this.admob = admob;
        this.crashlytics = crashlytics;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        //LayoutInflater inflater = requireActivity().getLayoutInflater();
        //View view = inflater.inflate(R.layout.reward_dialog_layout, null);
        //builder.setView(view);

        builder.setTitle("¡Apoya a la aplicación!");
        builder.setMessage("Ve el video, apoya gratis monetariamente y recibe 1 hora libre de publicidad");
        builder.setPositiveButton("Ver video", (dialog, which) -> {

            if (admob.getRewardedVideoAd().isLoaded()) {
                dismiss();
                admob.getRewardedVideoAd().show();

                Log.d(getString(R.string.TAG_REWARD_DIALOG), getString(R.string
                        .TAG_REWARD_DIALOG_BTN_VER_VIDEO));
                crashlytics.log(getString(R.string.TAG_REWARD_DIALOG) + getString(R.string
                        .TAG_REWARD_DIALOG_BTN_VER_VIDEO));
            }

            crashlytics.log(getString(R.string.TAG_REWARD_DIALOG) + getString(R.string
                    .TAG_REWARD_DIALOG_BTN_VER_VIDEO));

            dismiss();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> {

            Log.d(getString(R.string.TAG_REWARD_DIALOG), getString(R.string
                    .TAG_REWARD_DIALOG_BTN_CANCEL));
            crashlytics.log(getString(R.string.TAG_REWARD_DIALOG) + getString(R.string
                    .TAG_REWARD_DIALOG_BTN_CANCEL));
            dismiss();
        });

        return builder.create();
    }
}
