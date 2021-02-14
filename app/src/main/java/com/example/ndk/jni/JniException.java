package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/14/21
 */
public class JniException {
    static {
        System.loadLibrary("exception-lib");
    }

    public native int nativeInvokeJavaException();

    public native void nativeThrowException() throws IllegalArgumentException;

    private int operation() {
        return 2 / 0;
    }
}
