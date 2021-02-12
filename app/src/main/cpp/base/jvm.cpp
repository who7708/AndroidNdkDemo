//
// Created by Chris on 2/12/21.
//

#include "jvm.h"

static JavaVM *gVM = nullptr;

#ifdef __cplusplus
extern "C" {
#endif

void setJvm(JavaVM *jvm) {
    gVM = jvm;
}

JavaVM *getJvm() {
    return gVM;
}

#ifdef __cplusplus
};
#endif
