package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.base.SharedRepo;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.database.DatabaseHandle;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;

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

public class PlayerInteractorImpl extends BaseInteractorImpl implements PlayerInteractor {
    private RestInterface restInterface;
    private SharedRepo repo;
    @Inject
    public PlayerInteractorImpl(RestInterface restInterface, SharedRepo repo) {
        this.restInterface = restInterface;
        this.repo = repo;
    }

    @Override
    public void getAllPlayers(final PlayerListener listener) {
        long currentTime = System.currentTimeMillis();
        long readTime = repo.getSavedTimeAllPlayers();
        long myTime = currentTime - readTime;

        if (myTime < 300000) {
            listener.onSuccess2(DatabaseHandle.getFeedPlayer());
        } else {
            addObserver(getAllPlayersObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedPlayer>, ObservableSource<List<FeedPlayer>>>() {
                @Override
                public ObservableSource<List<FeedPlayer>> apply(@NonNull List<FeedPlayer> feedPlayers) throws Exception {
                    DatabaseHandle.saveFeedPlayer(feedPlayers);
                    repo.setSavedTimeAllPlayers(System.currentTimeMillis());
                    return Observable.just(feedPlayers);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedPlayer>>() {
                        @Override
                        public void onNext(List<FeedPlayer> feedPlayers) {
                            listener.onSuccess2(feedPlayers);
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
    public void getCrimesOverYear(final String start, final String end, final int pagePosition, final PlayerListener listener) {
        long currentTime = System.currentTimeMillis();
        long readTime = repo.getSavedTimeCrimesOverYear();
        long myTime = currentTime - readTime;

        if (myTime < 300000) {
            listener.onSuccess2(DatabaseHandle.getFeedCrimesOverYear());
        } else {
            addObserver(getCrimesOverYearObservable(start, end).subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedPlayer>, ObservableSource<List<FeedPlayer>>>() {
                @Override
                public ObservableSource<List<FeedPlayer>> apply(@NonNull List<FeedPlayer> feedPlayers) throws Exception {
                    DatabaseHandle.saveFeedCrimesOverYear(feedPlayers);
                    repo.setSavedTimeCrimesOverYear(System.currentTimeMillis());
                    return Observable.just(feedPlayers);
                }
            })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedPlayer>>() {
                        @Override
                        public void onNext(List<FeedPlayer> feedPlayers) {
                            listener.onSuccess1(start, end, pagePosition, feedPlayers);
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


    public Observable<List<FeedPlayer>> getCrimesOverYearObservable(String start, String end) {
        return restInterface.listOfCrimesOverYear(start, end);
    }

    public Observable<List<FeedPlayer>> getAllPlayersObservable() {
        return restInterface.getPlayer();
    }

}
