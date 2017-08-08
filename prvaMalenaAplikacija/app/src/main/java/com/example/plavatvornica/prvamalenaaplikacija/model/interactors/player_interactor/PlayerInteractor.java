package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface PlayerInteractor extends BaseInteractor {
    void getAllPlayers(PlayerListener listener);

    void getCrimesOverYear(String start, String end, final int pagePosition, PlayerListener listener);

    Observable<List<FeedPlayer>> getCrimesOverYearObservable(String start, String end);

    Observable<List<FeedPlayer>> getAllPlayersObservable();

}
