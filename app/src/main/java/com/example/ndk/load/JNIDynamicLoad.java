package com.example.ndk.load;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/10/21
 */
public class JNIDynamicLoad {
    static {
        System.loadLibrary("dynamic-lib");
    }

    public native int sum(int x, int y);

    public native String getNativeString();
}
