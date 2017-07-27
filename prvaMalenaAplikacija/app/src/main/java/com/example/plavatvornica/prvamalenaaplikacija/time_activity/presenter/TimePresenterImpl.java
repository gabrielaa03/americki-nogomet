package com.example.plavatvornica.prvamalenaaplikacija.time_activity.presenter;

import android.util.Log;
import android.util.TimeFormatException;

import com.example.plavatvornica.prvamalenaaplikacija.time_activity.TimeContract;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Plava tvornica on 27.7.2017..
 */

public class TimePresenterImpl implements TimeContract.TimePresenter{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TimeContract.TimeView view;


    public TimePresenterImpl(TimeContract.TimeView view) {
        this.view = view;

    }

    @Override
    public void onStart() {
        compositeDisposable.add(
                Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        String time = DateFormat.getTimeInstance().format(new Date());
                        String [] parts = time.split(":");
                        String part0 = parts[0];
                        String part1 = parts[1];
                        String part2 = parts[2];
                        String finalTime = "JEDNOM " + part0 + " IZ " + part1 + " TRI " + part2+ " PUTA ";
                        view.sendTimeData(finalTime);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void onStop() {

    }
}
