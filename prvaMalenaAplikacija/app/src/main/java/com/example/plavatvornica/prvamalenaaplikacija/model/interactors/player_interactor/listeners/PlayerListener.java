package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrimesOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;

import java.util.List;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface PlayerListener {

    void onSuccess1(String start, String end, final int pagePosition, List<FeedCrimesOverYear> list);

    void onSuccess2(List<FeedPlayer> list);

    void onError();
}
