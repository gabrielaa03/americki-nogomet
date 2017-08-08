package com.example.plavatvornica.prvamalenaaplikacija.third_activity.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.plavatvornica.prvamalenaaplikacija.third_activity.fragments.view.FirstFragment;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {
    private String[] namesOfPages = {"2010", "2011", "2012", "2013"};

    //promjeniti sam na jedan fragment i proslijediti position
    //u presenteru od fragmenta napraviti switch case koji prema position salje year
    //saljem godinu u activity i on salje svom presenteru i on salje request na server
    // i onda sve nazad u grafment

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FirstFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return namesOfPages[position];

    }
}
