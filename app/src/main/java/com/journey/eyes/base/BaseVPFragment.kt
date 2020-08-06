package com.journey.eyes.base

import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.journey.eyes.utils.setOnClickListeners
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_title_bar.*

/**
 * @By Journey 2020/8/4
 * @Description
 */
abstract class BaseVPFragment:BaseFragment() {

    abstract val initVpFragments:Array<Fragment>
    abstract val initVpTitles:ArrayList<CustomTabEntity>
    private var mPageChangeCallback:PageChangeCallback?=null
    protected lateinit var mViewPager: ViewPager2
    protected lateinit var mIvCalendar:ImageView
    protected lateinit var mIvSearch:ImageView

    private val vpAdapter:VpAdapter by lazy {
        VpAdapter(activity!!).apply {
            addFragment(initVpFragments)
        }
    }

    override fun initView() {
        mViewPager = home_viewPager
        mIvCalendar = ivCalendar
        mIvSearch = ivSearch
        mViewPager.run {
            offscreenPageLimit = 1
            adapter = vpAdapter
        }
        title_tabLayout.run {
            setTabData(initVpTitles)
            setOnTabSelectListener(object :OnTabSelectListener{
                override fun onTabSelect(position: Int) {
                    mViewPager.currentItem = position
                }

                override fun onTabReselect(position: Int) {
                }
            })
        }
        mPageChangeCallback = PageChangeCallback()
        mViewPager.registerOnPageChangeCallback(mPageChangeCallback!!)

    }
    override fun initAction() {
        setOnClickListeners(mIvCalendar,mIvSearch) {
            when(this) {
                ivCalendar->{

                }
                ivSearch->{

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPageChangeCallback?.let {
            mViewPager.unregisterOnPageChangeCallback(it)
        }
        mPageChangeCallback=null
    }

    inner class VpAdapter(act:FragmentActivity):FragmentStateAdapter(act) {
        private val fragments = mutableListOf<Fragment>()
        fun addFragment(frg:Array<Fragment>) {
            fragments.addAll(frg)
        }
        override fun getItemCount()=fragments.size
        override fun createFragment(position: Int)=fragments[position]
    }

    inner class PageChangeCallback:ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            title_tabLayout.currentTab = position
        }
    }
}