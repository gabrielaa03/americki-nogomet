package com.example.plavatvornica.prvamalenaaplikacija.list_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.view.SecondActivity;

import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@PerActivity
@Subcomponent(modules = ListModule.class)
public interface ListComponent {
    void inject(SecondActivity secondActivity);
}
