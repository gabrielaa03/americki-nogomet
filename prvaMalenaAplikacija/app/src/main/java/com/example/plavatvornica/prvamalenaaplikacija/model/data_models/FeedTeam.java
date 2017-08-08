package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class FeedTeam extends RealmObject {
    @PrimaryKey
    @SerializedName("Team")
    @Expose
    private String team;
    @SerializedName("Team_preffered_name")
    @Expose
    private String teamPrefferedName;
    @SerializedName("Team_name")
    @Expose
    private String teamName;
    @SerializedName("Team_city")
    @Expose
    private String teamCity;
    @SerializedName("Team_Conference")
    @Expose
    private String teamConference;
    @SerializedName("Team_Conference_Division")
    @Expose
    private String teamConferenceDivision;
    @SerializedName("Team_logo_id")
    @Expose
    private String teamLogoId;
    @SerializedName("arrest_count")
    @Expose
    private String arrestCount;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamPrefferedName() {
        return teamPrefferedName;
    }

    public void setTeamPrefferedName(String teamPrefferedName) {
        this.teamPrefferedName = teamPrefferedName;
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

    public String getTeamConference() {
        return teamConference;
    }

    public void setTeamConference(String teamConference) {
        this.teamConference = teamConference;
    }

    public String getTeamConferenceDivision() {
        return teamConferenceDivision;
    }

    public void setTeamConferenceDivision(String teamConferenceDivision) {
        this.teamConferenceDivision = teamConferenceDivision;
    }

    public String getTeamLogoId() {
        return teamLogoId;
    }

    public void setTeamLogoId(String teamLogoId) {
        this.teamLogoId = teamLogoId;
    }

    public String getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(String arrestCount) {
        this.arrestCount = arrestCount;
    }

}
