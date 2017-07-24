package com.example.plavatvornica.prvamalenaaplikacija.third_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.FirstFragment;

import java.util.Map;

/**
 * Created by Plava tvornica on 21.7.2017..
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private static int NUMBER_OF_ITEMS = 4;
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }
//
    @Override
    public Fragment getItem(int position) {
        //promjeniti sam na jedan fragment i proslijediti position
        //u presenteru od fragmenta napraviti switch case koji prema position salje year
        //saljem godinu u activity i on salje svom presenteru i on salje request na server
        // i onda sve nazad u grafment

        return FirstFragment.newInstance(position);

    }
    @Override
    public int getCount() {
        return NUMBER_OF_ITEMS;
    }


}