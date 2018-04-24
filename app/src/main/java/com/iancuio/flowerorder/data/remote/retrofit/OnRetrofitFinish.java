package com.iancuio.flowerorder.data.remote.retrofit;

import retrofit2.Response;

/**
 * Created by vlad.iancu on 9/30/2016.
 */

public interface OnRetrofitFinish {
    void onRetrofitFinishExecuteSuccess(Response response);
    void onRetrofitFinishExecuteFail();
}
