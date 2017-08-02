package com.example.plavatvornica.prvamalenaaplikacija.rest_utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Plava tvornica on 17.7.2017..
 */
@Module
public class RestUtils {
    private String URL = "http://nflarrest.com/api/v1/";

    public RestUtils(String URL) {
        this.URL = URL;
    }

    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory, RxJava2CallAdapterFactory adapterFactory)
            {
                return new Retrofit.Builder()
                        .baseUrl(URL)
                        .client(client)
                        .addConverterFactory(converterFactory)
                        .addCallAdapterFactory(adapterFactory)
                        .build();

    }
}
