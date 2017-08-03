package com.example.plavatvornica.prvamalenaaplikacija.base;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

public interface RestInterface {

    @GET("team")
    Observable<List<FeedTeam>> getTeam();

    @GET("player")
    Observable<List<FeedPlayer>> getPlayer();

    @GET("crime")
    Observable<List<FeedCrime>> getCrime();

    @GET("player/topCrimes/{name}")
    Observable<List<FeedCrime>> listOfCrimes(@Path("name") String name);

    @GET("player")
    Observable<List<FeedPlayer>> listOfCrimesOverYear(@Query("start_date") String start_date, @Query("end_date") String end_date);


}
