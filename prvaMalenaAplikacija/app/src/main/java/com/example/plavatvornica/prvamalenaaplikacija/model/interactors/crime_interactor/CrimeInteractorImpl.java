package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class CrimeInteractorImpl extends BaseInteractorImpl implements CrimeInteractor {


    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void getAllCrimes(final CrimeListener listener) {

        Observable<List<FeedCrime>> crime = RestUtils.getApi().getCrime();
        compositeDisposable.add(crime.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
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

        Observable<List<FeedCrime>> allPlayersCrimes = RestUtils.getApi().listOfCrimes(playerName);
        compositeDisposable.add(allPlayersCrimes.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
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


}
