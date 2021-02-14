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

using namespace std;
std::queue<int> data;
pthread_mutex_t dataMutex;
pthread_cond_t dataCond;

void *productThread(void *) {

    while (data.size() < 10) {
        pthread_mutex_lock(&dataMutex);
        LOGE("生产物品...");
        data.push(1);

        if (!data.empty()) {
            LOGE("等待消费...");
            pthread_cond_signal(&dataCond);
        }
        pthread_mutex_unlock(&dataMutex);
        sleep(3);
    }

    pthread_exit(0);
}

void *consumerThread(void *) {

    while (1 == 1) {
        pthread_mutex_lock(&dataMutex);

        if (data.size() > 0) {
            LOGE("消费物品...");
            data.pop();
        } else {
            LOGE("等待生产...");
            pthread_cond_wait(&dataCond, &dataMutex);
        }
        pthread_mutex_unlock(&dataMutex);
    }
    pthread_exit(0);
}

/*
 * Class:     com_example_ndk_jni_JniWaitNotify
 * Method:    startProductAndConsumerThread
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_ndk_jni_JniWaitNotify_startProductAndConsumerThread
        (JNIEnv *env, jobject clazz) {
    pthread_mutex_init(&dataMutex, nullptr);

    pthread_cond_init(&dataCond, nullptr);

    pthread_t productHandle;
    pthread_t consumerHandle;

    pthread_create(&productHandle, nullptr, productThread, nullptr);
    pthread_create(&consumerHandle, nullptr, consumerThread, nullptr);
    return env->NewStringUTF("product and consumer thread start...");
}

#ifdef __cplusplus
}
#endif
#endif
