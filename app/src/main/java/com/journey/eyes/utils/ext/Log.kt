/*
 * Copyright (c) 2020. vipyinzhiwei <vipyinzhiwei@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.journey.eyes.utils.ext

import android.util.Log
import com.journey.eyes.BuildConfig

private const val VERBOSE = 1
private const val DEBUG = 2
private const val INFO = 3
private const val WARN = 4
private const val ERROR = 5

private val level = if (BuildConfig.DEBUG) VERBOSE else WARN

private const val TAG = "Journey"

fun logV(tag: String= TAG, msg: String?) {
    if (level <= VERBOSE) {
        Log.v(tag, msg.toString())
    }
}

fun logD(tag: String= TAG, msg: String?) {
    if (level <= DEBUG) {
        Log.d(tag, msg.toString())
    }
}

fun logI(tag: String= TAG, msg: String?) {
    if (level <= INFO) {
        Log.i(tag, msg.toString())
    }
}

fun logW(tag: String= TAG, msg: String?, tr: Throwable? = null) {
    if (level <= WARN) {
        if (tr == null) {
            Log.w(tag, msg.toString())
        } else {
            Log.w(tag, msg.toString(), tr)
        }
    }
}

fun logE(tag: String= TAG, msg: String?, tr: Throwable) {
    if (level <= ERROR) {
        Log.e(tag, msg.toString(), tr)
    }
}

