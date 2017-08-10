package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;

import java.util.List;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface ListOfCriminalsContract {

    interface ThirdView {
        void sendListOfCrimesOverYear(List<Wrapper_Second> list, int pageP);
    }

    interface ThirdPresenter {

        void onStart();

        void onStop();

        void getData(String start, String end, int pos);
    }

    interface BetweenFragmentAndActivityInterface {

        void sendDataToActivity(String start_date, String end_date, int pagePosition);
    }
}
