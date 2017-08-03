package com.example.plavatvornica.prvamalenaaplikacija.third_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.ThirdActivityContract;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter.ThirdPresenterImpl;

import dagger.Module;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class PagesModule {
    private ThirdActivityContract.ThirdView view;

    public PagesModule(ThirdActivityContract.ThirdView view) {
        this.view = view;
    }

    ThirdActivityContract.ThirdView provideView(){return view;}


    ThirdActivityContract.ThirdPresenter providePresenter(ThirdPresenterImpl presenter){
        return presenter;
    }

    PlayerInteractor provideInteractor(PlayerInteractorImpl interactor){return interactor;}



}
