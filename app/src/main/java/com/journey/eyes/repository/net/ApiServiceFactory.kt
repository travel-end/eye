package com.journey.eyes.repository.net

import android.os.Build
import com.journey.eyes.utils.AppUtils
import com.journey.eyes.utils.ext.logV
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

/**
 * @By Journey 2020/8/4
 * @Description
 */
object ApiServiceFactory {
    const val TAG = "LoggerInterceptor"
    class LoggerInterceptor:Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request  = chain.request()
            val t1 = System.nanoTime()
            logV(TAG,"request Sending: ${request.url()} \n ${request.headers()}")
            val response = chain.proceed(request)
            val t2 = System.nanoTime()
            logV(TAG, "Received response for  ${response.request().url()} in ${(t2 - t1) / 1e6} ms\n${response.headers()}")
            return response
        }
    }
    class HeaderInterceptor:Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val request = original.newBuilder().apply {
                header("model", "Android")
                header("If-Modified-Since", "${Date()}")
                header("User-Agent", System.getProperty("http.agent") ?: "unknown")
            }.build()
            return chain.proceed(request)
        }
    }
    class BasicParamsInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url()
            val url = originalHttpUrl.newBuilder().apply {
                addQueryParameter("udid", AppUtils.getDeviceSerial())
                addQueryParameter("vc", AppUtils.eyeVersionCode.toString())
                addQueryParameter("vn", AppUtils.eyeVersionName)
                addQueryParameter("size", AppUtils.getScreenPixel())
//                addQueryParameter("deviceModel", GlobalUtil.deviceModel)
//                addQueryParameter("first_channel", GlobalUtil.deviceBrand)
//                addQueryParameter("last_channel", GlobalUtil.deviceBrand)
                addQueryParameter("system_version_code", "${Build.VERSION.SDK_INT}")
            }.build()
            val request = originalRequest.newBuilder().url(url).method(originalRequest.method(), originalRequest.body()).build()
            return chain.proceed(request)
        }
    }
}