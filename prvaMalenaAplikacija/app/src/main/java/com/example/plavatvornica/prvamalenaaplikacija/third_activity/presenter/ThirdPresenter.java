package com.example.plavatvornica.prvamalenaaplikacija.third_activity.presenter;

import android.util.Log;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.FeedCrimeOverYear;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper_Second;
import com.example.plavatvornica.prvamalenaaplikacija.rest_utils.RestUtils;
import com.example.plavatvornica.prvamalenaaplikacija.third_activity.view.ThirdInterface;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Plava tvornica on 20.7.2017..
 */

public class ThirdPresenter {

    private List<Wrapper_Second> lCrimeOverYear;

    Call<List<FeedCrimeOverYear>> feedCrimeOverYear;

    public void getCrimesOverYear(String start, String end, final int pagePosition, final ThirdInterface listener){
        feedCrimeOverYear= RestUtils.getApi().listOfCrimesOverYear(start,end);
        feedCrimeOverYear.enqueue(new Callback<List<FeedCrimeOverYear>>() {
            @Override
            public void onResponse(Call<List<FeedCrimeOverYear>> call, Response<List<FeedCrimeOverYear>> response) {
                List<FeedCrimeOverYear> list = response.body();
                lCrimeOverYear = new ArrayList<>();
                assert list != null;
                for(int i = 0; i<list.size(); i++){
                    lCrimeOverYear.add(new Wrapper_Second(list.get(i).getTeam(), Wrapper_Second.TYPE_NAME_OF_TEAM));
                    lCrimeOverYear.add(new Wrapper_Second(list.get(i).getName(), Wrapper_Second.TYPE_NAME_OF_PLAYER));
                }

                listener.sendListOfCrimesOverYear(lCrimeOverYear, pagePosition);
            }

            @Override
            public void onFailure(Call<List<FeedCrimeOverYear>> call, Throwable t) {
                Log.d("TAG", "Ne radi response godine.");
            }
        });
    }

}
