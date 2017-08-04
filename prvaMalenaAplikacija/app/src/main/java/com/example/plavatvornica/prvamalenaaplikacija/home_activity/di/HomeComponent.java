package com.example.plavatvornica.prvamalenaaplikacija.home_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.view.MainActivity;
import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@PerActivity
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {

    void inject(MainActivity mainActivity);

}
