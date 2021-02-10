package com.example.myapplication.base;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/11/21
 */
public class JniInvoke {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getString();
}
