package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import io.realm.RealmModel;

/**
 * Created by Plava tvornica on 9.8.2017..
 */

public class WrapperCrimesOverYeaer implements RealmModel {

    private FeedPlayer feedPlayer;

    public WrapperCrimesOverYeaer(FeedPlayer feedPlayer) {
        this.feedPlayer = feedPlayer;
    }

    public FeedPlayer getFeedPlayer() {
        return feedPlayer;
    }

    public void setFeedPlayer(FeedPlayer feedPlayer) { this.feedPlayer = feedPlayer; }
}
