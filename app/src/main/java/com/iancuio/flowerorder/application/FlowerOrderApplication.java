package com.iancuio.flowerorder.application;

import android.support.multidex.MultiDexApplication;

import io.realm.Realm;

public class FlowerOrderApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}
