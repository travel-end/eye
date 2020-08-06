package com.journey.eyes.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.journey.eyes.base.BaseViewModel

/**
 * @By Journey 2020/8/4
 * @Description
 */
class BaseViewModelFactory(private val VM:BaseViewModel):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VM as T
    }

}