package com.example.plavatvornica.prvamalenaaplikacija.home_activity.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.base.MyApplication;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.HomeContract;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.di.HomeModule;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.view.SecondActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.view.ListOfCriminalsOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.view.TimeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements HomeContract.HomeActivityView {
    @BindView(R.id.tv_worst_crime_value)
    TextView tvCrime;
    @BindView(R.id.tv_worst_player_value)
    TextView tvPlayer;
    @BindView(R.id.tv_worst_team_value)
    TextView tvTeam;

    @Inject
    HomeContract.HomeActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        MyApplication.appComponent.plus(new HomeModule(this)).inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @OnClick(R.id.btn_find)
    public void openPresenter(View view) {
        presenter.onStart();
    }

    @OnClick(R.id.bCrime)
    public void findTeamName(View view) {
        presenter.getNameTeam();
    }

    @OnClick(R.id.bPlayer)
    public void findPlayerName(View view) {
        presenter.getNamePlayer();
    }


    @OnClick(R.id.btn_third_act)
    public void openViewPagerActivity(View view) {
        Intent intent = new Intent(this, ListOfCriminalsOverYear.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_time_act1)
    public void openTimeActivity(View view) {
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    @Override
    public void setupWorstPlayer(String player) {
        tvPlayer.setText(player);
    }

    @Override
    public void setupWorstTeam(String team) {
        tvTeam.setText(team);
    }

    @Override
    public void setupWorstCrime(String crime) {
        tvCrime.setText(crime);
    }

    @Override
    public void openListActivityWithPlayer(String player) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_PLAYER_NAME, player);
        startActivity(intent);
    }

    @Override
    public void openListActivityWithTeams(String team) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_TEAM_NAME, team);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
