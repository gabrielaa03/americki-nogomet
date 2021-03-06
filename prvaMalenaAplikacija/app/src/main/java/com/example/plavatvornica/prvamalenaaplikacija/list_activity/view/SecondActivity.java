package com.example.plavatvornica.prvamalenaaplikacija.list_activity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.base.MyApplication;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.RecAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.SecondActivityContract;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.di.ListModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements SecondActivityContract.SecondActivityView {

    public static final String EXTRA_PLAYER_NAME = "EXTRA_PLAYER";
    public static final String EXTRA_TEAM_NAME = "EXTRA_TEAM";

    private RecAdapter recAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_name)
    TextView tvName;
    private String teamName, playerName;

    @Inject
    SecondActivityContract.ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        MyApplication.appComponent.plus(new ListModule(this)).inject(this);

        ButterKnife.bind(this);
        recAdapter = new RecAdapter();
        recyclerView.setAdapter(recAdapter);
        recAdapter.setClickListener(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        playerName = getIntent().getStringExtra(EXTRA_PLAYER_NAME);
        teamName = getIntent().getStringExtra(EXTRA_TEAM_NAME);
        tvName.setText(playerName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.initialize(playerName, teamName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void sendPlayersCrimes(List<Wrapper> list) {
        recAdapter.addDataIntoRecycler(list);
    }

    @Override
    public void sendSortedCrimes(List<Wrapper> list) {
        recAdapter.addDataIntoRecycler(list);
    }

    @Override
    public void onClick(View view, String text) {

        Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}



