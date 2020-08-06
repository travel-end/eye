package com.journey.eyes.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.journey.eyes.model.BaseViewModelFactory

/**
 * @By Journey 2020/8/4
 * @Description
 */
abstract class BaseVMFragment<VM:BaseViewModel>:BaseFragment() {

    protected lateinit var mViewModel: VM

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    abstract fun viewModelClass():Class<VM>

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this,BaseViewModelFactory(mViewModel)).get(viewModelClass())
    }

}