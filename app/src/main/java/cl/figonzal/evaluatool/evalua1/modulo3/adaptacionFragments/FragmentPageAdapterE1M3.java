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
 Last modified 02-07-20 21:28                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua1.modulo3.adaptacionFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPageAdapterE1M3 extends FragmentPagerAdapter {

    private static final String[] tabs = new String[4];

    public FragmentPageAdapterE1M3(@NonNull FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabs[0] = "Motivación";
        tabs[1] = "Autocontrol";
        tabs[2] = "Conductas Pro-sociales";
        tabs[3] = "Autoestima";
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment f = new Fragment();

        switch (position) {
            case 0:
                f = MotivacionFragmentE1M3.newInstance();
                break;

            case 1:
                f = AutoControlFragmentE1M3.newInstance();
                break;

            case 2:
                f = ConductaProSocialE1M3.newInstance();
                break;

            case 3:
                f = AutoEstimaFragmentE1M3.newInstance();
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
