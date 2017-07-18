package com.example.plavatvornica.prvamalenaaplikacija.rest_utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

public class RestUtils {
    private static final String URL = "http://nflarrest.com/api/v1/";

    private static API api;

    public static API getApi() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(API.class);
        }
        return api;
    }
}
