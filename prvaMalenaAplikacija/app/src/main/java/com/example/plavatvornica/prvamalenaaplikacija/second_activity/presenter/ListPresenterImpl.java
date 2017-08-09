package com.example.plavatvornica.prvamalenaaplikacija.second_activity.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.base.SharedRepo;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.SecondActivityContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class ListPresenterImpl implements SecondActivityContract.ListPresenter, CrimeListener {

    private SecondActivityContract.SecondActivityView view;
    private ArrayList<Wrapper> listOfCrimes;
    private CrimeInteractor interactor;
    private String player;

    @Inject
    public ListPresenterImpl(SecondActivityContract.SecondActivityView view, CrimeInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onSuccess(List<FeedCrime> list, int type) {
        if (type == 1) {
            List<String> listOfAllCrimes = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listOfAllCrimes.add(list.get(i).getCategory());
            }

            listOfAllCrimes.removeAll(Collections.singleton(null));
            Collections.sort(listOfAllCrimes);
            List<Wrapper> list1 = new ArrayList<>();

            for (int i = 0; i <= listOfAllCrimes.size(); i++) {

                if (listOfAllCrimes.size() > (i + 1) && listOfAllCrimes.get(i + 1) != null) {
                    if (i == 0) {
                        list1.add(0, new Wrapper(listOfAllCrimes.get(i).substring(0, 1), Wrapper.TYPE_HEADER));
                        list1.add(new Wrapper(listOfAllCrimes.get(i), Wrapper.TYPE_ELEMENT));
                    } else if (listOfAllCrimes.get(i).substring(0, 1).equals(listOfAllCrimes.get(i + 1).substring(0, 1))) {
                        list1.add(new Wrapper(listOfAllCrimes.get(i), Wrapper.TYPE_ELEMENT));
                    } else {
                        list1.add(new Wrapper(listOfAllCrimes.get(i), Wrapper.TYPE_ELEMENT));
                        list1.add(new Wrapper(listOfAllCrimes.get(i + 1).substring(0, 1), Wrapper.TYPE_HEADER));
                    }
                } else if (i == listOfAllCrimes.size() - 1) {
                    list1.add(new Wrapper(listOfAllCrimes.get(i), Wrapper.TYPE_ELEMENT));
                }
            }
            view.sendSortedCrimes(list1);
        } else{
            listOfCrimes = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listOfCrimes.add(new Wrapper(list.get(i).getCategory1(), Wrapper.TYPE_ELEMENT));
            }
            view.sendPlayersCrimes(listOfCrimes);
        }
    }

    @Override
    public void onError() {
        Log.d("error", "error");
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        interactor.disposeComp();
    }

    @Override
    public void initialize(String playersName, String teamName) {
        if (playersName != null) {
            {
                player = playersName;
                interactor.getPlayersCrimes(player, this);
            }
        } else {
                interactor.getAllCrimes(this);
        }
    }

}
