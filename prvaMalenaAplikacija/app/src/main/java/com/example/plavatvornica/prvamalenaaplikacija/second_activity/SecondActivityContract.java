package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import dagger.Provides;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface SecondActivityContract {

    interface SecondActivityView {

        void sendPlayersCrimes(List<Wrapper> list);

        void sendSortedCrimes(List<Wrapper> list);

        void onClick(View view, String text);

    }


    interface ListPresenter {
        // inače se stavi uvijek BasePresenter koji sadrži ove dvije metode i svaki drugi presenter samo nasljeđuje ove osnovne metode start i stop, zato što se u njima odvija dohvaćanje podataka
        void onStart();

        void onStop();

        void initialize(String playersName, String teamName);
    }

}
