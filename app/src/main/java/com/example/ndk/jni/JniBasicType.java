package com.example.ndk.jni;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/11/21
 */
public class JniBasicType {
    static {
        System.loadLibrary("basic-type-lib");
    }

    public native int callNativeInt(int num);

    public native byte callNativeByte(byte b);

    public native char callNativeChar(char ch);

    public native short callNativeShort(short sh);

    public native long callNativeLong(long value);

    public native float callNativeFloat(float f);

    public native double callNativeDouble(double d);

    public native boolean callNativeBoolean(boolean bool);
}
