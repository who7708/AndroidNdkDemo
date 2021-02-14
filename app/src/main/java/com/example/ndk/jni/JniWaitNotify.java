package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/14/21
 */
public class JniWaitNotify {
    static {
        System.loadLibrary("wait-notify-lib");
    }

    public native String waitNativeThread();

    public native String notifyNativeThread();

    public native String startProductAndConsumerThread();
}
