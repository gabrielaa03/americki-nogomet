package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.ThirdActivityContract;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.adapters.MyPageAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.fragments.view.FirstFragment;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.ThirdPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity implements ThirdActivityContract.ThirdView,ThirdActivityContract.BetweenFragmentAndActivityInterface{

    MyPageAdapter myPageAdapter;

    @BindView(R.id.vpPager)ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    ThirdActivityContract.ThirdPresenter presenter;
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        tabLayout.setupWithViewPager(viewPager);

        presenter = new ThirdPresenterImpl(this);

        myPageAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    @Override
    public void sendDataToActivity(String start_date, String end_date, int pagePosition) {
        presenter.getData(start_date, end_date, pagePosition);
    }

    @Override
    public void sendListOfCrimesOverYear(List<Wrapper_Second> list, int pos) {

        fragmentList = getSupportFragmentManager().getFragments();

        for(Fragment fragment : fragmentList){
            if(fragment != null){
            int z = fragment.getArguments().getInt("position");
            FirstFragment fragment1 = (FirstFragment) fragment;
            if(z==pos){
                fragment1.addListToAdapter(list);
                break;
            }
            }
        }
    }

}
