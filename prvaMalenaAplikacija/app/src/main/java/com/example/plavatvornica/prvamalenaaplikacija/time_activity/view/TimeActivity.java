package com.example.plavatvornica.prvamalenaaplikacija.time_activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.base.MyApplication;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.TimeContract;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.di.TimeModule;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.presenter.TimePresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeActivity extends AppCompatActivity implements TimeContract.TimeView{

    @BindView(R.id.tv_time)
    TextView tv;
    @Inject
    TimeContract.TimePresenter presenter;
    String newTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        MyApplication.appComponent.plus(new TimeModule(this)).inject(this);
        presenter = new TimePresenterImpl(this);
        ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void sendTimeData(String time) {
        newTime = time;
        tv.setText(newTime);
    }
}
