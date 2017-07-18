package com.example.plavatvornica.prvamalenaaplikacija.data_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Plava tvornica on 18.7.2017..
 */

public class FeedCrime {

    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("arrest_count")
    @Expose
    private String arrestCount;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(String arrestCount) {
        this.arrestCount = arrestCount;
    }

}
