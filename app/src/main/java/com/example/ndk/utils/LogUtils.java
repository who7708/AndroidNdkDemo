package com.example.ndk.utils;

import android.util.Log;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/10/21
 */
public class LogUtils {

    private static final String TAG = LogUtils.class.getSimpleName();

    public static void i(String str) {
        Log.e(TAG, "i: " + str);
    }
}
