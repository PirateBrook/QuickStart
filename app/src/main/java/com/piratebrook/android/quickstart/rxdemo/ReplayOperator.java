package com.piratebrook.android.quickstart.rxdemo;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by mac on 2018/3/14.
 */

public class ReplayOperator {

    static Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).replay(4);

    public void doDemo() {
        source.subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("The first consumer accept : " + aLong);
            }
        });

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        source.subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                System.out.println("The second consumer accept : " + aLong);
//            }
//        });
    }
}
