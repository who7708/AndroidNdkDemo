//
// Created by Chris on 2/12/21.
//

#include <base.h>

#ifndef NDK_DEMO_JVM_H
#define NDK_DEMO_JVM_H

#ifdef __cplusplus
extern "C" {
#endif

void setJvm(JavaVM *jvm);

JavaVM *getJvm();

#ifdef __cplusplus
};
#endif

#endif //NDK_DEMO_JVM_H
