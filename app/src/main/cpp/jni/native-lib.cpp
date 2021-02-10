
#include <base.h>
#include <string>

#include "people/People.h"

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    LOGE("hello world");

    return env->NewStringUTF(People::getString().c_str());
}

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_example_myapplication_MainActivity_getString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("hello world getString method");
}
