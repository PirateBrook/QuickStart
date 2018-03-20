package com.piratebrook.android.quickstart.claim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.piratebrook.android.quickstart.R;

/**
 * Created by mac on 2018/3/19.
 */

public class BackButton extends RelativeLayout {
    public BackButton(Context context) {
        this(context, null);
    }

    public BackButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BackButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.button_back, this);
    }
}
