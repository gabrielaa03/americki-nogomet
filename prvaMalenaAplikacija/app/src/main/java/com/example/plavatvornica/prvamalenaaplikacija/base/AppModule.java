package com.example.plavatvornica.prvamalenaaplikacija.base;

import com.example.plavatvornica.prvamalenaaplikacija.base.scope.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class AppModule {

    private MyApplication app;

    public AppModule(MyApplication app) {
        this.app = app;
    }

    @Singleton
    @Provides
    SharedRepo provideSharedRepo() {
        return new SharedRepo(app);
    }



}
