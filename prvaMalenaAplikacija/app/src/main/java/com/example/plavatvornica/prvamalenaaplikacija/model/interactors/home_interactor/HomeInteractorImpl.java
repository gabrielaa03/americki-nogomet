package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.HomeContainer;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.Listener.HomeListener;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractorImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function3;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 31.7.2017..
 */

public class HomeInteractorImpl extends BaseInteractorImpl implements HomeInteractor{

    private CrimeInteractor crimeInteractor;
    private PlayerInteractor playerInteractor;
    private TeamInteractor teamInteractor;

    @Inject
    public HomeInteractorImpl(CrimeInteractor crimeInteractor, PlayerInteractor playerInteractor, TeamInteractor teamInteractor) {
        this.crimeInteractor = crimeInteractor;
        this.playerInteractor = playerInteractor;
        this.teamInteractor = teamInteractor;
    }

    public void getAll(final HomeListener listener) {
        addObserver(Observable.zip(crimeInteractor.getAllCrimesObservable(), teamInteractor.getAllTeamsObservable(), playerInteractor.getAllPlayersObservable(), new Function3<List<FeedCrime>, List<FeedTeam>, List<FeedPlayer>, HomeContainer>() {
            @Override
            public HomeContainer apply(@NonNull List<FeedCrime> feedCrimes, @NonNull List<FeedTeam> feedTeams, @NonNull List<FeedPlayer> feedPlayers) throws Exception {
                return new HomeContainer(feedPlayers, feedCrimes, feedTeams);
            }}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<HomeContainer>() {
            @Override
            public void onNext(HomeContainer homeContainer) {
                listener.onSuccess(homeContainer);
            }

            @Override
            public void onError(Throwable e) {listener.onError();}

            @Override
            public void onComplete() {

            }
        }));
    }
}
