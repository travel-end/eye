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

package com.journey.eyes.repository.net

import com.google.gson.JsonSyntaxException
import com.journey.eyes.R
import com.journey.eyes.utils.ext.logE
import com.journey.eyes.utils.getString
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 获取网络请求返回的异常信息。
 *
 * @author vipyinzhiwei
 * @since  2020/5/29
 */
object NetWorkError {

    private const val TAG = "NetWorkError"

    /**
     * 当网络请求没有正常响应的时候，根据异常类型进行相应的处理。
     * @param e 异常实体类
     */
    fun getNetWorkErrorMessage(e: Throwable?): String {
        logE(TAG, "NetWorkError Message is: ${e?.message}")
        return when (e) {
            is ConnectException -> R.string.network_connect_error.getString()
            is SocketTimeoutException -> R.string.network_connect_timeout.getString()
            is ResponseCodeException ->  "${e.responseCode},${R.string.network_response_code_error.getString()}"
            is NoRouteToHostException ->R.string.no_route_to_host.getString()
            is UnknownHostException -> R.string.network_error.getString()
            is JsonSyntaxException -> R.string.json_data_error.getString()
            else -> {
                R.string.unknown_error.getString()
            }
        }
    }
}