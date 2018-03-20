package com.piratebrook.android.quickstart.rxdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mac on 2018/3/14.
 */

public class RxDemoActivity extends AppCompatActivity {

    private ReplayOperator replayOperator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareRun();
        run();
    }

    private void prepareRun() {
        replayOperator = new ReplayOperator();
    }

    private void run() {
        replayOperator.doDemo();
    }

    private void release() {
        replayOperator = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        release();
    }
}
