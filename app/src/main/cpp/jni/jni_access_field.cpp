//
// Created by Chris on 2/12/21.
//

#include <base.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndk_jni_JniAccessField_accessStaticField(JNIEnv *env, jobject thiz,
                                                          jobject animal) {
    jclass cls = env->GetObjectClass(animal);
    jfieldID fid = env->GetFieldID(cls, "name", "Ljava/lang/String;");

    jstring name = static_cast<jstring>(env->GetObjectField(animal, fid));
    const char *bytes = env->GetStringUTFChars(name, JNI_FALSE);
    LOGE("修改前 %s", bytes);
    env->ReleaseStringUTFChars(name, bytes);

    jstring str = env->NewStringUTF("this is new name");
    const char *bytes2 = env->GetStringUTFChars(str, JNI_FALSE);
    LOGE("修改后 %s", bytes2);
    env->ReleaseStringUTFChars(str, bytes2);

    env->SetObjectField(animal, fid, str);
    return str;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_ndk_jni_JniAccessField_accessInstanceField(JNIEnv *env, jobject thiz,
                                                            jobject animal) {
    jclass cls = env->GetObjectClass(animal);
    jfieldID fid = env->GetStaticFieldID(cls, "num", "J");

    jlong num = env->GetStaticLongField(cls, fid);

    LOGE("修改前 %lld", num);

    num = num * 3;

    LOGE("修改后 %lld", num);
    env->SetStaticLongField(cls, fid, num);

    return num;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_ndk_jni_JniAccessField_staticAccessInstanceField(JNIEnv *env, jclass cls,
                                                                  jobject animal) {
    jfieldID fid = env->GetStaticFieldID(cls, "num", "J");

    jlong num = env->GetStaticLongField(cls, fid);

    LOGE("修改前 %lld", num);

    num = num * 3;

    LOGE("修改后 %lld", num);
    env->SetStaticLongField(cls, fid, num);

    return num;
}