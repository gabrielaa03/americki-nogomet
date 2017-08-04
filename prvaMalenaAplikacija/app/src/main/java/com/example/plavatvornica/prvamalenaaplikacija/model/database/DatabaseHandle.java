package com.example.plavatvornica.prvamalenaaplikacija.model.database;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Plava tvornica on 4.8.2017..
 */

public class DatabaseHandle {
    Realm realm = Realm.getDefaultInstance();

    public  void getFeedCrimes(final List<FeedCrime> listCrime){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
              FeedCrime feedCrime = realm.createObject(FeedCrime.class);
                for(int i=0; i<listCrime.size(); i++){
                    feedCrime.setCategory(listCrime.get(i).getCategory());
                    feedCrime.setCategory1(listCrime.get(i).getCategory1());
                    feedCrime.setArrestCount(listCrime.get(i).getArrestCount());
                }
            }
        });
    }

    public void getFeedTeam(final List<FeedTeam> listTeam){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                FeedTeam feedTeam = realm.createObject(FeedTeam.class);
                for (int i = 0; i < listTeam.size(); i++) {
                    feedTeam.setArrestCount(listTeam. get(i).getArrestCount());
                    feedTeam.setTeam(listTeam. get(i).getTeam());
                    feedTeam.setTeamCity(listTeam. get(i).getTeamCity());
                    feedTeam.setTeamPrefferedName(listTeam. get(i).getTeamPrefferedName());
                    feedTeam.setTeamConference(listTeam. get(i).getTeamConference());
                    feedTeam.setTeamLogoId(listTeam. get(i).getTeamLogoId());
                    feedTeam.setTeamConferenceDivision(listTeam. get(i).getTeamConferenceDivision());
                }
            }
        });


    }

    public void getFeedPlayer(final List<FeedPlayer> listPlayer){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                FeedPlayer feedPlayer = realm.createObject(FeedPlayer.class);
                for(int i = 0; i<listPlayer.size();i++){
                    feedPlayer.setArrestCount(listPlayer.get(i).getArrestCount());
                    feedPlayer.setTeamCity(listPlayer.get(i).getTeamCity());
                    feedPlayer.setTeam(listPlayer.get(i).getTeam());
                    feedPlayer.setName(listPlayer.get(i).getName());
                    feedPlayer.setPosition(listPlayer.get(i).getPosition());
                    feedPlayer.setTeamName(listPlayer.get(i).getTeamName());
            }
        }});
    }

    public void destroyRealm(){realm.close();}

}
