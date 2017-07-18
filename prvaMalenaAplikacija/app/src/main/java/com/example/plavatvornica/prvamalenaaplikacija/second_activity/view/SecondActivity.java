package com.example.plavatvornica.prvamalenaaplikacija.second_activity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.SecondInterface;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.presenter.ListPresenter;

import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements SecondInterface {

    public static final String EXTRA_PLAYER_NAME = "EXTRA_PLAYER";
    public static final String EXTRA_TEAM_NAME = "EXTRA_TEAM";

    private ListPresenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.tv_name) TextView tvName;

    public String [] separated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        ButterKnife.bind(this);
        presenter = new ListPresenter();


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        String name = getIntent().getStringExtra(EXTRA_PLAYER_NAME);
        String name1 = getIntent().getStringExtra(EXTRA_TEAM_NAME);
        if(name1!=null){

            tvName.setText(name1);
            presenter.getInfo(name1, this);
        }else{
            tvName.setText(name);
            presenter.getInfo(name, this);
            StringTokenizer tokens = new StringTokenizer(name, " ");
            String firstPart = tokens.nextToken();
            String secondPart = tokens.nextToken();
            presenter.sortCrimes(firstPart, secondPart, this);

            Log.d("dsds",firstPart + " sldkalkdlakndlakjslajk " + secondPart);
        }


    }

    @Override
    public void getNameOfPlayerOrTeam() {
    }


}

