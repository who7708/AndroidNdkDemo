package com.example.ndk.jni;

import com.example.ndk.domain.Animal;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/13/21
 */
public class JniConstructorClass {
    static {
        System.loadLibrary("constructor-lib");
    }

    public native Animal invokeAnimalConstructors();

    public native Animal allocObjectConstructor();
}
