//
// Created by Chris on 2/12/21.
//

#include <base.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniReferenceType_callNativeStringArray(JNIEnv *env, jobject thiz,
                                                                jobjectArray str_array) {
    int len = env->GetArrayLength(str_array);
    LOGE("java array length is %d", len);

    // 获取首个元素
    jstring firstStr = static_cast<jstring>(env->GetObjectArrayElement(str_array, 0));

    // env->GetIntArrayElements()

    const char *str = env->GetStringUTFChars(firstStr, JNI_FALSE);
    LOGE("first str is %s", str);
    env->ReleaseStringUTFChars(firstStr, str);

    return env->NewStringUTF(str);
}