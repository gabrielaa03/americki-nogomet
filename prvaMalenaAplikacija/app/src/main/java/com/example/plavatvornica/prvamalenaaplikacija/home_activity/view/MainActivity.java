package com.example.plavatvornica.prvamalenaaplikacija.home_activity.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter.HomePresenter;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.view.SecondActivity;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.ThirdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HomeInterface{


    @BindView (R.id.button) Button button;
    @BindView (R.id.tv_worst_crime_value) TextView tvCrime;
    @BindView (R.id.tv_worst_player_value) TextView tvPlayer;
    @BindView (R.id.tv_worst_team_value) TextView tvTeam;



    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ButterKnife.bind(this);
        button.setOnClickListener(this);
        presenter = new HomePresenter();

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopCalls();
    }

    @OnClick(R.id.bCrime)
    public void openActivity(View view) {
       presenter.getNameTeam(this);
    }

    @OnClick(R.id.bPlayer)
    public void openActivity1(View view) {
       presenter.getNamePlayer(this);
    }


    @OnClick(R.id.btn_third_act)
    public void openActivity2(View view){

        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v){
        presenter.getData(this);
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


}
