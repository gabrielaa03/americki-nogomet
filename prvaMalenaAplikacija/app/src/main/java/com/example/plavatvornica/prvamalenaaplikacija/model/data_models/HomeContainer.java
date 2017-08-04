package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Plava tvornica on 1.8.2017..
 */

public class HomeContainer {

    private List<FeedPlayer> player;
    private List<FeedCrime> crime;
    private List<FeedTeam> team;

    public HomeContainer(List<FeedPlayer> player, List<FeedCrime> crime, List<FeedTeam> team) {
        this.player = player;
        this.crime = crime;
        this.team = team;
    }

    public List<FeedPlayer> getPlayer() {
        return player;
    }

    public List<FeedCrime> getCrime() {
        return crime;
    }

    public List<FeedTeam> getTeam() {return team;}
}
