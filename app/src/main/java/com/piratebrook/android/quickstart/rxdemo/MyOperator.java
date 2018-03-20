package com.piratebrook.android.quickstart.rxdemo;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;

/**
 * Created by mac on 2018/3/14.
 */

public class MyOperator<R, T> implements ObservableOperator<R, T> {
    @Override
    public Observer<? super T> apply(Observer<? super R> observer) throws Exception {
        return null;
    }
}
