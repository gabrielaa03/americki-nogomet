package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import com.example.plavatvornica.prvamalenaaplikacija.R;

import io.realm.RealmObject;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class Wrapper {

    public static final int TYPE_HEADER = R.layout.recycler_cell_layout_header;
    public static final int TYPE_ELEMENT = R.layout.recycler_cell_layout;
    private String text;
    private int type;

    public Wrapper(String text, int type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }
}
