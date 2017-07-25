package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class CrimeInteractorImpl implements CrimeInteractor {
    private Call<List<FeedCrime>> callCrime, allCrimes, allPlayersCrimes;

    @Override
    public void getAllCrimes(final CrimeListener listener) {
        callCrime = RestUtils.getApi().getCrime();
        callCrime.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call2, Response<List<FeedCrime>> response) {
                List<FeedCrime> list = response.body();
                listener.onSuccess(list, 1);
            }

            @Override
            public void onFailure(Call<List<FeedCrime>> call2, Throwable t) {
                listener.onError();
            }
        });
    }



    @Override
    public void getPlayersCrimes(String playerName, final CrimeListener listener) {
        allPlayersCrimes= RestUtils.getApi().listOfCrimes(playerName);
        allPlayersCrimes.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call, Response<List<FeedCrime>> response) {
                List<FeedCrime> list = response.body();
                listener.onSuccess(list, 2);
            }
            @Override
            public void onFailure(Call<List<FeedCrime>> call, Throwable t) {
                listener.onError();
            }
        });
    }



    @Override
    public void stopCall() {
        if (callCrime != null) {
            callCrime.cancel();
        }
    }
}
