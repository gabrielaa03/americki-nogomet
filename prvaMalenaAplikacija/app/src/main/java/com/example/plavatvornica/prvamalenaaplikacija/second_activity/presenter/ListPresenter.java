package com.example.plavatvornica.prvamalenaaplikacija.second_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.RecAdapter;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.SecondInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class ListPresenter{

    Call<List<FeedCrime>> allCrimes, allPlayersCrimes;
    ArrayList<String> listOfCrimes;
    RecAdapter recAdapter;
    public void getInfo(String name, final SecondInterface listener) {
        //listener.getNameOfPlayerOrTeam();
    }


    public void sortCrimes(String name, final SecondInterface listener){
        allCrimes = RestUtils.getApi().getCrime();
        allCrimes.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call, Response<List<FeedCrime>> response) {
                List<FeedCrime> list = response.body();
                List<String> listOfAllCrimes = new ArrayList<String>();
                for(int i = 0; i< list.size(); i++) {
                   listOfAllCrimes.add(list.get(i).getCategory());
                }
                Collections.sort(listOfAllCrimes);
                List<String> list1 = new ArrayList<String>();
                for(int i =0; i < listOfAllCrimes.size(); i++){

                        if(listOfAllCrimes.size()>(i+1) && listOfAllCrimes.get(i+1) != null) {
                            if(i==0){
                                list1.add(0, listOfAllCrimes.get(i).substring(0, 1));
                                list1.add(listOfAllCrimes.get(i));
                            }
                            else if (listOfAllCrimes.get(i).substring(0, 1).equals(listOfAllCrimes.get(i + 1).substring(0, 1))) {
                                list1.add(listOfAllCrimes.get(i));
                            }else{
                                list1.add(listOfAllCrimes.get(i));
                                list1.add(listOfAllCrimes.get(i+1).substring(0, 1));



                            }
                        }
                }
                listener.sendOldList(listOfAllCrimes);
                listener.sendSortedCrimes(list1);
            }

            @Override
            public void onFailure(Call<List<FeedCrime>> call, Throwable t) {
                Log.d("TAG", "Ne valja sortiranje");
            }
        });
    }

    public void getPlayersCrimes(String playerName, final SecondInterface listener){
        allPlayersCrimes= RestUtils.getApi().listOfCrimes(playerName);
        allPlayersCrimes.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call, Response<List<FeedCrime>> response) {
                List<FeedCrime> list = response.body();
                listOfCrimes = new ArrayList<>();
                for(int i =0; i< list.size(); i++){
                    listOfCrimes.add(list.get(i).getCategory1());
                }
                listener.sendPlayersCrimes(listOfCrimes);
            }
            @Override
            public void onFailure(Call<List<FeedCrime>> call, Throwable t) {

            }
        });
    }



}
