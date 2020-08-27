package com.journey.eyes.repository.api

import com.journey.eyes.model.commend.CommunityRecommend
import com.journey.eyes.model.find.FindModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * @By Journey 2020/8/4
 * @Description
 */
interface ApiService {

    @GET("api/v7/index/tab/discovery")
    fun getFind() :Call<FindModel>

    @GET("api/v7/community/tab/rec")
    fun getRecommend():Call<CommunityRecommend>
}