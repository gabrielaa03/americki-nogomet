package com.example.plavatvornica.prvamalenaaplikacija.home_activity.view;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

public interface HomeInterface {
    //deklaracija
    void setupWorstPlayer(String player);
    void setupWorstTeam(String team);
    void setupWorstCrime(String crime);


    void openListActivity(String player);
    void openSecondListActivity(String player);
}
