package com.journey.eyes.ui

import com.journey.eyes.R
import com.journey.eyes.base.BaseFragment

/**
 * @By Journey 2020/8/4
 * @Description
 */
class RecommendFragment:BaseFragment() {
    override fun layoutRes()= R.layout.fragment_recommend
    companion object {
        fun newInstance() = RecommendFragment()
    }
}