package com.example.plavatvornica.prvamalenaaplikacija.third_activity.fragments;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public interface FragmentContract {

    interface FragmentView {
        void sendDate(String start_date, String end_date, int pagePosition);
    }

    interface FragmentPresenter{

    }
}
