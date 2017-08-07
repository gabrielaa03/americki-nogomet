package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.base.RestInterface;
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
    private long lastResponseTime;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private RestInterface restInterface;

    @Inject
    public TeamInteractorImpl(RestInterface restInterface) {
        this.restInterface = restInterface;
    }

    @Override
    public void getAllTeams(final TeamListener listener1) {
        long currentTime = System.currentTimeMillis();
        long myTime = currentTime - lastResponseTime;
        List<FeedTeam> feedTeamRealmResponse = DatabaseHandle.getFeedTeam();

        if(myTime > 300000 || feedTeamRealmResponse==null ) {
            addObserver(getAllTeamsObservable().subscribeOn(Schedulers.io()).flatMap(new Function<List<FeedTeam>, ObservableSource<List<FeedTeam>>>() {
                @Override
                public ObservableSource<List<FeedTeam>> apply(@NonNull List<FeedTeam> feedTeams) throws Exception {
                    DatabaseHandle.saveFeedTeam(feedTeams);
                    return Observable.just(feedTeams);
                }
            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<FeedTeam>>() {
                        @Override
                        public void onNext(List<FeedTeam> feedTeams) {
                            listener1.onSuccess(feedTeams);
                            lastResponseTime = System.currentTimeMillis();
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
       }

    @Override
    public Observable<List<FeedTeam>> getAllTeamsObservable() {
        return restInterface.getTeam();
    }

}

