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
 Last modified 03-07-20 16:18                                                 -
 -----------------------------------------------------------------------------*/

package cl.figonzal.evaluatool.evalua2.modulo3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.AutoControlFragmentE2M3;
import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.AutoEstimaFragmentE2M3;
import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.ConductaProSocialFragmentE2M3;
import cl.figonzal.evaluatool.evalua2.modulo3.adaptacionFragments.MotivacionFragmentE2M3;

public class FragmentPageAdapterE2M3 extends FragmentPagerAdapter {

    private static final String[] tabs = new String[4];

    public FragmentPageAdapterE2M3(@NonNull FragmentManager fm) {
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
                f = MotivacionFragmentE2M3.newInstance();
                break;

            case 1:
                f = AutoControlFragmentE2M3.newInstance();
                break;

            case 2:
                f = ConductaProSocialFragmentE2M3.newInstance();
                break;

            case 3:
                f = AutoEstimaFragmentE2M3.newInstance();
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
