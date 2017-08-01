package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class PlayerInteractorImpl extends BaseInteractorImpl implements PlayerInteractor {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void getAllPlayers(final PlayerListener listener) {

        compositeDisposable.add(getAllPlayersObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
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

    @Override
    public void getCrimesOverYear(final String start, final String end, final int pagePosition, final PlayerListener listener) {


        compositeDisposable.add(getCrimesOverYearObservable(start, end).subscribeOn(Schedulers.io())
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


    public Observable<List<FeedPlayer>> getCrimesOverYearObservable(String start, String end) {
        return RestUtils.getApi().listOfCrimesOverYear(start, end);
    }

    public Observable<List<FeedPlayer>> getAllPlayersObservable() {
        return RestUtils.getApi().getPlayer();
    }

}
