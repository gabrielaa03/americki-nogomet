package com.example.plavatvornica.prvamalenaaplikacija.base;

import android.app.Application;

/**
 * Created by Plava tvornica on 3.8.2017..
 */

public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


}
