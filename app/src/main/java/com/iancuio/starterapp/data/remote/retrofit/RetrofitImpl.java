package com.iancuio.starterapp.data.remote.retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.iancuio.starterapp.R;
import com.iancuio.starterapp.data.remote.retrofit.service.RetrofitService;
import com.iancuio.starterapp.utils.RestUrls;
import com.iancuio.starterapp.utils.StringUtils;
import com.iancuio.starterapp.utils.responseCodes.CodeCheck;
import com.iancuio.starterapp.utils.responseCodes.CodeCheckUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by vlad.iancu on 9/30/2016.
 */

public class RetrofitImpl {
    public static void method(final Context context, final int successStringId,
                                                  final int failedStringId, final String className,
                                                  final String methodName, final OnRetrofitFinish onRetrofitFinish) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestUrls.BASE_URL)
                .client(RetrofitUtils.okHttpClientBuilder())
                .addConverterFactory(JacksonConverterFactory.create()).build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        Call<Void> call = retrofitService.get("");

        executeCall(call, context, successStringId, failedStringId, methodName, className, onRetrofitFinish);
    }

    private static void executeCall(Call call, final Context context, final int successStringId,
                                    final int failedStringId, final String methodName,
                                    final String className, final OnRetrofitFinish onRetrofitFinish) {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, final Response response) {
                CodeCheckUtils.codeCheck(response.code(), new CodeCheck() {
                    @Override
                    public void on200() {
                        Toast.makeText(context, successStringId, Toast.LENGTH_SHORT).show();
                        Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, context.getString(R.string.success), response.code()));
                        onRetrofitFinish.onRetrofitFinishExecuteSuccess(response);
                    }

                    @Override
                    public void on401() {
                        Toast.makeText(context, failedStringId, Toast.LENGTH_SHORT).show();
                        Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, context.getString(R.string.fail), response.code()));
                        onRetrofitFinish.onRetrofitFinishExecuteFail();
                    }

                    @Override
                    public void on404() {
                        Toast.makeText(context, failedStringId, Toast.LENGTH_SHORT).show();
                        Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, context.getString(R.string.fail), response.code()));
                        onRetrofitFinish.onRetrofitFinishExecuteFail();
                    }

                    @Override
                    public void on500() {
                        Toast.makeText(context, failedStringId, Toast.LENGTH_SHORT).show();
                        Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, context.getString(R.string.fail), response.code()));
                        onRetrofitFinish.onRetrofitFinishExecuteFail();
                    }

                    @Override
                    public void onOther() {
                        Toast.makeText(context, failedStringId, Toast.LENGTH_SHORT).show();
                        Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, context.getString(R.string.fail), response.code()));
                        onRetrofitFinish.onRetrofitFinishExecuteFail();
                    }
                });
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(context, failedStringId, Toast.LENGTH_SHORT).show();
                Log.e(className, StringUtils.composeMessageForRetrofitResponseLog(methodName, t.toString(), -1));
                onRetrofitFinish.onRetrofitFinishExecuteFail();
            }
        });
    }
}
