package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/12/21
 */
public class JniReferenceType {
    static {
        System.loadLibrary("reference-lib");
    }

    public native String callNativeStringArray(String[] strArray);
}
