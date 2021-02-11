//
// Created by Chris on 2/11/21.
//

#include <base.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniString_callNativeString(JNIEnv *env, jobject thiz, jstring str) {
    // TODO: implement callNativeString()
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_ndk_jni_JniString_stringMethod(JNIEnv *env, jobject thiz, jstring str) {
    // TODO: implement stringMethod()
}