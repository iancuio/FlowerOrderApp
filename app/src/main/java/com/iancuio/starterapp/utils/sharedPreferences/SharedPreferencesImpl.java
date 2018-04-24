package com.iancuio.starterapp.utils.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Soulstorm on 1/10/2017.
 */

public class SharedPreferencesImpl {
    public static void clearAll(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
    public static String getString(Context context, String sharedPreferenceKey) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(sharedPreferenceKey, "");
    }

    public static String getString(Context context, String sharedPreferenceKey, String defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(sharedPreferenceKey, defaultValue);
    }

    public static void putString(Context context, String sharedPreferenceKey, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(sharedPreferenceKey, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String sharedPreferenceKey) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(sharedPreferenceKey, true);
    }

    public static boolean getBoolean(Context context, String sharedPreferenceKey, boolean defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(sharedPreferenceKey, defaultValue);
    }

    public static void putBoolean(Context context, String sharedPreferenceKey, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(sharedPreferenceKey, value);
        editor.commit();
    }

    public static int getInt(Context context, String sharedPreferenceKey) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(sharedPreferenceKey, 0);
    }

    public static int getInt(Context context, String sharedPreferenceKey, int defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(sharedPreferenceKey, defaultValue);
    }

    public static void putInt(Context context, String sharedPreferenceKey, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(sharedPreferenceKey, value);
        editor.commit();
    }

}
