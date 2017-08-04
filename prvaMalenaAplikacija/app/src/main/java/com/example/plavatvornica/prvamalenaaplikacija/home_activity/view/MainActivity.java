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
import com.example.plavatvornica.prvamalenaaplikacija.model.database.DatabaseHandle;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.view.SecondActivity;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.ThirdActivity;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.view.TimeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements HomeContract.HomeActivityView{
    @BindView(R.id.tv_worst_crime_value) TextView tvCrime;
    @BindView (R.id.tv_worst_player_value) TextView tvPlayer;
    @BindView (R.id.tv_worst_team_value) TextView tvTeam;
    DatabaseHandle databaseHandle;
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
    public void openP(View view) {
        presenter.onStart();
    }

    @OnClick(R.id.bCrime)
    public void openActivity(View view) {
       presenter.getNameTeam();
    }

    @OnClick(R.id.bPlayer)
    public void openActivity1(View view) {
       presenter.getNamePlayer();
    }


    @OnClick(R.id.btn_third_act)
    public void openActivity2(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_time_act1)
    public void openTimeActivity(View view){
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

//imolemenatcija funkcije u interface-u
    @Override
    public void setupWorstCrime(String crime) {
        tvCrime.setText(crime);
    }

    @Override
    public void openListActivity(String player) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_PLAYER_NAME, player);
        startActivity(intent);
    }

    @Override
    public void openSecondListActivity(String team) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_TEAM_NAME, team);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHandle.destroyRealm();
    }
}
