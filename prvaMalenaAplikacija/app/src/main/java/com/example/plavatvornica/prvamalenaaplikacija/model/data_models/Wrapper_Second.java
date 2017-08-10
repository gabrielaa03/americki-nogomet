package com.example.plavatvornica.prvamalenaaplikacija.model.data_models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.plavatvornica.prvamalenaaplikacija.R;

/**
 * Created by Plava tvornica on 21.7.2017..
 */

public class Wrapper_Second implements Parcelable {

    public static final int TYPE_NAME_OF_PLAYER = R.layout.recycler_layout_player;
    public static final int TYPE_NAME_OF_TEAM = R.layout.recycler_layout_team;


    private Object object;
    private int type;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(type));
        dest.writeString(String.valueOf(object));
    }
}
