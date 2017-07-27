package com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter;

import android.util.Log;

import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.FeedPlayer;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractor;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.PlayerInteractorImpl;
import com.example.plavatvornica.prvamalenaaplikacija.model.interactors.player_interactor.listeners.PlayerListener;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.ThirdActivityContract;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class ThirdPresenterImpl implements ThirdActivityContract.ThirdPresenter, PlayerListener {

    ThirdActivityContract.ThirdView view;
    private List<Wrapper_Second> lCrimeOverYear;
    PlayerInteractor interactor;
    String start_date, end_date;
    int pagePos;
    public ThirdPresenterImpl(ThirdActivityContract.ThirdView view) {
        this.view = view;
        interactor = new PlayerInteractorImpl();
    }

    @Override
    public void onSuccess1(String start, String end, int pagePosition, List<FeedPlayer> list) {
        lCrimeOverYear = new ArrayList<>();
        assert list != null;
        for(int i = 0; i<list.size(); i++){
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
    public void getData(String start, String end, int pos) {
        interactor.getCrimesOverYear(start, end, pos, this);
    }
}
