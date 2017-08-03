package com.example.plavatvornica.prvamalenaaplikacija.third_activity.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.ThirdActivity;

import dagger.Subcomponent;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@PerActivity
@Subcomponent(modules = PagesModule.class)
public interface PagerComponent {

    void inject(ThirdActivity thirdActivity);
}
