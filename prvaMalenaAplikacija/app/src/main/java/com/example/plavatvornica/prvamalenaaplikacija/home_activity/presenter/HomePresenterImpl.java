package com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.home_activity.HomeContract;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.TeamInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.team_interactor.listeners.TeamListener;

import java.util.List;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

//obrađivanje podataka

public class HomePresenterImpl implements HomeContract.HomeActivityPresenter,CrimeListener,TeamListener,PlayerListener{

    private HomeContract.HomeActivityView view;
    private CrimeInteractor crimeInteractor;
    private TeamInteractor teamInteractor;
    private PlayerInteractor playerInteractor;
    private String player, team, crime;


    public HomePresenterImpl(HomeContract.HomeActivityView view) {
        this.view = view;
        crimeInteractor = new CrimeInteractorImpl();
        playerInteractor = new PlayerInteractorImpl();
        teamInteractor = new TeamInteractorImpl();
    }

    @Override
    public void onStart() {
        crimeInteractor.getAllCrimes(this);
        playerInteractor.getAllPlayers(this);
        teamInteractor.getAllTeams(this);
    }

    @Override
    public void onStop() {
        // koristimo to u stop metodi kada zaustavimo da se provjera napravi
        crimeInteractor.stopCall();
        playerInteractor.stopCall();
        teamInteractor.stopCall();
    }

    @Override
    public void onSuccess(List<FeedTeam> list) {
        int count = 0;
        int c;
        team = "";
        for (int i = 0; i < list.size(); i++) {

            c = Integer.parseInt(list.get(i).getArrestCount());
            if (c > count) {
                count = c;
                team = list.get(i).getTeamPrefferedName();
            }
        }

        view.setupWorstTeam(team);
        // listener.setupWorstTeam(team);

    }

    @Override
    public void onSuccess(List<FeedCrime> list, int type) {
        if (type == 1) {
            int count = 0;
            int c;
            crime = "";

            for (int i = 0; i < list.size(); i++) {
                c = Integer.parseInt(list.get(i).getArrestCount());
                if (c > count) {
                    count = c;
                    crime = list.get(i).getCategory();
                }

            }
        }

        view.setupWorstCrime(crime);
        //listener.setupWorstCrime(crime);
    }

    @Override
    public void onSuccess1(String start, String end, int pagePosition, List<FeedPlayer> list) {

    }

    @Override
    public void onSuccess2(List<FeedPlayer> list) {
        int count = 0;
        int c;
        player = "";
        for (int i = 0; i < list.size(); i++) {
            c = Integer.parseInt(list.get(i).getArrestCount());
            if (c > count) {
                count = c;
                player = list.get(i).getName();
            }
        }
        view.setupWorstPlayer(player);
        //listener.setupWorstPlayer(player);

    }

    @Override
    public void onError() {
        Log.d("error","error");
    }

    public void getNamePlayer(final HomeContract.HomeActivityView listener) {
        listener.openListActivity(player);

    }

    public void getNameTeam(final HomeContract.HomeActivityView listener){
        listener.openSecondListActivity(team);
    }


}
