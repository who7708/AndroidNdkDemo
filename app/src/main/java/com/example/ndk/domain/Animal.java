package com.example.ndk.domain;

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
}
