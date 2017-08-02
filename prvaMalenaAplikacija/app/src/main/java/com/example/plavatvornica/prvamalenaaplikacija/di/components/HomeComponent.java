package com.example.plavatvornica.prvamalenaaplikacija.di.components;

import com.example.plavatvornica.prvamalenaaplikacija.di.modules.HomeModule;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.view.MainActivity;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Plava tvornica on 2.8.2017..
 */
@Component(modules = HomeModule.class, dependencies = ApplicationComponent.class)
public interface HomeComponent {
   void inject (MainActivity mainActivity);
}
