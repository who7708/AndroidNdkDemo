//
// Created by Chris on 2/10/21.
//

#include <base.h>

#define JAVA_CLASS_NAME "com/example/myapplication/load/JNIDynamicLoad"

jstring getMessage(JNIEnv *env, jobject jobj) {
    LOGE("jni_dynamic_load.getMessage");
    return env->NewStringUTF("this is msg");
}

jint plus(JNIEnv *env, jobject jobj, int x, int y) {
    LOGE("jni_dynamic_load.plus");
    return x + y;
}

static JNINativeMethod gMethods[] = {
        // java方法名, 方法描述符, 对应native方法
        {"getNativeString", "()Ljava/lang/String;", (void *) getMessage},
        {"sum",             "(II)I",                (void *) plus}
};

int registerNativeMethods(JNIEnv *env, const char *name, const JNINativeMethod *methods,
                          jint nMethods) {
    jclass clazz;
    // 查找class
    clazz = env->FindClass(name);
    // 找不到返回错误
    if (clazz == nullptr) {
        return JNI_FALSE;
    }

    // 找到则注册, 成功则 = 0, 失败都是小于的返回值(即错误都是负数)
    if (env->RegisterNatives(clazz, methods, nMethods) < 0) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

// 系统加载时会回调此方法
extern "C"
JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_FALSE;
    }

    // 实现动态注册方法
    // 将函数注册到系统中
    // env->RegisterNatives()
    LOGE("注册前...");
    registerNativeMethods(env, JAVA_CLASS_NAME, gMethods, 2);
    LOGE("注册后...");
    LOGE("jni onload called");
    return JNI_VERSION_1_6;
}
