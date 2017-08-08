package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Plava tvornica on 8.8.2017..
 */

public class WrapperFeedCrime extends RealmObject {

public FeedCrime feedCrime;

    public WrapperFeedCrime(FeedCrime feedCrime) {
        this.feedCrime = feedCrime;
    }

    public WrapperFeedCrime() {
    }

    public FeedCrime getFeed() {
        return feedCrime;
    }

    public void setFeed(FeedCrime feedCrime) {
        this.feedCrime = feedCrime;
    }
}
