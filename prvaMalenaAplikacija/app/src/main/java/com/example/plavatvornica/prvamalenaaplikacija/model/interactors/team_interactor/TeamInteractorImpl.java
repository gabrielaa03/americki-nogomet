package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
import com.example.plavatvornica.prvamalenaaplikacija.base.SharedRepo;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.database.DatabaseHandle;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;
import com.example.plavatvornica.prvamalenaaplikacija.base.ServiceModule;

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

public class TeamInteractorImpl extends BaseInteractorImpl implements TeamInteractor {
    private RestInterface restInterface;
    private SharedRepo repo;

    @Inject
    public TeamInteractorImpl(RestInterface restInterface, SharedRepo repo) {
        this.restInterface = restInterface;
        this.repo = repo;
    }

    @Override
    public void getAllTeams(final TeamListener listener) {
        long currentTime = System.currentTimeMillis();
        long readTime = repo.getSavedTimeAllTeams();
        long myTime = currentTime - readTime;

        if (myTime < 300000) {
            listener.onSuccess(DatabaseHandle.getFeedTeam());
        } else {
            addObserver(getAllTeamsObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedTeam>, ObservableSource<List<FeedTeam>>>() {
                @Override
                public ObservableSource<List<FeedTeam>> apply(@NonNull List<FeedTeam> feedTeams) throws Exception {
                    DatabaseHandle.saveFeedTeam(feedTeams);
                    repo.setSavedTimeAllTeams(System.currentTimeMillis());
                    return Observable.just(feedTeams);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedTeam>>() {
                        @Override
                        public void onNext(List<FeedTeam> feedTeams) {
                            listener.onSuccess(feedTeams);

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
    public Observable<List<FeedTeam>> getAllTeamsObservable() {
        return restInterface.getTeam();
    }

}

