package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor;

import com.example.plavatvornica.prvamalenaaplikacija.home_activity.presenter.HomePresenterImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrime;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedTeam;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.BaseInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.Listener.HomeListener;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Plava tvornica on 31.7.2017..
 */

public interface HomeInteractor extends BaseInteractor{

    void getAll(HomeListener listener);

}
