/*
 * Copyright (C) guolin, Suzhou Quxiang Inc. Open source codes for study only.
 * Do not use for commercial purpose.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.journey.eyes.utils.ext

import com.journey.eyes.EyeApplication


/**
 * 根据手机的分辨率将dp转成为px。
 */
fun Float.dp2px(): Int {
    val scale = EyeApplication.instance.resources.displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

/**
 * 根据手机的分辨率将px转成dp。
 */
fun Float.px2dp(): Int {
    val scale = EyeApplication.instance.resources.displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

/**
 * 获取屏幕宽值。
 */
val screenWidth
    get() = EyeApplication.instance.resources.displayMetrics.widthPixels

/**
 * 获取屏幕高值。
 */
val screenHeight
    get() = EyeApplication.instance.resources.displayMetrics.heightPixels

/**
 * 获取屏幕像素：对获取的宽高进行拼接。例：1080X2340。
 */
fun screenPixel(): String {
    EyeApplication.instance.resources.displayMetrics.run {
        return "${widthPixels}X${heightPixels}"
    }
}
