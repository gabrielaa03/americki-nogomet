package com.example.plavatvornica.prvamalenaaplikacija.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Plava tvornica on 8.8.2017..
 */

public class SharedRepo {

    private static final String TIME_CRIMES = "lastTime1";
    private static final String TIME_TEAMS = "lastTime1";
    private static final String  TIME_CRIMES_OVER_YEAR = "lastTime2";
    private static final String TIME_PLAYERS_CRIMES= "lastTime3";
    private static final String TIME_ALL_PLAYERS = "lastTime4";
    private static final String TIME_HOME = "lastTime5";

    MyApplication app;

    public SharedRepo(MyApplication app) {
        this.app = app;
    }

    public void setSavedTimeAllPlayers(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_ALL_PLAYERS, l);
        editor.apply();
    }

    public long getSavedTimeAllPlayers(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_ALL_PLAYERS, 0);
    }

    public void setSavedTimeAllTeams(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_TEAMS, l);
        editor.apply();
    }

    public long getSavedTimeAllTeams(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_TEAMS, 0);
    }

    public void setSavedTimeCrimesOverYear(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_CRIMES_OVER_YEAR, l);
        editor.apply();
    }

    public long getSavedTimeCrimesOverYear(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_CRIMES_OVER_YEAR, 0);
    }


    public void setSavedTimeAllCrimes(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_CRIMES, l);
        editor.apply();
    }

    public long getSavedTimeAllCrimes(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_CRIMES, 0);
    }

    public void setSavedTimePlayersCrimes(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_PLAYERS_CRIMES, l);
        editor.apply();
    }

    public long getSavedTimePlayersCrimes(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_PLAYERS_CRIMES, 0);
    }

    public void setSavedTimeHome(long l){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(TIME_HOME, l);
        editor.apply();
    }

    public long getSavedTimeHome(){
        SharedPreferences prefs = app.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return prefs.getLong(TIME_HOME, 0);
    }



}
