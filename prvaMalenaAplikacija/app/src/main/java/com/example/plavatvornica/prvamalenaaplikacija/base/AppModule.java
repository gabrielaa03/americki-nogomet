package com.example.plavatvornica.prvamalenaaplikacija.base;

import dagger.Module;

/**
 * Created by Plava tvornica on 3.8.2017..
 */
@Module
public class AppModule {

    private MyApplication app;

    public AppModule(MyApplication app) {
        this.app = app;
    }
}
