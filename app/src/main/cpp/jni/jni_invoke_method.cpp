//
// Created by Chris on 2/12/21.
//
#include <base.h>
#include <pthread.h>

#include <jvm.h>

void *threadCallback(void *);

static jclass threadClazz;
static jmethodID threadMethod;
static jobject threadObject;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_ndk_jni_JniInvokeMethod_nativeCallback(JNIEnv *env, jobject thiz,
                                                        jobject callback_method) {
    LOGE("native call back...");
    jclass callbackClazz = env->GetObjectClass(callback_method);

    jmethodID callbackMethod = env->GetMethodID(callbackClazz, "callback", "()V");

    env->CallVoidMethod(callback_method, callbackMethod);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_ndk_jni_JniInvokeMethod_nativeThreadCallback(JNIEnv *env, jobject thiz,
                                                              jobject thread_callback) {
    LOGE("native thread call back...");

    threadObject = env->NewGlobalRef(thread_callback);

    threadClazz = env->GetObjectClass(thread_callback);

    threadMethod = env->GetMethodID(threadClazz, "callback", "()V");

    // 创建线程
    pthread_t handle;

    pthread_create(&handle, nullptr, threadCallback, nullptr);
}

// 系统加载时会回调此方法
extern "C"
JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGE("JNI_OnLoad before");
    setJvm(vm);
    LOGE("JNI_OnLoad after");
    return JNI_VERSION_1_6;
}

void *threadCallback(void *) {
    JavaVM *gVM = getJvm();
    JNIEnv *env = nullptr;
    if (gVM->AttachCurrentThread(&env, nullptr) == 0) {

        env->CallVoidMethod(threadObject, threadMethod);

        gVM->DetachCurrentThread();
    }

    return JNI_FALSE;
}