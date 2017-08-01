package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface CrimeInteractor extends BaseInteractor {
    void getAllCrimes(CrimeListener listener);
    void getPlayersCrimes(String playerName, CrimeListener listener);
    Observable<List<FeedCrime>> getAllCrimesObservable();
    Observable<List<FeedCrime>> getPlayersCrimesObservable(String playerName);

}
