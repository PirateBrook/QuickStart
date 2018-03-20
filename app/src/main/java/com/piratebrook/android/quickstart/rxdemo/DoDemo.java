package com.piratebrook.android.quickstart.rxdemo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by mac on 2018/3/14.
 */

public class DoDemo {

    public void run() {
        Observable.just(1, 2, 3)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        integer = integer + 1;
                    }
                });
    }
}
