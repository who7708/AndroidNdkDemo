package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/12/21
 */
public class JniInvokeMethod {
    static {
        System.loadLibrary("callback-lib");
    }

    public native void nativeCallback(ICallbackMethod callbackMethod);

    public native void nativeThreadCallback(IThreadCallback threadCallback);
}
