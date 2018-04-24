package com.iancuio.starterapp.utils.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Iancuio on 3/20/2017.
 */

public class BroadcastUtils {
    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        } catch (IllegalArgumentException e) {

        }
    }

    public static void sendBroadcast(Context context, String action, String extra) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(action);
        broadcastIntent.putExtra(extra, extra);
        context.sendBroadcast(broadcastIntent);
    }
}
