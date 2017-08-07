package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class PlayerInteractorImpl extends BaseInteractorImpl implements PlayerInteractor {
    private long lastResponseTime, lastResponseTime2;
    private RestInterface restInterface;
    @Inject
    public PlayerInteractorImpl(RestInterface restInterface) {
        this.restInterface = restInterface;
    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void getAllPlayers(final PlayerListener listener) {
        long currentTime = System.currentTimeMillis();
        long myTime = currentTime - lastResponseTime;
        List<FeedPlayer> feedPlayerRealmResponse = DatabaseHandle.getFeedPlayer();

        if(myTime > 300000 || feedPlayerRealmResponse==null ) {
            addObserver(getAllPlayersObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedPlayer>, ObservableSource<List<FeedPlayer>>>() {
            @Override
            public ObservableSource<List<FeedPlayer>> apply(@NonNull List<FeedPlayer> feedPlayers) throws Exception {
                DatabaseHandle.saveFeedPlayer(feedPlayers);
                lastResponseTime = System.currentTimeMillis();
                return Observable.just(feedPlayers);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<FeedPlayer>>() {
                    @Override
                    public void onNext(List<FeedPlayer> feedPlayers) { listener.onSuccess2(feedPlayers); }

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
        long myTime = currentTime - lastResponseTime2;
        List<FeedPlayer> feedPlayerRealmResponse = DatabaseHandle.getFeedPlayer();

        if(myTime > 300000  || feedPlayerRealmResponse ==null ) {
            addObserver(getCrimesOverYearObservable(start, end).subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedPlayer>, ObservableSource<List<FeedPlayer>>>() {
                @Override
                public ObservableSource<List<FeedPlayer>> apply(@NonNull List<FeedPlayer> feedPlayers) throws Exception {
                    DatabaseHandle.saveFeedPlayer(feedPlayers);
                    return Observable.just(feedPlayers);
                }
            })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedPlayer>>() {
                        @Override
                        public void onNext(List<FeedPlayer> feedPlayers) {
                            listener.onSuccess1(start, end, pagePosition, feedPlayers);
                            lastResponseTime2 = System.currentTimeMillis();
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
