package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedCrimesOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;
import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.ListOfCriminalsContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class ListOfCriminalsOverYearImpl implements ListOfCriminalsContract.ThirdPresenter, PlayerListener {

    private ListOfCriminalsContract.ThirdView view;
    private PlayerInteractor interactor;

    @Inject
    public ListOfCriminalsOverYearImpl(ListOfCriminalsContract.ThirdView view, PlayerInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onSuccess1(String start, String end, int pagePosition, List<FeedCrimesOverYear> list) {
        List<Wrapper_Second> lCrimeOverYear = new ArrayList<>();
        assert list != null;
        for (int i = 0; i < list.size(); i++) {
            lCrimeOverYear.add(new Wrapper_Second(list.get(i).getTeam(), Wrapper_Second.TYPE_NAME_OF_TEAM));
            lCrimeOverYear.add(new Wrapper_Second(list.get(i).getName(), Wrapper_Second.TYPE_NAME_OF_PLAYER));
        }
        view.sendListOfCrimesOverYear(lCrimeOverYear, pagePosition);
    }

    @Override
    public void onSuccess2(List<FeedPlayer> list) {
    }

    @Override
    public void onError() {
        Log.d("error", "error");
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        interactor.disposeComp();
    }

    @Override
    public void getData(String start, String end, int pos) { interactor.getCrimesOverYear(start, end, pos, this); }
}
