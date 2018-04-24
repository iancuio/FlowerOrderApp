package com.iancuio.starterapp.utils.nullcheck;

public class NullCheckUtils {
    public static void nullCheck(Object object, NullCheck nullCheck) {
        if (object != null) {
            nullCheck.onNotNull();
        } else {
            nullCheck.onNull();
        }
    }
}
