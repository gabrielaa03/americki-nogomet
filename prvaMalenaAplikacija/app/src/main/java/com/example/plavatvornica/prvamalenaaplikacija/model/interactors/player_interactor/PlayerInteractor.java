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

public interface PlayerInteractor {
        void getAllPlayers(PlayerListener listener);
        void getCrimesOverYear(String start, String end, final int pagePosition, PlayerListener listener);
        void stopCall();
}
