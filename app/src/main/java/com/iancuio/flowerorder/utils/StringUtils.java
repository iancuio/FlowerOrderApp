package com.iancuio.flowerorder.utils;

/**
 * Created by vlad.iancu on 9/30/2016.
 */

public class StringUtils {
    public static String composeMessageForRetrofitResponseLog(String methodName, String status, int responseCode) {
        return methodName +
                ": " +
                ((status == null) ? "" : status) +
                " " + responseCode;
    }
}
