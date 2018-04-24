package com.iancuio.starterapp.data.remote.retrofit.service;

import com.iancuio.starterapp.utils.RestUrls;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Iancuio on 6/13/2017.
 */

public interface RetrofitService {
    @POST(RestUrls.POST_URL)
    Call<Void> post(@Header("Authorization") String token, @Path("you-name-it") String string, @Body String body);

    @GET(RestUrls.GET_URL)
    Call<Void> get(@Header("Authorization") String token);

}
