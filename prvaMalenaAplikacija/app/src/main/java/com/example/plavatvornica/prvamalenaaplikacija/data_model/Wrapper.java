package com.example.plavatvornica.prvamalenaaplikacija.data_model;

import com.example.plavatvornica.prvamalenaaplikacija.R;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class Wrapper {

    public static final int TYPE_HEADER = R.layout.recycler_cell_layout_header;
    public static final int TYPE_ELEMENT = R.layout.recycler_cell_layout;


    String text;
    int type;

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
