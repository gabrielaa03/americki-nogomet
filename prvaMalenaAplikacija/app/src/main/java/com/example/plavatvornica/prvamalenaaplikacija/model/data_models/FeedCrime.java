package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class FeedCrime extends RealmObject {
    @PrimaryKey
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("arrest_count")
    @Expose
    private String arrestCount;

    @SerializedName("category")
    @Expose
    private String category1;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(String arrestCount) {
        this.arrestCount = arrestCount;
    }

}
