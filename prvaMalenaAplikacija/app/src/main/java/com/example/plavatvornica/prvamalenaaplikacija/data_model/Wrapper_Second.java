package com.example.plavatvornica.prvamalenaaplikacija.data_model;

import com.example.plavatvornica.prvamalenaaplikacija.R;

/**
 * Created by Plava tvornica on 21.7.2017..
 */

public class Wrapper_Second {

    public static final int TYPE_NAME_OF_PLAYER = R.layout.recycler_layout_player;
    public static final int TYPE_NAME_OF_TEAM = R.layout.recycler_layout_team;


    Object object;
    int type;

    public Wrapper_Second(Object object, int type) {
        this.object = object;
        this.type = type;
    }

    public int getType() {
        return type;
    }
    public Object getObject() {
        return object;
    }
}
