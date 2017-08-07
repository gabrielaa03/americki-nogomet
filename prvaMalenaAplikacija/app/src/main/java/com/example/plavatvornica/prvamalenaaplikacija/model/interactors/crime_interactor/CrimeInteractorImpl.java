package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.database.DatabaseHandle;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.base.ServiceModule;

import java.util.List;

import javax.inject.Inject;

import dagger.Component;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class CrimeInteractorImpl extends BaseInteractorImpl implements CrimeInteractor{

    private RestInterface restInterface;
    private long lastResponseTime;
    @Inject
    public CrimeInteractorImpl(RestInterface restInterface) {
        this.restInterface = restInterface;
    }

    @Override
    public void getAllCrimes(final CrimeListener listener) {
      long currentTime = System.currentTimeMillis();
      long myTime = currentTime-lastResponseTime;
      List<FeedCrime> feedCrimeRealmResponse = DatabaseHandle.getFeedCrime();

     // if(myTime > 300000 || feedCrimeRealmResponse.size()==0) {
          addObserver(getAllCrimesObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedCrime>, ObservableSource<List<FeedCrime>>>() {
              @Override
              public ObservableSource<List<FeedCrime>> apply(@NonNull List<FeedCrime> feedCrimes) throws Exception {
                  DatabaseHandle.saveFeedCrimes(feedCrimes);
                  return Observable.just(feedCrimes);
              }
          }).observeOn(AndroidSchedulers.mainThread())
                  .subscribeWith(new DisposableObserver<List<FeedCrime>>() {
                      @Override
                      public void onNext(List<FeedCrime> feedCrimes) {
                          listener.onSuccess(feedCrimes, 1);
                          Log.d("success", "novi podaci");
                      }

                      @Override
                      public void onError(Throwable e) {
                          listener.onError();
                      }

                      @Override
                      public void onComplete() {}
                  }));
     //  }
        lastResponseTime = System.currentTimeMillis();
    }

    @Override
    public void getPlayersCrimes(String playerName, final CrimeListener listener) {
        long currentTime = System.currentTimeMillis();
        long myTime = currentTime-lastResponseTime;
        List<FeedCrime> feedCrimeRealmResponse = DatabaseHandle.getFeedCrime();

        if(myTime > 300000 || feedCrimeRealmResponse == null ) {
            addObserver(getPlayersCrimesObservable(playerName).subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedCrime>, ObservableSource<List<FeedCrime>>>() {
                @Override
                public ObservableSource<List<FeedCrime>> apply(@NonNull List<FeedCrime> feedCrimes) throws Exception {
                    DatabaseHandle.saveFeedCrimes(feedCrimes);
                    return Observable.just(feedCrimes);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedCrime>>() {
                        @Override
                        public void onNext(List<FeedCrime> feedCrimes) { listener.onSuccess(feedCrimes, 2); }

                        @Override
                        public void onError(Throwable e) {
                            listener.onError();
                        }

                        @Override
                        public void onComplete() {

                        }
                    }));
        }

        lastResponseTime = System.currentTimeMillis();
    }
    public Observable<List<FeedCrime>> getPlayersCrimesObservable(String playerName) {return restInterface.listOfCrimes(playerName);}
    public Observable<List<FeedCrime>> getAllCrimesObservable() { return restInterface.getCrime(); }
}
