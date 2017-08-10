package com.example.plavatvornica.prvamalenaaplikacija.list_activity;

import android.view.View;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper;

import java.util.List;

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

        void onStart();

        void onStop();

        void initialize(String playersName, String teamName);
    }

}
