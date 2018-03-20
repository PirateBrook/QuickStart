package com.piratebrook.android.quickstart.claim;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.piratebrook.android.quickstart.R;

public class TopBar extends RelativeLayout {

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.topbar_basic, this);
    }
}
