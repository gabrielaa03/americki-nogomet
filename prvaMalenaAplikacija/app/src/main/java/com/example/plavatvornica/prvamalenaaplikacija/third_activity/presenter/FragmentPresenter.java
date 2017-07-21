package com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrimeOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.RecAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.Fragmentinterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class FragmentPresenter extends Fragment {

    private List<Wrapper_Second> lCrimeOverYear = new ArrayList<>();

    Call<List<FeedCrimeOverYear>> feedCrimeOverYear;

    @BindView(R.id.recycler_view_fragment)RecyclerView recyclerViewFragment;

    RecyclerView.LayoutManager layoutManager;
    RecAdapter mAdapter;
    List<FeedCrimeOverYear> mDataset;
    String title;
    int page;

    public static FragmentPresenter newInstance(int page, String title) {
        FragmentPresenter presenter = new FragmentPresenter();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        presenter.setArguments(args);
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        layoutManager = new LinearLayoutManager(getActivity());

        recyclerViewFragment.setAdapter(mAdapter);
        return view;


    }

    public void getCrimesOverYear(int year, final Fragmentinterface listener){
        feedCrimeOverYear= RestUtils.getApi().listOfCrimesOverYear(year);
        feedCrimeOverYear.enqueue(new Callback<List<FeedCrimeOverYear>>() {
            @Override
            public void onResponse(Call<List<FeedCrimeOverYear>> call, Response<List<FeedCrimeOverYear>> response) {
                List<FeedCrimeOverYear> list = response.body();
                for(int i=0; i<list.size();i++){
                    lCrimeOverYear.add(new Wrapper_Second(list.get(i).getName(), Wrapper_Second.TYPE_NAME_OF_PLAYER));
                }
                listener.sendListOfCrimesOverYear(lCrimeOverYear);
            }

            @Override
            public void onFailure(Call<List<FeedCrimeOverYear>> call, Throwable t) {
                Log.d("TAG", "Ne radi response godine.");
            }
        });
    }

}
