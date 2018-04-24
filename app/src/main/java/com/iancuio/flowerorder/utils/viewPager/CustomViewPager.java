package com.iancuio.flowerorder.utils.viewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Iancuio on 3/31/2017.
 */

public class CustomViewPager extends ViewPager {

    float oldX;
    float oldY;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (MotionEvent.ACTION_DOWN == ev.getActionMasked()) {
//            oldX = ev.getX();
//            oldY = ev.getY();
//            setOldRawX(ev.getRawX());
//            setOldRawY(ev.getRawY());
//        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                oldX = ev.getX();
                oldY = ev.getY();
                return false;
//            case MotionEvent.ACTION_MOVE:
//                float newX = ev.getX();
//                float newY = ev.getY();
//
//                float deltaX = oldX - newX;
//                float deltaY = oldY - newY;
//
//                return Math.abs(deltaY) > Math.abs(deltaX);
        }
        return super.onInterceptTouchEvent(ev);
    }
}
