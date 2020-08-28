package com.journey.eyes.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.journey.eyes.BuildConfig
import com.journey.eyes.base.BaseViewModel
import com.journey.eyes.model.core.HomePageRecommend
import com.journey.eyes.utils.ext.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @By Journey 2020/8/28
 * @Description
 */
class RecommendViewModel:BaseViewModel() {
    val recommendInfo = MutableLiveData<HomePageRecommend>()

    fun onRefresh()
    {
        doLaunch(block = {
            val result = mainRepository.getRecommend()
            logE(msg = result.toString())
            recommendInfo.value = result
        })
    }

}