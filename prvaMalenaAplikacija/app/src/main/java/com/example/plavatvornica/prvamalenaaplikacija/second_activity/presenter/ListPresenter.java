package com.example.plavatvornica.prvamalenaaplikacija.second_activity.presenter;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.SecondInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class ListPresenter{

    Call<List<FeedCrime>> allCrimes;
    public void getInfo(String name, final SecondInterface listener) {
        //listener.getNameOfPlayerOrTeam();

    }
    public void sortCrimes(String name, String lastname, final SecondInterface listener){
        allCrimes = RestUtils.getApi().listOfCrimes(name, lastname);
        allCrimes.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call, Response<List<FeedCrime>> response) {
                List<FeedCrime> list = response.body();
                for(FeedCrime feedCrime : list){

                }
            }

            @Override
            public void onFailure(Call<List<FeedCrime>> call, Throwable t) {

            }
        });

    }



}
