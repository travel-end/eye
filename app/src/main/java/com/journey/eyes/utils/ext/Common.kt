package com.journey.eyes.utils.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @By Journey 2020/8/28
 * @Description
 */
fun Int.inflate(parent:ViewGroup,attachToRoot:Boolean = false):View {
    return LayoutInflater.from(parent.context).inflate(this,parent,attachToRoot)
}

/**
 * 获取转换后的时间样式。
 *
 * @return 处理后的时间样式，示例：06:50
 */
fun Int.conversionVideoDuration(): String {
    val minute = 1 * 60
    val hour = 60 * minute
    val day = 24 * hour

    return when {
        this < day -> {
            String.format("%02d:%02d", this / minute, this % 60)
        }
        else -> {
            String.format("%02d:%02d:%02d", this / hour, (this % hour) / minute, this % 60)
        }
    }
}


