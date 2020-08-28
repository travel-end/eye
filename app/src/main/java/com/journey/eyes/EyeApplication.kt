package com.journey.eyes

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.journey.eyes.widget.NoStatusFooter
import com.scwang.smart.refresh.header.MaterialHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout

/**
 * @By Journey 2020/8/4
 * @Description
 */
class EyeApplication:Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    init {

        SmartRefreshLayout.setDefaultRefreshInitializer { context, layout ->
            layout.setEnableLoadMore(true)
            layout.setEnableLoadMoreWhenContentNotFull(true)
        }

        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setEnableHeaderTranslationContent(true)
            MaterialHeader(context).setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary)
        }

        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            layout.setEnableFooterFollowWhenNoMoreData(true)
            layout.setEnableFooterTranslationContent(true)
            layout.setFooterHeight(153f)
            layout.setFooterTriggerRate(0.6f)
            NoStatusFooter.REFRESH_FOOTER_NOTHING = "- The End -"
            NoStatusFooter(context).apply {
                setAccentColorId(R.color.colorTextPrimary)
                setTextTitleSize(16f)
            }
        }
    }
    companion object {
        lateinit var instance:Context
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}