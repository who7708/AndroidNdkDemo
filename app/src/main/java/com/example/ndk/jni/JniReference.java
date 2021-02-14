package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/14/21
 */
public class JniReference {
    static {
        System.loadLibrary("reference-lib");
    }

    public native String errorCacheLocalReference();

    public native String cacheWithGlobalReference();

    public native String useWeakGlobalReference();
}
