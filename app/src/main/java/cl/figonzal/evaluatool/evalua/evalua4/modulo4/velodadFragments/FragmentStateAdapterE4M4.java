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

package cl.figonzal.evaluatool.evalua.evalua4.modulo4.velodadFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentStateAdapterE4M4 extends FragmentStateAdapter {

    private static final String[] tabs = new String[2];

    public FragmentStateAdapterE4M4(@NonNull FragmentActivity fa) {
        super(fa);
        tabs[0] = "Velocidad";
        tabs[1] = "Comprensión";
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
                f = VelocidadFragmentE4M4.newInstance();
                break;
            case 1:
                f = ComprensionFragmentE4M4.newInstance();
                break;
            default:
                break;
        }

        return f;
    }

    @Override
    public int getItemCount() {
        return tabs.length;
    }
}

