/* DO NOT EDIT THIS FILE - it is machine generated */
#include <base.h>
/* Header for class com_example_ndk_jni_JniWaitNotify */

#include <pthread.h>
#include <queue>
#include <unistd.h>

#ifndef _Included_com_example_ndk_jni_JniWaitNotify
#define _Included_com_example_ndk_jni_JniWaitNotify
#ifdef __cplusplus
extern "C" {
#endif

// 互斥锁
pthread_mutex_t mutex;
// 条件
pthread_cond_t cond;

pthread_t waitHandle;
pthread_t notifyHandle;

int count = 0;
int flag = 0;
void *waitThread(void *) {
    pthread_mutex_lock(&mutex);
    LOGI("wait thread lock...%d", count);

    count++;

    LOGI("waitThread mutex %p, cond %p", &mutex, &cond);
    while (flag == 0) {
        LOGI("waiting...%d", count);
        // sleep(3);
        pthread_cond_wait(&cond, &mutex);
    }
    LOGI("wait thread unlock...%d", count);
    pthread_mutex_unlock(&mutex);
    pthread_exit(0);
}

void *notifyThread(void *) {
    pthread_mutex_lock(&mutex);
    LOGE("notify thread lock...%d", count);

    flag = 1;

    pthread_mutex_unlock(&mutex);

    pthread_cond_signal(&cond);
    LOGE("signal...%d", count);
    LOGE("notify thread unlock...%d", count);
    count--;
    LOGE("notifyThread mutex %p, cond %p", &mutex, &cond);
    // 正常退出
    pthread_exit(0);
}

/*
 * Class:     com_example_ndk_jni_JniWaitNotify
 * Method:    waitNativeThread
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_ndk_jni_JniWaitNotify_waitNativeThread
        (JNIEnv *env, jobject clazz) {
    pthread_mutex_init(&mutex, nullptr);

    pthread_cond_init(&cond, nullptr);

    pthread_create(&waitHandle, nullptr, waitThread, nullptr);
    return env->NewStringUTF("wait native thread...");
}

/*
 * Class:     com_example_ndk_jni_JniWaitNotify
 * Method:    notifyNativeThread
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_ndk_jni_JniWaitNotify_notifyNativeThread
        (JNIEnv *env, jobject clazz) {
    pthread_create(&notifyHandle, nullptr, notifyThread, nullptr);
    return env->NewStringUTF("notify native thread...");
}

#ifdef __cplusplus
}
#endif
#endif
