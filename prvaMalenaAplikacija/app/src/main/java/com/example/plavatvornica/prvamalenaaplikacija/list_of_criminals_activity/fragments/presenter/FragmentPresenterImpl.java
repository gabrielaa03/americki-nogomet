package com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.presenter;


import com.example.plavatvornica.prvamalenaaplikacija.list_of_criminals_activity.fragments.FragmentContract;

import javax.inject.Inject;

/**
 * Created by Plava tvornica on 24.7.2017..
 */

public class FragmentPresenterImpl implements FragmentContract.FragmentPresenter {
    FragmentContract.FragmentView view;
    private String start_date, end_date;

    @Inject
    public FragmentPresenterImpl(FragmentContract.FragmentView view) {
        this.view = view;
    }
    @Override
    public void findFragment(int pos, final FragmentContract.FragmentView listener) {

        switch (pos) {

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

        listener.sendDate(start_date, end_date, pos);

    }
}
