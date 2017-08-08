package com.example.plavatvornica.prvamalenaaplikacija.home_activity;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface HomeContract {

    interface HomeActivityView {
        //deklaracija
        void setupWorstPlayer(String player);

        void setupWorstTeam(String team);

        void setupWorstCrime(String crime);

        void openListActivity(String player);

        void openSecondListActivity(String player);
    }

    interface HomeActivityPresenter {
        // inače se stavi uvijek BasePresenter koji sadrži ove dvije metode i svaki drugi presenter samo nasljeđuje ove osnovne metode start i stop, zato što se u njima odvija dohvaćanje podataka
        void onStart();

        void onStop();

        void getNamePlayer();

        void getNameTeam();
    }
}
