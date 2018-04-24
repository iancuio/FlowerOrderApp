package com.iancuio.starterapp.utils.picassoUtils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Iancuio on 3/15/2017.
 */

public class PicassoUtils {
    public static void loadImage(Context context, String URL, ImageView target) {
        Picasso.with(context)
                .load(URL)
                .noPlaceholder()
                .into(target);
    }

    public static void loadImage(Context context, String URL, ImageView target, final ProgressBar progressBar) {
        Picasso.with(context)
                .load(URL)
                .noPlaceholder()
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    public static void loadImage(Context context, String URL, ImageView target, int width, int height) {
        Picasso.with(context)
                .load(URL)
                .resize(width, height)
                .centerCrop()
                .noPlaceholder()
                .into(target);
    }

    public static void loadImage(Context context, String URL, ImageView target, int width, int height, Callback callback) {
        Picasso.with(context)
                .load(URL)
                .resize(width, height)
                .centerCrop()
                .noPlaceholder()
                .into(target, callback);
    }

    public static void loadImage(Context context, String URL, ImageView target, final ProgressBar progressBar, int width, int height) {
        Picasso.with(context)
                .load(URL)
                .resize(width, height)
                .centerCrop()
                .noPlaceholder()
                .into(target, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
