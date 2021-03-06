package com.example.plavatvornica.prvamalenaaplikacija.model.database;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrimesOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayerCrimes;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Plava tvornica on 4.8.2017..
 */

public class DatabaseHandle {

    public static void saveFeedCrimes(final List<FeedCrime> listCrime) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(listCrime);
            }
        });
    }

    public static void saveFeedTeam(final List<FeedTeam> listTeam) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(listTeam);
            }
        });
    }

    public static void saveFeedPlayer(final List<FeedPlayer> listPlayer) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(listPlayer);
            }
        });
    }

    public static void saveFeedCrimesOverYear(final List<FeedCrimesOverYear> listPlayer) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(listPlayer);
            }
        });
    }

    public static void saveFeedPlayersCrimes(final List<FeedPlayerCrimes> listPlayer1) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(listPlayer1);
            }
        });
    }

    public static List<FeedPlayer> getFeedPlayer() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(FeedPlayer.class).findAll());
    }

    public static List<FeedCrime> getFeedCrime() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(FeedCrime.class).findAll());
    }

    public static List<FeedTeam> getFeedTeam() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(FeedTeam.class).findAll());
    }

    public static List<FeedPlayerCrimes> getFeedPlayersCrimes() {
        Realm realm = Realm.getDefaultInstance();
         return realm.copyFromRealm(realm.where(FeedPlayerCrimes.class).findAll());
    }

    public static List<FeedCrimesOverYear> getFeedCrimesOverYear(int id) {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(FeedCrimesOverYear.class).equalTo("pos", id).findAll());
    }
}
