package com.iancuio.flowerorder.utils;

import android.graphics.Rect;
import android.view.View;

/**
 * Created by vlad.iancu on 12.01.2018.
 */

public class ScreenUtils {
    public static Rect getLocationOnScreen(View editText) {
        Rect rectangle = new Rect();
        int[] location = new int[2];

        editText.getLocationOnScreen(location);

        rectangle.left = location[0];
        rectangle.top = location[1];
        rectangle.right = location[0] + editText.getWidth();
        rectangle.bottom = location[1] + editText.getHeight();

        return rectangle;
    }
}
