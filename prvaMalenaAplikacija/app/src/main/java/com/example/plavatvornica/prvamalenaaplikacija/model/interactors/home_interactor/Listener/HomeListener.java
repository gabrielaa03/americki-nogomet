package com.example.plavatvornica.prvamalenaaplikacija.model.interactors.home_interactor.Listener;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.HomeContainer;

/**
 * Created by Plava tvornica on 31.7.2017..
 */

public interface HomeListener {
    void onSuccess(HomeContainer homeContainer);
    void onError();
}
