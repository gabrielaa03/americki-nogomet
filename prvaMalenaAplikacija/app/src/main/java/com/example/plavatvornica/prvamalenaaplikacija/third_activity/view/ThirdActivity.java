package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.Fragmentinterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.MyPageAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.RecyclerAdapterFragment;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.FragmentPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity{



    FragmentPagerAdapter fragmentPagerAdapter;
    RecyclerAdapterFragment  recyclerAdapterFragment;
    @BindView(R.id.vpPager)ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    String start_date ="";
    String end_date="";
    List<Wrapper_Second> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        Bundle bundle = new Bundle();
        bundle.putString("strings", start_date);
        bundle.putString("strings1", end_date);
        FirstFragment myFragment = new FirstFragment();
        myFragment.setArguments(bundle);

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

               switch(position){

                    case 0:
                        start_date = "2010-01-01";
                        end_date = "2010-12-31";
                        break;
                    case 1:
                        start_date = "2011-01-01";
                        end_date = "2011-12-31";

                        break;
                    case 2:
                        start_date = "2012-01-01";
                        end_date = "2012-12-31";

                        break;
                    case 3:
                        start_date = "2013-01-01";
                        end_date = "2013-12-31";

                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

}
