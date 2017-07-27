package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.crime_interactor.listeners.CrimeListener;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface CrimeInteractor extends BaseInteractor {
    void getAllCrimes(CrimeListener listener);
    void getPlayersCrimes(String playerName, CrimeListener listener);
}
