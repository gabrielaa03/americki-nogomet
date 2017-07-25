package com.example.plavatvornica.prvamalenaaplikacija.rest_utils;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

public interface API {

    @GET("team")
    Call<List<FeedTeam>> getTeam();

    @GET("player")
    Call<List<FeedPlayer>> getPlayer();

    @GET("crime")
    Call<List<FeedCrime>> getCrime();

    @GET("player/topCrimes/{name}")
    Call<List<FeedCrime>> listOfCrimes(@Path("name") String name);

    @GET("player")
    Call<List<FeedPlayer>> listOfCrimesOverYear(@Query("start_date") String start_date, @Query("end_date") String end_date);


}
