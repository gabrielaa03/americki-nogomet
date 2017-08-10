package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.view.ListOfCriminalsOverYear;

import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@PerActivity
@Subcomponent(modules = PagesModule.class)
public interface PagerComponent {

    void inject(ListOfCriminalsOverYear listOfCriminalsOverYear);
}
