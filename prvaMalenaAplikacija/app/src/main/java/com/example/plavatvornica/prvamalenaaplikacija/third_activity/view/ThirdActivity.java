package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.Fragmentinterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.FragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity implements Fragmentinterface {


    FragmentPresenter presenter;
    FragmentPagerAdapter fragmentPagerAdapter;

    @BindView(R.id.vpPager) ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        presenter = new FragmentPresenter();

        fragmentPagerAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

    }

    public static class MyPageAdapter extends FragmentPagerAdapter{

        private static int NUMBER_OF_ITEMS = 4;

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){

                case 0:
                    return FirstFragment.newInstance(0, "2010");
                case 1:
                    return FirstFragment.newInstance(1, "2011");
                case 2:
                    return FirstFragment.newInstance(2, "2012");
                case 3:
                    return FirstFragment.newInstance(3, "2013");

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUMBER_OF_ITEMS;
        }
    }

    @Override
    public void sendListOfCrimesOverYear(List<String> list) {

    }
}
