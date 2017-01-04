package com.example.a.myapplication.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by a on 2017/1/3.
 */

public class RippleDrawable extends Drawable {
    // 0-255 透明度
    private int mAlpha = 200;
    private int mRippleColor = 255;

    // 画笔
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RippleDrawable() {
        // 设置抗锯齿
        mPaint.setAntiAlias(true);
        // 防抖动
        mPaint.setDither(true);
        setRippleColor(0x30000000);
    }

    public void setRippleColor(int color) {
        // 不建议直接设置
//        mPaint.setColor(color);
        mRippleColor = color;
        onColorOrAlphaChange();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(0x30ff0000);
        // 画个圆
        // canvas.drawCircle();
    }

    @Override
    public void setAlpha(int alpha) {
        mAlpha = alpha;

        onColorOrAlphaChange();
    }

    private void onColorOrAlphaChange() {
        // 0x30ffffff
        mPaint.setColor(mRippleColor);

        if (mAlpha != 255) {
            // 得到颜色本身透明度
            // 0x30
            int pAlpha = mPaint.getAlpha();
//            pAlpha = Color.alpha(mRippleColor);
            int realAlpha = (int) (pAlpha * (mAlpha / 255.f));
            mPaint.setAlpha(realAlpha);
            mPaint.getColor();
            Log.e("TAG", "Old: " + mRippleColor + " new: " + mPaint.getColor());
        }
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
