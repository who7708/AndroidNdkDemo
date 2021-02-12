package com.example.ndk.domain;

import com.example.ndk.utils.LogUtils;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2/12/21
 */
public class Animal {
    private String name;
    private static long num = 23;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getNum() {
        return num;
    }

    public static void setNum(long num) {
        Animal.num = num;
    }

    /**
     * jni 中调用 java 实例方法
     *
     * @return
     */
    public long callInstanceMethod(long num) {
        LogUtils.i("call instance method and num is " + num);
        return num;
    }

    /**
     * jni 中调用 java 类方法
     */
    public static String callStaticMethod(String str) {
        if (str != null) {
            LogUtils.i("call static method with " + str);
        } else {
            LogUtils.i("call static method str is null");
        }
        return str;
    }

    public static String callStaticMethod(String[] strArray, long num) {
        if (strArray != null) {
            for (String str : strArray) {
                LogUtils.i("str in array is " + str);
            }
        }
        return "调用成功";
    }
}
