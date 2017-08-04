package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Plava tvornica on 17.7.2017..
 */

public class FeedPlayer  extends RealmObject {
    @PrimaryKey
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Team")
    @Expose
    private String team;
    @SerializedName("Team_name")
    @Expose
    private String teamName;
    @SerializedName("Team_city")
    @Expose
    private String teamCity;
    @SerializedName("Position")
    @Expose
    private String position;
    @SerializedName("arrest_count")
    @Expose
    private String arrestCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(String arrestCount) {
        this.arrestCount = arrestCount;
    }

}
