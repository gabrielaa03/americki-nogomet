package com.example.plavatvornica.prvamalenaaplikacija.third_activity.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.RecyclerAdapterFragment;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class FirstFragment extends Fragment {

    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterFragment adapter;
    List<Wrapper_Second> list ;

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
        adapter = new RecyclerAdapterFragment();
        recyclerView.setAdapter(adapter);

        list = (List<Wrapper_Second>) getArguments().getSerializable("string");

        return view;
    }
}
