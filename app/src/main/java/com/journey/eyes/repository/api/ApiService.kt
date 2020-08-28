package com.journey.eyes.repository.api

import com.journey.eyes.model.core.Discovery
import com.journey.eyes.model.core.HomePageRecommend
import retrofit2.Call
import retrofit2.http.GET

/**
 * @By Journey 2020/8/4
 * @Description
 */
interface ApiService {

    @GET("api/v7/index/tab/discovery")
    suspend fun getFind(): Call<Discovery>

    // http://baobab.kaiyanapp.com/api/v7/community/tab/rec
    @GET("api/v5/index/tab/allRec?page=0")
    fun getRecommend(): Call<HomePageRecommend>
}