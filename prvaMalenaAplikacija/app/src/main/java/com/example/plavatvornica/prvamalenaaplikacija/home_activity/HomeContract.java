package com.example.plavatvornica.prvamalenaaplikacija.home_activity;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface HomeContract {

    interface HomeActivityView {

        void setupWorstPlayer(String player);

        void setupWorstTeam(String team);

        void setupWorstCrime(String crime);

        void openListActivityWithPlayer(String player);

        void openListActivityWithTeams(String player);
    }

    interface HomeActivityPresenter {

        void onStart();

        void onStop();

        void getNamePlayer();

        void getNameTeam();
    }
}
