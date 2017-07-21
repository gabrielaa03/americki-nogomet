package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.Fragmentinterface;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.RecyclerAdapterFragment;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.FragmentPresenter;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class FirstFragment extends Fragment implements Fragmentinterface {
    private Unbinder unbinder;
    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterFragment adapter;
    FragmentPresenter presenter;

    public static FirstFragment newInstance(List<Wrapper_Second> list) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putSerializable("string", (ArrayList<Wrapper_Second>) list);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);

        Bundle bundle = this.getArguments();
        String start_date = bundle.getString("strings");
        String end_date = bundle.getString("strings1");

        presenter = new FragmentPresenter();
        presenter.getCrimesOverYear(start_date, end_date, this);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapterFragment();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void sendListOfCrimesOverYear(List<Wrapper_Second> list) {
        adapter.addData(list);

    }
}
