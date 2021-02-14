# Android Ndk Demo

## 在 java 中调用 JNI 方法

* java 方法中加载动态库 so

* java 中调用 native 方法的函数类型

* JNI 头文件的创建方式以及命名方式

## JNI 函数注册

* 静态注册

* 动态注册

## Java 与 JNI 基本数据类型转换

* JNI 中基本数据类型的定义

* java 与 JNI 中的基本数据类型转换

## Java 与 JNI 字符串类型转换

* JNI 中字符串类型的定义

* java 中字符串与 JNI 字符串的转换调用

* JNI 中字符串操作的函数

## Java 与 JNI 引用类型转换

* JNI 中引用类型的定义

* java 中引用类型与 JNI 中引用类型的转换调用实践

## JNI 访问 java 类字段

* 通过 JNI 去访问 java 类中的字段

* 访问并修改类实例的字段

* 访问并修改类的静态字段

## JNI 访问 java 类方法

* 通过 JNI 去访问 java 类中的方法

* 访问 java 类实例的方法

* 访问 java 类静态方法

## JNI 回调 java 方法

* JNI 函数内回调 java 方法

* JNI 函数通过接口参数回调 java 方法

* JNI 子线程如何回调 java 的主线程方法？

## JNI 访问 java 的构造方法

* JNI 调用类的构造方法创建类实例

* 两种不同的实现方式

## JNI 引用类型管理

* JNI 中的三种引用类型

* 全局引用、局部引用、弱引用

* 三种引用的管理

## JNI 异常处理

* JNI 调用 java 方法时的异常处理

* 在 JNI 中抛出异常，交由上层处理

## 线程创建与同步、Bitmap 处理

### JNI 线程的创建

* Posix API 介绍以及线程库

* 线程创建与销毁操作

* 线程同步操作

### JNI 线程的同步

### JNI 中 Bitmap 操作