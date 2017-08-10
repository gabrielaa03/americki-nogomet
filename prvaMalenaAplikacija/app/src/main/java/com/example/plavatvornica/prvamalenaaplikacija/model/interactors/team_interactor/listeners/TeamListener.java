package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;

import java.util.List;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface TeamListener {

    void onSuccess(List<FeedTeam> list);

    void onError();
}
