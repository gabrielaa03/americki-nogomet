package com.example.plavatvornica.prvamalenaaplikacija.third_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.FragmentPresenter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.FirstFragment;

import java.util.List;

/**
 * Created by Plava tvornica on 21.7.2017..
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    private static int NUMBER_OF_ITEMS = 4;
    private FragmentPresenter presenter;
    private List<Wrapper_Second> year2010, year2011, year2012, year2013;
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance(year2010);
            case 1:
                return FirstFragment.newInstance(year2011);

            case 2:
                return FirstFragment.newInstance(year2012);

            case 3:
                return FirstFragment.newInstance(year2013);

            default:
                return FirstFragment.newInstance(year2010);
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_ITEMS;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "2010";
            case 1:
                return "2011";
            case 2:
                return "2012";
            case 3:
                return "2013";
            default:
                return null;
        }
    }

}