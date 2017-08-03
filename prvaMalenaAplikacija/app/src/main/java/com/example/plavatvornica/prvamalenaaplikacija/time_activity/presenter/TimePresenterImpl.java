package com.example.plavatvornica.prvamalenaaplikacija.time_activity.presenter;

import android.util.Log;
import android.util.TimeFormatException;

import com.example.plavatvornica.prvamalenaaplikacija.time_activity.TimeContract;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

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
    @Inject
    public TimePresenterImpl(TimeContract.TimeView view) {
        this.view = view;
    }

    @Override
    public void onStart() {
        compositeDisposable.add(
                Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        long time = System.currentTimeMillis();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                        Date resultdate = new Date(time);
                        view.sendTimeData(simpleDateFormat.format(resultdate));
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
        compositeDisposable.dispose();
    }
}
