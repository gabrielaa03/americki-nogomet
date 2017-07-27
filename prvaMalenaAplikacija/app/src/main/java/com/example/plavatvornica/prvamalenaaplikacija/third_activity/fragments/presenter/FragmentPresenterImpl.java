package com.example.plavatvornica.prvamalenaaplikacija.third_activity.fragments.presenter;


import com.example.plavatvornica.prvamalenaaplikacija.third_activity.fragments.FragmentContract;

/**
 * Created by Plava tvornica on 24.7.2017..
 */

public class FragmentPresenterImpl implements FragmentContract.FragmentPresenter {

    String start_date, end_date;

    public void findFragment (int position, final FragmentContract.FragmentView listener){

        switch(position){

            case 0:
                start_date = "2010-01-01";
                end_date = "2010-12-31";
                break;
            case 1:
                start_date = "2011-01-01";
                end_date = "2011-12-31";

                break;
            case 2:
                start_date = "2012-01-01";
                end_date = "2012-12-31";

                break;
            case 3:
                start_date = "2013-01-01";
                end_date = "2013-12-31";
                break;
        }

        int pagePosition = position;
        listener.sendDate(start_date, end_date, pagePosition);

    }
}
