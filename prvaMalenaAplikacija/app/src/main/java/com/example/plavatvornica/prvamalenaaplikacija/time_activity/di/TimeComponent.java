package com.example.plavatvornica.prvamalenaaplikacija.time_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.view.TimeActivity;

import java.sql.Time;

import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 3.8.2017..
 */

@PerActivity
@Subcomponent(modules = TimeModule.class)
public interface TimeComponent {
    void inject(TimeActivity timeActivity);
}
