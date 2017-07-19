package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import java.util.List;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public interface SecondInterface {
    void getNameOfPlayerOrTeam();

    void sendPlayersCrimes(List<String> list);

    void sendSortedCrimes(List<String> list);


}
