package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.base.ServiceModule;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class CrimeInteractorImpl extends BaseInteractorImpl implements CrimeInteractor{

    RestInterface restInterface;

    @Inject
    public CrimeInteractorImpl(RestInterface restInterface) {
        this.restInterface = restInterface;

    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getAllCrimes(final CrimeListener listener) {

        compositeDisposable.add(getAllCrimesObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<FeedCrime>>() {
                    @Override
                    public void onNext(List<FeedCrime> feedCrimes) {
                        listener.onSuccess(feedCrimes, 1);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
    @Override
    public void getPlayersCrimes(String playerName, final CrimeListener listener) {

        compositeDisposable.add(getPlayersCrimesObservable(playerName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<FeedCrime>>() {
                    @Override
                    public void onNext(List<FeedCrime> feedCrimes) {
                        listener.onSuccess(feedCrimes, 2);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
    public Observable<List<FeedCrime>> getPlayersCrimesObservable(String playerName) {
        return restInterface.listOfCrimes(playerName);
    }
    public Observable<List<FeedCrime>> getAllCrimesObservable() {
        return restInterface.getCrime();
    }

}
