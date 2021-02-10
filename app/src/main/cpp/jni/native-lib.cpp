
#include <base.h>
#include <string>

#include "../people/People.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myapplication_base_JniInvoke_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";

    LOGE("hello world");

    return env->NewStringUTF(People::getString().c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myapplication_base_JniInvoke_getString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("hello world getString method");
}