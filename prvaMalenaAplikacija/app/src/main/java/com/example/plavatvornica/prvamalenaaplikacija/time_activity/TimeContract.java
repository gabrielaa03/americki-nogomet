package com.example.plavatvornica.prvamalenaaplikacija.time_activity;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public interface TimeContract {
    interface TimeView{
        void sendTimeData(String time);
    }
    interface TimePresenter{
        void onStart();
        void onStop();

    }
}
