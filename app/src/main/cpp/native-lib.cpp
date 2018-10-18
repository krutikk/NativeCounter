#include <jni.h>
#include <string>



static long count(jlong n){

    jlong result = n+1;

    return result;

}
extern "C"
JNIEXPORT jlong JNICALL
Java_com_rakuten_myapplication_MainActivity_getCounter(JNIEnv *env, jclass type, jlong n) {

    return  count(n);
}