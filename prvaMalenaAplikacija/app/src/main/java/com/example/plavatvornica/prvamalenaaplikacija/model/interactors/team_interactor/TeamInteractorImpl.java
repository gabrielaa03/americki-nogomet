package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;
import com.example.plavatvornica.prvamalenaaplikacija.model_test.interactors.test_interactor.listeners.TestListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public class TeamInteractorImpl implements TeamInteractor {
    private Call<List<FeedTeam>> callTeam;

    @Override
    public void getAllTeams(final TeamListener listener1) {

           callTeam = RestUtils.getApi().getTeam();
           callTeam.enqueue(new Callback<List<FeedTeam>>() {
               @Override
               public void onResponse(Call<List<FeedTeam>> call, Response<List<FeedTeam>> response) {

                   List<FeedTeam> list = response.body();
                   listener1.onSuccess(list);
               }

               @Override
               public void onFailure(Call<List<FeedTeam>> call, Throwable t) {
                   listener1.onError();
               }
           });

       }

    @Override
    public void stopCall() {
        if (callTeam != null) {
            callTeam.cancel();
        }
    }
}

