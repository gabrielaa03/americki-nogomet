package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;
import com.example.plavatvornica.prvamalenaaplikacija.model_test.interactors.test_interactor.listeners.TestListener;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface TeamInteractor {

    void getAllTeams(TeamListener listener);
    void stopCall();




}
