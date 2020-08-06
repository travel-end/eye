package com.journey.eyes

import android.view.View
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.journey.eyes.base.BaseVPFragment
import com.journey.eyes.model.TabEntity
import com.journey.eyes.ui.DailyFragment
import com.journey.eyes.ui.FindFragment
import com.journey.eyes.ui.RecommendFragment
import com.journey.eyes.utils.getString

/**
 * @By Journey 2020/8/4
 * @Description
 */
class HomeFragment:BaseVPFragment() {
    companion object {
        fun newInstance() =HomeFragment()
    }

    override val initVpFragments: Array<Fragment>
        get() = arrayOf(FindFragment.newInstance(),RecommendFragment.newInstance(),DailyFragment.newInstance())
    override val initVpTitles=ArrayList<CustomTabEntity>().apply {
        add(TabEntity(R.string.discovery.getString()))
        add(TabEntity(R.string.commend.getString()))
        add(TabEntity(R.string.daily.getString()))
    }
    override fun layoutRes()=R.layout.fragment_home
    override fun initView() {
        super.initView()
        mIvCalendar.visibility = View.VISIBLE
        mViewPager.currentItem = 1
    }


}