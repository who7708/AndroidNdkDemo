package com.example.ndk.jni;

import com.example.ndk.domain.Animal;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/12/21
 */
public class JniAccessField {
    static {
        System.loadLibrary("access-field-lib");
    }

    public native String accessStaticField(Animal animal);

    public native long accessInstanceField(Animal animal);

    /**
     * 自动在生成的jni 方法中,加入 jclass 参数
     */
    public static native long staticAccessInstanceField(Animal animal);

}
