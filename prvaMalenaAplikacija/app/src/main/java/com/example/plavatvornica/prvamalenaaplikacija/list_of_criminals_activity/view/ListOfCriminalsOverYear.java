package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.base.MyApplication;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.ListOfCriminalsContract;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.adapters.MyPageAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.di.PagesModule;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.view.MyFirstFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListOfCriminalsOverYear extends AppCompatActivity implements ListOfCriminalsContract.ThirdView, ListOfCriminalsContract.BetweenFragmentAndActivityInterface {

    MyPageAdapter myPageAdapter;

    @BindView(R.id.vpPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @Inject
    ListOfCriminalsContract.ThirdPresenter presenter;
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        MyApplication.appComponent.plus(new PagesModule(this)).inject(this);
        ButterKnife.bind(this);

        tabLayout.setupWithViewPager(viewPager);
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

        for (Fragment fragment : fragmentList) {
            if (fragment != null) {
                int z = fragment.getArguments().getInt("position");
                MyFirstFragment fragment1 = (MyFirstFragment) fragment;
                if (z == pos) {
                    fragment1.addListToAdapter(list);
                    break;
                }
            }
        }
    }
}
