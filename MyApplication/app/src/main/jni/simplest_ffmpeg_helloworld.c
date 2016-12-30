
#include <stdio.h>
#include <jni.h>
#include "com_android_camera_myapplication_MainActivity.h"
#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"
#include "libavfilter/avfilter.h"
#include "libavutil/avutil.h"

//Log
#ifdef ANDROID
#include <jni.h>
#include <android/log.h>
#define LOGE(format, ...)  __android_log_print(ANDROID_LOG_ERROR, "(>_<)", format, ##__VA_ARGS__)
#else
#define LOGE(format, ...)  printf("(>_<) " format "\n", ##__VA_ARGS__)
#endif

JNIEXPORT jstring JNICALL Java_com_android_camera_myapplication_MainActivity_avcodecinfo
		(JNIEnv *env, jobject jobject1){
	char info[10000] = { 0 };

	sprintf(info, "%s\n", avcodec_configuration() , avcodec_license());
	return (*env)->NewStringUTF(env, info);
}
