package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;

import java.util.List;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public interface SecondInterface {
    void getNameOfPlayerOrTeam();

    void sendPlayersCrimes(List<Wrapper> list);

    void sendSortedCrimes(List<Wrapper> list);

    void sendClick();

}
