//
// Created by Chris on 2/10/21.
//

#ifndef MY_APPLICATION_BASE_H
#define MY_APPLICATION_BASE_H

#include <android/log.h>
#include <jni.h>
#include <jvm.h>

#ifndef LOG_TAG
//Log 的 tag 名字
#define LOG_TAG "JNI_LOG"
// 定义各种类型 Log 的函数别名
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG ,__VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG ,__VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG ,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG ,__VA_ARGS__)
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,LOG_TAG ,__VA_ARGS__)
#endif

#endif //MY_APPLICATION_BASE_H
