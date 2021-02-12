//
// Created by Chris on 2/11/21.
//

#include <base.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniString_callNativeString(JNIEnv *env, jobject thiz, jstring jstr) {
    const char *str = env->GetStringUTFChars(jstr, JNI_FALSE);
    LOGE("java string is %s", str);
    env->ReleaseStringUTFChars(jstr, str);
    return env->NewStringUTF("我是被修改过的字符串");
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniString_stringMethod(JNIEnv *env, jobject thiz, jstring jstr) {
    // jstr = 中文, GetStringLength * 3 = GetStringUTFLength = 6
    // jstr = en, GetStringLength = GetStringUTFLength = 2

    // hello world
    const char *str = env->GetStringUTFChars(jstr, JNI_FALSE);
    LOGE("java string is %s", str);

    char buf[128];
    // len = 11
    // 获取java string 的长度
    int len = env->GetStringLength(jstr);
    LOGE("java string lenthg is %d", len);

    // clang 复制
    // strcpy(buffer, str);
    env->GetStringUTFRegion(jstr, 0, len - 1, buf);
    LOGE("j string is %s", buf);

    env->ReleaseStringUTFChars(jstr, str);

    return env->NewStringUTF(buf);
}