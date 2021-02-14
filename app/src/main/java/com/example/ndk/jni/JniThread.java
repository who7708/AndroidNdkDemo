package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/14/21
 */
public class JniThread {
    static {
        System.loadLibrary("thread-lib");
    }

    public native String createNativeThread();

    public native String createNativeThreadWithArgs();

    public native String joinNativeThread();
}
