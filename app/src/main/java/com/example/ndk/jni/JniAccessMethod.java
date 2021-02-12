package com.example.ndk.jni;

import com.example.ndk.domain.Animal;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/12/21
 */
public class JniAccessMethod {
    static {
        System.loadLibrary("access-method-lib");
    }

    public native long accessInstanceMethod(Animal animal);

    public native String accessStaticMethod(Animal animal);

    public native String accessStaticMethod2(Animal animal);
}
