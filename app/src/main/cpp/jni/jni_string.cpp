//
// Created by Chris on 2/11/21.
//

#include <base.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniString_callNativeString(JNIEnv *env, jobject thiz, jstring _str) {
    const char *str = env->GetStringUTFChars(_str, JNI_FALSE);
    LOGE("java string is %s", str);
    env->ReleaseStringUTFChars(_str, str);
    return env->NewStringUTF("我是被修改过的字符串");
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_ndk_jni_JniString_stringMethod(JNIEnv *env, jobject thiz, jstring _str) {
    const char *str = env->GetStringUTFChars(_str, JNI_FALSE);
    LOGE("java string is %s", str);

    env->ReleaseStringUTFChars(_str, str);

}