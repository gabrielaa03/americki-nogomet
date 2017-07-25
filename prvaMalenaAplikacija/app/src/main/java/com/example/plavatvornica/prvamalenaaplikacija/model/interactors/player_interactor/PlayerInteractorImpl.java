package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class PlayerInteractorImpl implements PlayerInteractor {
    private Call<List<FeedPlayer>> callPlayer, feedCrimeOverYear;

    @Override
    public void getAllPlayers(final PlayerListener listener) {
        callPlayer = RestUtils.getApi().getPlayer();
        callPlayer.enqueue(new Callback<List<FeedPlayer>>() {
            @Override
            public void onResponse(Call<List<FeedPlayer>> call1, Response<List<FeedPlayer>> response) {
                List<FeedPlayer> list = response.body();
                listener.onSuccess2(list);
            }

            @Override
            public void onFailure(Call<List<FeedPlayer>> call1, Throwable t) {
                listener.onError();
            }
        });
    }

    @Override
    public void getCrimesOverYear(final String start, final String end, final int pagePosition, final PlayerListener listener) {
        feedCrimeOverYear= RestUtils.getApi().listOfCrimesOverYear(start,end);
        feedCrimeOverYear.enqueue(new Callback<List<FeedPlayer>>() {
            @Override
            public void onResponse(Call<List<FeedPlayer>> call, Response<List<FeedPlayer>> response) {
                List<FeedPlayer> list = response.body();
                listener.onSuccess1(start , end, pagePosition, list);
            }

            @Override
            public void onFailure(Call<List<FeedPlayer>> call, Throwable t) {
                listener.onError();
            }

        });
    }

    @Override
    public void stopCall() {
        if (callPlayer != null) {
            callPlayer.cancel();
        }
    }
}
