package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayerCrimes;

import java.util.List;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface CrimeListener {
    void onSuccess(List<FeedCrime> list);
    void onSuccess1(List<FeedPlayerCrimes> list);

    void onError();
}
