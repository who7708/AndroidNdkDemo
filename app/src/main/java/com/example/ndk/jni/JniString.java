package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/11/21
 */
public class JniString {
    static {
        System.loadLibrary("string-lib");
    }

    public native String callNativeString(String str);

    public native void stringMethod(String str);
}
