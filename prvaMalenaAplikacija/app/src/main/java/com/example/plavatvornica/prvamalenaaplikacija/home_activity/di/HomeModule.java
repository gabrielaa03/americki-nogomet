package com.example.plavatvornica.prvamalenaaplikacija.home_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.HomeContract;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter.HomePresenterImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.HomeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.HomeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractorImpl;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class HomeModule {

    private HomeContract.HomeActivityView view;

    public HomeModule(HomeContract.HomeActivityView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    HomeContract.HomeActivityView provideView() {
        return view;
    }

    @Provides
    @PerActivity
    HomeContract.HomeActivityPresenter providePresenter(HomePresenterImpl homePresenter) {
        return homePresenter;
    }

    @Provides
    @PerActivity
    HomeInteractor provideInteractor(HomeInteractorImpl interactor) {
        return interactor;
    }


    @Provides
    @PerActivity
    CrimeInteractor provideCrimeInteractor(CrimeInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    PlayerInteractor providePlayerInteractor(PlayerInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    TeamInteractor provideTeamInteractor(TeamInteractorImpl interactor) {
        return interactor;
    }
}
