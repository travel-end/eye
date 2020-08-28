package com.journey.eyes.repository

import com.journey.eyes.repository.net.ApiServiceFactory
import retrofit2.await

/**
 * @By Journey 2020/8/4
 * @Description
 */
class MainRepository {

    private val mainService = ApiServiceFactory.apiService

    suspend fun getRecommend() = mainService.getRecommend().await()


}