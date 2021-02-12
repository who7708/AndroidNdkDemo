//
// Created by Chris on 2/12/21.
//

#include <base.h>

extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_ndk_jni_JniAccessMethod_accessInstanceMethod(JNIEnv *env, jobject thiz,
                                                              jobject animal) {
    // 获取实例方法
    jclass clazz = env->GetObjectClass(animal);
    jmethodID mid = env->GetMethodID(clazz, "callInstanceMethod", "(J)J");

    // 获取属性值
    jfieldID fid = env->GetStaticFieldID(clazz, "num", "J");
    jlong num = env->GetStaticLongField(clazz, fid);

    // 调用实例方法并返回结果
    jlong ret = env->CallLongMethod(animal, mid, num);
    LOGE("call java method success, %lld", num);
    return ret;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniAccessMethod_accessStaticMethod(JNIEnv *env, jobject thiz,
                                                            jobject animal) {
    // 获取静态方法
    jclass clazz = env->GetObjectClass(animal);
    jmethodID mid = env->GetStaticMethodID(clazz, "callStaticMethod",
                                           "(Ljava/lang/String;)Ljava/lang/String;");

    // 调用静态方法并返回结果
    jstring s = static_cast<jstring>(env->CallStaticObjectMethod(clazz, mid,
                                                                 env->NewStringUTF("hello world")));
    return s;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniAccessMethod_accessStaticMethod2(JNIEnv *env, jobject thiz,
                                                             jobject animal) {

    jclass clazz = env->GetObjectClass(animal);

    jmethodID mid = env->GetStaticMethodID(clazz, "callStaticMethod",
                                           "([Ljava/lang/String;J)Ljava/lang/String;");
    jclass strClass = env->FindClass("java/lang/String");

    // 获取属性值
    jfieldID fid = env->GetStaticFieldID(clazz, "num", "J");
    jlong num = env->GetStaticLongField(clazz, fid);

    jobjectArray strArray = env->NewObjectArray(num, strClass, nullptr);

    jstring strItem;
    for (int i = 0; i < num; ++i) {
        strItem = env->NewStringUTF("string in jni");
        env->SetObjectArrayElement(strArray, i, strItem);
    }

    return reinterpret_cast<jstring>(env->CallStaticObjectMethod(clazz, mid, strArray, num));
}