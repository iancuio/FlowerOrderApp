package com.iancuio.flowerorder.data.remote.retrofit;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by vlad.iancu on 6/8/2016.
 */
public class RetrofitUtils {
    public static OkHttpClient okHttpClientBuilder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.writeTimeout(600, TimeUnit.SECONDS);
        okHttpClient.readTimeout(600, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(300, TimeUnit.SECONDS);

        final ProgressListener progressListener = new ProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
                System.out.println(bytesRead);
                System.out.println(contentLength);
                System.out.println(done);
                System.out.format("%d%% done\n", (100 * bytesRead) / contentLength);
            }
        };

        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response.newBuilder()
                        .body(new ProgressResponseBody(response.body(), progressListener))
                        .build();
            }
        });

        return okHttpClient.build();
    }

    public static OkHttpClient okHttpClientBuilderWithProgress(final ProgressBar progressBar, final ProgressBar progressSpinner, final ImageView finalStatusImageView, final TextView progress, final Activity activity, final String whereFrom) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.writeTimeout(600, TimeUnit.SECONDS);
        okHttpClient.readTimeout(600, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(300, TimeUnit.SECONDS);

        final ProgressListener progressListener = new ProgressListener() {
            @Override
            public void update(final long bytesRead, final long contentLength, final boolean done) {
                    Log.e(whereFrom, String.valueOf(bytesRead));
                    Log.e(whereFrom, String.valueOf(contentLength));
                    Log.e(whereFrom, String.valueOf(done));

                progressBar.setMax(100);

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (done) {
                            progressSpinner.setVisibility(View.GONE);
                            finalStatusImageView.setVisibility(View.VISIBLE);
                        }

                        //System.out.format("%d%% done\n", (100 * bytesRead) / contentLength);
                        if (contentLength != 0) {
                            progressBar.setProgress((int) ((100 * bytesRead) / contentLength));
                            progress.setText(String.valueOf((int) ((100 * bytesRead) / contentLength)) + "%");
                        } else {
                            progressBar.setProgress(100);
                            progress.setText("100%");
                        }
                    }
                });
            }
        };

        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response.newBuilder()
                        .body(new ProgressResponseBody(response.body(), progressListener))
                        .build();
            }
        });

        return okHttpClient.build();
    }
}
