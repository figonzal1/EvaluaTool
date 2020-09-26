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
 Last modified 26-09-20 1:36                                                  -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua.evalua4.modulo3.adaptacionFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentStateAdapterE4M3 extends FragmentStateAdapter {

    private static final String[] tabs = new String[4];

    public FragmentStateAdapterE4M3(@NonNull FragmentActivity fa) {
        super(fa);
        tabs[0] = "Motivación";
        tabs[1] = "Autocontrol";
        tabs[2] = "Conductas Pro-sociales";
        tabs[3] = "Autoestima";
    }

    public static String[] getTabs() {
        return tabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment f = new Fragment();

        switch (position) {
            case 0:
                f = MotivacionFragmentE4M3.newInstance();
                break;

            case 1:
                f = AutoControlFragmentE4M3.newInstance();
                break;

            case 2:
                f = ConductaProSocialFragmentE4M3.newInstance();
                break;

            case 3:
                f = AutoEstimaFragmentE4M3.newInstance();
                break;
        }

        return f;
    }

    @Override
    public int getItemCount() {
        return tabs.length;
    }
}
