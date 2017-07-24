package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.BetweenFragmentAndActivityInterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.MyPageAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.ThirdInterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.ThirdPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity implements ThirdInterface,BetweenFragmentAndActivityInterface{

    MyPageAdapter fragmentPagerAdapter;

    @BindView(R.id.vpPager)ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    ThirdPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("2010"));
        tabLayout.addTab(tabLayout.newTab().setText("2011"));
        tabLayout.addTab(tabLayout.newTab().setText("2012"));
        tabLayout.addTab(tabLayout.newTab().setText("2013"));

        presenter = new ThirdPresenter();

        fragmentPagerAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void sendDataToActivity(String start_date, String end_date, int position) {
        presenter.getCrimesOverYear(start_date, end_date, position, this);
    }

    @Override
    public void sendListOfCrimesOverYear(List<Wrapper_Second> list, int pos) {
        Log.d("tag", "OVO JE POSITION: " + pos);

        List<Fragment> frag = getSupportFragmentManager().getFragments();
        List<FirstFragment> firstFragmentsList =  new ArrayList<>();
        for(int i=0; i<frag.size(); i++){
            firstFragmentsList.add((FirstFragment) frag.get(i));
        }

        FirstFragment fragment1 = FirstFragment.newInstance(pos);
        //FirstFragment fragment1 = new FirstFragment();
        for(FirstFragment fragment : firstFragmentsList){
            if(Integer.parseInt(fragment.getArguments().get("position").toString())==pos){
              //  int z =212+12;
                fragment1.addListToAdapter(list);
            }
        }

    }
}
