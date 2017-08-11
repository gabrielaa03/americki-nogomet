package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.di;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.FragmentContract;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.adapter.RecyclerAdapterFragment;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.presenter.FragmentPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Plava tvornica on 11.8.2017..
 */
@Module
public class FragmentModule {

    FragmentContract.FragmentView view;

    public FragmentModule(FragmentContract.FragmentView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    FragmentContract.FragmentView provideView() {
        return view;
    }

    @Provides
    @PerActivity
    FragmentContract.FragmentPresenter providesPresenter(FragmentPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RecyclerAdapterFragment providesAdapter() {
        return new RecyclerAdapterFragment();
    }
}
