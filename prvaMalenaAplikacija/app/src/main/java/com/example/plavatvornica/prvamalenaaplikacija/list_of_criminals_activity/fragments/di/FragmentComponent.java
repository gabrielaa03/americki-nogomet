package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_activity.view.SecondActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.view.MyFirstFragment;

import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 11.8.2017..
 */

@PerActivity
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(MyFirstFragment firstFragment);
}
