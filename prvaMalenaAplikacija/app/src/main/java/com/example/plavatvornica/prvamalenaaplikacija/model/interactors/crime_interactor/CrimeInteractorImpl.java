package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.base.SharedRepo;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.WrapperFeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.database.DatabaseHandle;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class CrimeInteractorImpl extends BaseInteractorImpl implements CrimeInteractor {

    private RestInterface restInterface;
    private SharedRepo repo;

    @Inject
    public CrimeInteractorImpl(RestInterface restInterface, SharedRepo repo) {
        this.restInterface = restInterface;
        this.repo = repo;
    }

    @Override
    public void getAllCrimes(final CrimeListener listener) {
        long currentTime = System.currentTimeMillis();
        long readTime = repo.getSavedTimeAllCrimes();
        long myTime = currentTime - readTime;

        if (myTime < 300000) {
            listener.onSuccess(DatabaseHandle.getFeedCrime(),1);
        } else {
            addObserver(getAllCrimesObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedCrime>, ObservableSource<List<FeedCrime>>>() {
                @Override
                public ObservableSource<List<FeedCrime>> apply(@NonNull List<FeedCrime> feedCrimes) throws Exception {
                    DatabaseHandle.saveFeedCrimes(feedCrimes);
                    repo.setSavedTimeAllCrimes(System.currentTimeMillis());
                    return Observable.just(feedCrimes);
                }
            }).observeOn(AndroidSchedulers.mainThread())
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
    }

    @Override
    public void getPlayersCrimes(String playerName, final CrimeListener listener) {
        long currentTime = System.currentTimeMillis();
        long readTime = repo.getSavedTimePlayersCrimes();
        long myTime = currentTime - readTime;

        if (myTime < 300000) {
            listener.onSuccess(DatabaseHandle.getFeedPlayersCrimes(), 2);
        } else {
            addObserver(getPlayersCrimesObservable(playerName).subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedCrime>, ObservableSource<List<FeedCrime>>>() {
                @Override
                public ObservableSource<List<FeedCrime>> apply(@NonNull List<FeedCrime> feedCrimes) throws Exception {
                    List<WrapperFeedCrime> list = new ArrayList<>();
                    for(FeedCrime feedCrime : feedCrimes){
                        list.add(new WrapperFeedCrime(feedCrime));
                    }
                    DatabaseHandle.saveFeedPlayersCrimes(list);
                    repo.setSavedTimePlayersCrimes(System.currentTimeMillis());
                    return Observable.just(feedCrimes);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedCrime>>() {
                        @Override
                        public void onNext(List<FeedCrime> feedCrimes) {
                            listener.onSuccess(feedCrimes, 2); }

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
    public Observable<List<FeedCrime>> getPlayersCrimesObservable(String playerName) {
        return restInterface.listOfCrimes(playerName);
    }
    public Observable<List<FeedCrime>> getAllCrimesObservable() {
        return restInterface.getCrime();
    }
}
