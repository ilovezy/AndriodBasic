package com.example.a.myapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by a on 2017/1/3.
 */

public class RippleButton extends Button {
    private RippleDrawable myRippleDrawable;

    public RippleButton(Context context) {
        this(context, null);
    }

    public RippleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myRippleDrawable = new RippleDrawable();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        myRippleDrawable.draw(canvas);
        super.onDraw(canvas);

    }
}
