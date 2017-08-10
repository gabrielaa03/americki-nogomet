package com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.home_activity.HomeContract;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.HomeContainer;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.HomeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.Listener.HomeListener;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

//obrađivanje podataka

public class HomePresenterImpl implements HomeContract.HomeActivityPresenter, HomeListener {

    private HomeContract.HomeActivityView view;
    private HomeInteractor homeInteractor;
    private String player, team, crime;

    @Inject
    public HomePresenterImpl(HomeContract.HomeActivityView view, HomeInteractor homeInteractor) {
        this.view = view;
        this.homeInteractor = homeInteractor;
    }

    @Override
    public void onStart() {
        homeInteractor.getAll(this);
    }

    @Override
    public void onStop() {
        homeInteractor.disposeComp();
    }

    @Override
    public void getNamePlayer() {
        view.openListActivityWithPlayer(player);
    }

    @Override
    public void getNameTeam() {
        view.openListActivityWithTeams(team);
    }

    @Override
    public void onSuccess(HomeContainer homeContainer) {
        List<FeedCrime> listCrime = homeContainer.getCrime();
        List<FeedTeam> listTeam = homeContainer.getTeam();
        List<FeedPlayer> listPlayer = homeContainer.getPlayer();

        int count = 0;
        int c;
        team = "";
        for (int i = 0; i < listTeam.size(); i++) {

            c = Integer.parseInt(listTeam.get(i).getArrestCount());
            if (c > count) {
                count = c;
                team = listTeam.get(i).getTeamPrefferedName();
            }
        }
        view.setupWorstTeam(team);

        int count1 = 0;
        int c1;
        crime = "";

        for (int i = 0; i < listCrime.size(); i++) {
            c1 = Integer.parseInt(listCrime.get(i).getArrestCount());
            if (c1 > count1) {
                count1 = c1;
                crime = listCrime.get(i).getCategory();
            }
        }

        view.setupWorstCrime(crime);

        int count2 = 0;
        int c2;
        player = "";
        for (int i = 0; i < listPlayer.size(); i++) {
            c2 = Integer.parseInt(listPlayer.get(i).getArrestCount());
            if (c2 > count2) {
                count2 = c2;
                player = listPlayer.get(i).getName();
            }
        }
        view.setupWorstPlayer(player);
    }

    @Override
    public void onError() {
        Log.d("error", "error");
    }
}
