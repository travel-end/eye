package com.journey.eyes.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @By Journey 2020/8/4
 * @Description
 */
abstract class BaseFragment:Fragment() {
    private var dataLoaded :Boolean  = false

    open fun layoutRes()=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes(),container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initAction()
    }
    open fun initView() {

    }
    open fun initAction() {


    }

    override fun onResume() {
        super.onResume()
        if (!dataLoaded) {
            onLazyLoad()
            dataLoaded = true
        }
    }

    open fun onLazyLoad() {

    }

}