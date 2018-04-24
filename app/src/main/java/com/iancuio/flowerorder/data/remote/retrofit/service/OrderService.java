package com.iancuio.flowerorder.data.remote.retrofit.service;

import com.iancuio.flowerorder.ui.orders.Order;
import com.iancuio.flowerorder.utils.RestUrls;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Iancuio on 6/13/2017.
 */

public interface OrderService {
    @GET(RestUrls.GET_ORDERS)
    Call<List<Order>> getOrders();

}
