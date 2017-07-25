package com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso.TestContract;
import com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso.presenter.TestPresenterImpl;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class TestActivity extends AppCompatActivity implements TestContract.View {

    private TestContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new TestPresenterImpl(this);
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
}
