package com.journey.eyes.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.journey.eyes.model.BaseViewModelFactory

/**
 * @By Journey 2020/8/4
 * @Description
 */
abstract class BaseVMFragment<VM:BaseViewModel>:BaseFragment() {

    protected lateinit var mViewModel: VM
    protected lateinit var mContext: Context

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = activity!!
        initViewModel()
        initData()
        doObserver()
    }

    abstract fun viewModelClass():Class<VM>

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(viewModelClass())
//        mViewModel = ViewModelProvider(this,BaseViewModelFactory(mViewModel)).get(viewModelClass())
    }

    open fun doObserver() {

    }

    open fun initData() {

    }



}