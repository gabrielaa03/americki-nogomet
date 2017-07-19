package com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.home_activity.HomeInterface;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

//obrađivanje podataka

public class HomePresenter {
    private static final String TAG = "";
    private String player, team;
    private Call<List<FeedPlayer>> callPlayer;
    private Call<List<FeedTeam>> callTeam;
    private Call<List<FeedCrime>> callCrime;

    public void getData(final HomeInterface listener) {
        callTeam = RestUtils.getApi().getTeam();
        callTeam.enqueue(new Callback<List<FeedTeam>>() {
            @Override
            public void onResponse(Call<List<FeedTeam>> call, Response<List<FeedTeam>> response) {
                int count = 0;
                int c;
                List<FeedTeam> list = response.body();
                team = "";
                for (int i = 0; i < list.size(); i++) {

                    c = Integer.parseInt(list.get(i).getArrestCount());
                    if (c > count) {
                        count = c;
                        team = list.get(i).getTeamPrefferedName();
                    }
                }

                listener.setupWorstTeam(team);
            }

            @Override
            public void onFailure(Call<List<FeedTeam>> call, Throwable t) {
                Log.d(TAG, "Ne valja tim");
            }
        });

        callPlayer = RestUtils.getApi().getPlayer();
        callPlayer.enqueue(new Callback<List<FeedPlayer>>() {
            @Override
            public void onResponse(Call<List<FeedPlayer>> call1, Response<List<FeedPlayer>> response) {
                int count = 0;
                int c;
                List<FeedPlayer> list = response.body();
                player = "";
                for (int i = 0; i < list.size(); i++) {
                    c = Integer.parseInt(list.get(i).getArrestCount());
                    if (c > count) {
                        count = c;
                        player = list.get(i).getName();
                    }

                }
                listener.setupWorstPlayer(player);
            }

            @Override
            public void onFailure(Call<List<FeedPlayer>> call1, Throwable t) {
                Log.d(TAG, "Ne valja plejer");
            }

        });

        callCrime = RestUtils.getApi().getCrime();
        callCrime.enqueue(new Callback<List<FeedCrime>>() {
            @Override
            public void onResponse(Call<List<FeedCrime>> call2, Response<List<FeedCrime>> response) {
                int count = 0;
                int c;
                List<FeedCrime> list = response.body();
                String crime = "";

                for (int i = 0; i < list.size(); i++) {
                    c = Integer.parseInt(list.get(i).getArrestCount());
                    if (c > count) {
                        count = c;
                        crime = list.get(i).getCategory();
                    }

                }
                listener.setupWorstCrime(crime);
            }

            @Override
            public void onFailure(Call<List<FeedCrime>> call2, Throwable t) {
                Log.d(TAG, "Ne valja kategorija");
            }
        });
    }

    // koristimo to u stop metodi kada zaustavimo da se provjera napravi
    public void stopCalls() {
        if (callCrime != null && callPlayer != null && callTeam != null) {
            callCrime.cancel();
            callPlayer.cancel();
            callTeam.cancel();
        }
    }

    public void getNamePlayer(final HomeInterface listener) {
        listener.openListActivity(player);

    }

    public void getNameTeam(final HomeInterface listener){
        listener.openSecondListActivity(team);
    }

}
