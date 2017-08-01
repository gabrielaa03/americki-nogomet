package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class TeamInteractorImpl extends BaseInteractorImpl implements TeamInteractor {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void getAllTeams(final TeamListener listener1) {

        compositeDisposable.add(getAllTeamsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<FeedTeam>>() {
                    @Override
                    public void onNext(List<FeedTeam> feedTeams) {
                        listener1.onSuccess(feedTeams);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener1.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
       }


    @Override
    public Observable<List<FeedTeam>> getAllTeamsObservable() {
        return RestUtils.getApi().getTeam();
    }

}

