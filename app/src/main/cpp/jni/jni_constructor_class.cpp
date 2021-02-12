//
// Created by Chris on 2/13/21.
//

#include <base.h>

extern "C"
JNIEXPORT jobject JNICALL
Java_com_example_ndk_jni_JniConstructorClass_invokeAnimalConstructors(JNIEnv *env, jobject thiz) {
    jclass clazz = env->FindClass("com/example/ndk/domain/Animal");

    jmethodID mid = env->GetMethodID(clazz, "<init>", "(Ljava/lang/String;)V");

    jstring str = env->NewStringUTF("Dog");
    jobject animal = env->NewObject(clazz, mid, str);
    return animal;
}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_example_ndk_jni_JniConstructorClass_allocObjectConstructor(JNIEnv *env, jobject thiz) {
    jclass clazz = env->FindClass("com/example/ndk/domain/Animal");

    jmethodID mid = env->GetMethodID(clazz, "<init>", "(Ljava/lang/String;)V");

    jobject animal = env->AllocObject(clazz);
    jstring str = env->NewStringUTF("Cat");
    env->CallNonvirtualVoidMethod(animal, clazz, mid, str);

    return animal;
}
