package com.example.plavatvornica.prvamalenaaplikacija.data_model;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class Wrapper {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ELEMENT = 2;
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
