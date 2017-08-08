package com.example.plavatvornica.prvamalenaaplikacija.model.interactors;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public class BaseInteractorImpl implements BaseInteractor {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeComp() {
        if (compositeDisposable != null)
            compositeDisposable.dispose();
    }

    public void addObserver(Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed())
            compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(disposable);
    }

}
