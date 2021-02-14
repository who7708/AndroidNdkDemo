package com.example.ndk.jni;

import android.graphics.Bitmap;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/14/21
 */
public class JniBitmap {
    static {
        System.loadLibrary("bitmap-lib");
    }

    public native Bitmap callNativeMirrorBitmap2(Bitmap bitmap);

    public native Bitmap callNativeMirrorBitmap(Bitmap bitmap);

    public native void getBinaryBitmap(Bitmap bitmap);
}
