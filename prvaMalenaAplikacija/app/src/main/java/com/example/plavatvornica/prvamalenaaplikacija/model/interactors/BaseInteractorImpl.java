package com.example.plavatvornica.prvamalenaaplikacija.model.interactors;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public class BaseInteractorImpl implements BaseInteractor{

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeComp() {
        if (compositeDisposable != null || compositeDisposable.isDisposed() ) {
            compositeDisposable = new CompositeDisposable();

        }else{
            compositeDisposable.dispose();
        }
    }

}
