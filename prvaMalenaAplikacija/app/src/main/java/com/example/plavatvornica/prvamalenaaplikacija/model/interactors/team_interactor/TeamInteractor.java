package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface TeamInteractor extends BaseInteractor {

    void getAllTeams(TeamListener listener);
    Observable<List<FeedTeam>> getAllTeamsObservable();





}
