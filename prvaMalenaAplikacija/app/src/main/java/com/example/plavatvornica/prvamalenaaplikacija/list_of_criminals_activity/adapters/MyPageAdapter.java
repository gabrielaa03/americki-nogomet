package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.view.MyFirstFragment;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {
    private String[] namesOfPages = {"2010", "2011", "2012", "2013"};

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyFirstFragment.newInstance(position);
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
