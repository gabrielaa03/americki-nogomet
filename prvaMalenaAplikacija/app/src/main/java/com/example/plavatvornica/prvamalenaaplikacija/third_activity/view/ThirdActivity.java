package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.Fragmentinterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.MyPageAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.RecyclerAdapterFragment;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.FragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity implements Fragmentinterface {


    FragmentPresenter presenter;
    FragmentPagerAdapter fragmentPagerAdapter;
    RecyclerAdapterFragment  recyclerAdapterFragment;
    @BindView(R.id.vpPager)ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout,tabLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        presenter = new FragmentPresenter();

        fragmentPagerAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int year = 0;
                switch(position){

                    case 0:
                        year=2010;
                        break;
                    case 1:
                        year=2011;
                        break;
                    case 2:
                        year=2012;
                        break;
                    case 3:
                        year=2013;
                        break;
                }
                presenter.getCrimesOverYear(year, getA);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void sendListOfCrimesOverYear(List<Wrapper_Second> list) {
        recyclerAdapterFragment.addData(list);
    }
}
