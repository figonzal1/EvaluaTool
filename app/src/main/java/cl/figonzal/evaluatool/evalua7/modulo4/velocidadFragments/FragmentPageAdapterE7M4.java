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
 Last modified 16-07-20 23:57                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua7.modulo4.velocidadFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPageAdapterE7M4 extends FragmentPagerAdapter {

    private static final String[] tabs = new String[2];

    public FragmentPageAdapterE7M4(@NonNull FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabs[0] = "Velocidad";
        tabs[1] = "Comprensión";
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment f = new Fragment();

        switch (position) {
            case 0:
                f = VelocidadFragmentE7M4.newInstance();
                break;
            case 1:
                f = ComprensionFragmentE7M4.newInstance();
                break;
            default:
                break;
        }

        return f;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
