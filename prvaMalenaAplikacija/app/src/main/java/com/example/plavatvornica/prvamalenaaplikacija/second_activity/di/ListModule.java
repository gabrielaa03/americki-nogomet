package com.example.plavatvornica.prvamalenaaplikacija.second_activity.di;

import android.content.SharedPreferences;

import com.example.plavatvornica.prvamalenaaplikacija.base.SharedRepo;
import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.HomeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.SecondActivityContract;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.presenter.ListPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Plava tvornica on 3.8.2017..
 */

@Module
public class ListModule {

    SecondActivityContract.SecondActivityView view;

    public ListModule(SecondActivityContract.SecondActivityView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    SecondActivityContract.SecondActivityView provideView() {
        return view;
    }

    @Provides
    @PerActivity
    SecondActivityContract.ListPresenter providesPresenter(ListPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CrimeInteractor providesInteractor(CrimeInteractorImpl crimeInteractor) {
        return crimeInteractor;
    }

}
