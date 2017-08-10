package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.ListOfCriminalsContract;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.presenter.ListOfCriminalsOverYearImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class PagesModule {
    private ListOfCriminalsContract.ThirdView view;

    public PagesModule(ListOfCriminalsContract.ThirdView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    ListOfCriminalsContract.ThirdView provideView() {
        return view;
    }

    @Provides
    @PerActivity
    ListOfCriminalsContract.ThirdPresenter providePresenter(ListOfCriminalsOverYearImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    PlayerInteractor provideInteractor(PlayerInteractorImpl interactor) {
        return interactor;
    }
}
