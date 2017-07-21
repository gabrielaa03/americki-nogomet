package com.example.plavatvornica.prvamalenaaplikacija.third_activity;

import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrimeOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;

import java.util.List;

/**
 * Created by Plava tvornica on 20.7.2017..
 */

public interface Fragmentinterface {

    void sendListOfCrimesOverYear (List<Wrapper_Second> list);
}
