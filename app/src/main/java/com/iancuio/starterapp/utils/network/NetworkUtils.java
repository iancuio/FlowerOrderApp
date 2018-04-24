package com.iancuio.starterapp.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vlad.iancu on 3/8/2016.
 */
public class NetworkUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (connectivityManager != null && connectivityManager.getActiveNetworkInfo().isConnected());
    }
}
