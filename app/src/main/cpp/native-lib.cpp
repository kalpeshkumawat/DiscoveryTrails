//
// Created by admin on 7/22/2019.
//

#include <jni.h>

extern "C" {
    JNIEXPORT jstring JNICALL
    Java_com_app_discoverytrails_MainActivity_invokeNativeFunction(JNIEnv *env, jobject instance) {
        return env->NewStringUTF("V293ISBob3cgY3VyaW91cyBlaD8=");
    }
}