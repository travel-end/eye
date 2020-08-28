package com.journey.eyes.repository.net

import android.os.Build
import com.google.gson.GsonBuilder
import com.journey.eyes.BuildConfig
import com.journey.eyes.repository.api.ApiService
import com.journey.eyes.repository.callback.GsonTypeAdapterFactory
import com.journey.eyes.utils.AppUtils
import com.journey.eyes.utils.ext.logE
import com.journey.eyes.utils.ext.logV
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*

/**
 * @By Journey 2020/8/4
 * @Description
 */
object ApiServiceFactory {
    private const val TAG = "LoggerInterceptor"
    private const val baseUrl = BuildConfig.BASE_URL
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(LoggerInterceptor())
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(BasicParamsInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().registerTypeAdapterFactory(GsonTypeAdapterFactory()).create()))
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)


    class LoggerInterceptor:Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request  = chain.request()
            val t1 = System.nanoTime()
            logE(TAG,"request Sending: ${request.url()} \n ${request.headers()}")
            val response = chain.proceed(request)
            val t2 = System.nanoTime()
            logE(TAG, "Received response for  ${response.request().url()} in ${(t2 - t1) / 1e6} ms\n${response.headers()}")
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
                addQueryParameter("deviceModel", AppUtils.deviceModel)
                addQueryParameter("first_channel", AppUtils.deviceBrand)
                addQueryParameter("last_channel", AppUtils.deviceBrand)
                addQueryParameter("system_version_code", "${Build.VERSION.SDK_INT}")
            }.build()
            val request = originalRequest.newBuilder().url(url).method(originalRequest.method(), originalRequest.body()).build()
            return chain.proceed(request)
        }
    }
}