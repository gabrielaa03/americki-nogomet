package com.example.plavatvornica.prvamalenaaplikacija.time_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.TimeContract;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.presenter.TimePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class TimeModule {

    private TimeContract.TimeView view;

    public TimeModule(TimeContract.TimeView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    TimeContract.TimeView provideView(){return view;}
    @Provides
    @PerActivity
    TimeContract.TimePresenter presenter(TimePresenterImpl presenter){return presenter;}
}
