package com.iancuio.starterapp.utils.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import static android.view.View.ALPHA;
import static android.view.View.ROTATION;
import static android.view.View.TRANSLATION_X;
import static android.view.View.TRANSLATION_Y;

/**
 * Created by vlad.iancu on 4/5/2016.
 */
public class AnimationUtils {

    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_UP = 3;
    public static final int DIRECTION_DOWN = 4;

    public static void fadeInAlpha(final View ip, final View port) {
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(500);
        fadeIn.setStartOffset(0);
        fadeIn.setFillAfter(true);

        port.startAnimation(fadeIn);
        ip.startAnimation(fadeIn);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ip.setVisibility(View.VISIBLE);
                port.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public static void fadeOutAlpha(final View ip, final View port) {
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(500);
        fadeOut.setStartOffset(0);
        fadeOut.setFillAfter(true);

        port.startAnimation(fadeOut);
        ip.startAnimation(fadeOut);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ip.setVisibility(View.INVISIBLE);
                port.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public static void animateViewWithObjectAnimator(View view, long duration, PropertyValuesHolder... propertyValuesHolders) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolders);
        objectAnimator.setDuration(duration);
        objectAnimator.start();
    }

    public static void animateViewWithObjectAnimator(View view, long duration, Animator.AnimatorListener animatorListener, PropertyValuesHolder... propertyValuesHolders) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolders);
        objectAnimator.setDuration(duration);
        objectAnimator.addListener(animatorListener);
        objectAnimator.start();
    }

    public static void animateViewToX(View view, long duration, float X) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_X, X);

        animateViewWithObjectAnimator(view, duration, translationX);
    }

    public static void animateViewToX(View view, long duration, float X, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_X, X);

        animateViewWithObjectAnimator(view, duration, animatorListener, translationX);
    }

    public static void animateViewToY(View view, long duration, float Y) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_Y, Y);

        animateViewWithObjectAnimator(view, duration, translationX);
    }

    public static void animateViewToInitialY(View view, long duration, float Y, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_Y, Y);

        animateViewWithObjectAnimator(view, duration, animatorListener, translationX);
    }

    public static void animateViewToInitialX(View view, long duration) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_X, 0);

        animateViewWithObjectAnimator(view, duration, translationX);
    }

    public static void animateViewToInitialX(View view, long duration, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_X, 0);

        animateViewWithObjectAnimator(view, duration, animatorListener, translationX);
    }

    public static void animateViewToInitialY(View view, long duration) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 0);

        animateViewWithObjectAnimator(view, duration, translationX);
    }

    public static void animateViewToInitialY(View view, long duration, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder translationX = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 0);

        animateViewWithObjectAnimator(view, duration, animatorListener, translationX);
    }

    public static void animateViewToInitialRotation(View view, long duration) {
        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat(ROTATION, 0);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, rotation);
    }

    public static void animateViewToInitialRotation(View view, long duration, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat(ROTATION, 0);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, animatorListener, rotation);
    }

    public static void animateViewOutsideScreenX(View view, long duration, int direction, Context context) {
        float outsideScreenValue = context.getResources().getDisplayMetrics().widthPixels * 1.2f;

        PropertyValuesHolder outsideScreen = PropertyValuesHolder.ofFloat(TRANSLATION_X, direction == DIRECTION_LEFT ? -outsideScreenValue : outsideScreenValue);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, outsideScreen);
    }

    public static void animateViewOutsideScreenX(View view, long duration, int direction, Context context, Animator.AnimatorListener animatorListener) {
        float outsideScreenValue = context.getResources().getDisplayMetrics().widthPixels* 1.2f;

        PropertyValuesHolder outsideScreen = PropertyValuesHolder.ofFloat(TRANSLATION_X, direction == DIRECTION_LEFT ? -outsideScreenValue : outsideScreenValue);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, animatorListener, outsideScreen);
    }

    public static void animateViewOutsideScreenY(View view, long duration, int direction, Context context) {
        float outsideScreenValue = context.getResources().getDisplayMetrics().heightPixels* 1.2f;

        PropertyValuesHolder outsideScreen = PropertyValuesHolder.ofFloat(TRANSLATION_Y, direction == DIRECTION_UP ? -outsideScreenValue : outsideScreenValue);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, outsideScreen);
    }

    public static void animateViewOutsideScreenY(View view, long duration, int direction, Context context, Animator.AnimatorListener animatorListener) {
        float outsideScreenValue = context.getResources().getDisplayMetrics().heightPixels* 1.2f;

        PropertyValuesHolder outsideScreen = PropertyValuesHolder.ofFloat(TRANSLATION_Y, direction == DIRECTION_UP ? -outsideScreenValue : outsideScreenValue);

        AnimationUtils.animateViewWithObjectAnimator(view, duration, animatorListener, outsideScreen);
    }

    public static void animateViewAlpha(View view, long duration, float fromAlpha, float toAlpha) {
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(ALPHA, fromAlpha, toAlpha);

        animateViewWithObjectAnimator(view, duration, alpha);
    }

    public static void animateViewAlpha(View view, long duration, float fromAlpha, float toAlpha, Animator.AnimatorListener animatorListener) {
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(ALPHA, fromAlpha, toAlpha);

        animateViewWithObjectAnimator(view, duration, animatorListener, alpha);
    }
}
