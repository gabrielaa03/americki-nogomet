package com.example.plavatvornica.prvamalenaaplikacija.base;

import com.example.plavatvornica.prvamalenaaplikacija.home_activity.di.HomeComponent;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.di.HomeModule;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.di.ListComponent;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.di.ListModule;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.di.PagerComponent;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.di.PagesModule;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.di.FragmentComponent;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.di.FragmentModule;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.di.TimeComponent;
import com.example.plavatvornica.prvamalenaaplikacija.time_activity.di.TimeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Plava tvornica on 2.8.2017..
 */

@Singleton
@Component(modules = {ServiceModule.class, AppModule.class})
public interface AppComponent {
    HomeComponent plus(HomeModule homeModule);

    ListComponent plus(ListModule listModule);

    PagerComponent plus(PagesModule pagesModule);

    TimeComponent plus(TimeModule timeModule);

    FragmentComponent plus(FragmentModule fragmentModule);
}
