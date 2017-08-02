package com.example.plavatvornica.prvamalenaaplikacija.di.components;

import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Plava tvornica on 2.8.2017..
 */

@Singleton
@Component(modules = RestUtils.class)
public interface ApplicationComponent {

    Retrofit retrofit();
}
