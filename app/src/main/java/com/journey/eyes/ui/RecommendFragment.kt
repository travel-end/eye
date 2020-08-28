package com.journey.eyes.ui

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.journey.eyes.R
import com.journey.eyes.base.BaseVMFragment
import com.journey.eyes.model.core.HomePageRecommend
import com.journey.eyes.ui.adapter.holder.AppAdapter
import com.journey.eyes.utils.ext.logD
import com.journey.eyes.utils.ext.logE
import com.scwang.smart.refresh.layout.constant.RefreshState
import kotlinx.android.synthetic.main.fragment_recommend.*

/**
 * @By Journey 2020/8/4
 * @Description
 */
class RecommendFragment:BaseVMFragment<RecommendViewModel>() {
    private val dataList:MutableList<HomePageRecommend.Item> = mutableListOf()
    private lateinit var mAdapter:AppAdapter
    override fun layoutRes()= R.layout.fragment_recommend
    companion object {
        fun newInstance() = RecommendFragment()
    }

    override fun viewModelClass()=RecommendViewModel::class.java
    override fun onLazyLoad() {
        super.onLazyLoad()
        mViewModel.onRefresh()
    }

    override fun initData() {
        super.initData()
        mAdapter = AppAdapter(mContext)
        val lm = LinearLayoutManager(mContext)
        recommend_rv.layoutManager = lm
        recommend_rv.setHasFixedSize(true)
    }

    override fun doObserver() {
        super.doObserver()
        mViewModel.recommendInfo.observe(viewLifecycleOwner, Observer {
            it?.let {
                logE(msg = "nextPageUrl:${it.nextPageUrl}")
                logD(msg = "refresh state:${recommend_refresh_layout.state}")
                when(recommend_refresh_layout.state) {
                    RefreshState.None, RefreshState.Refreshing -> {
                        dataList.clear()
//                        val itemList = it.itemList
//                        itemList.forEach {item->
//                            logE(msg = "item:${item.data.text}")
//                        }
                        dataList.addAll(it.itemList)
                        mAdapter.setData(dataList)
                        recommend_rv.adapter = mAdapter
                    }
                    RefreshState.Loading -> {
                    }
                    else->{

                    }
                }
            }
        })
    }

}