package com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso.presenter;

import com.example.plavatvornica.prvamalenaaplikacija.model_test.interactors.test_interactor.TestInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model_test.interactors.test_interactor.TestInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model_test.interactors.test_interactor.listeners.TestListener;
import com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso.TestContract;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class TestPresenterImpl implements TestContract.Presenter, TestListener {

    private TestContract.View view;
    private TestInteractor interactor;

    public TestPresenterImpl(TestContract.View view) {
        this.view = view;
        interactor = new TestInteractorImpl();
    }

    @Override
    public void onStart() {
        interactor.getData(this);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSuccess(String string) {

    }

    @Override
    public void onError(String error) {

    }
}
