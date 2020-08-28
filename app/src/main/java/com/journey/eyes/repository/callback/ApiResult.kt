package com.journey.eyes.repository.callback

import com.journey.eyes.repository.net.ResponseCodeException

data class ApiResult<T>(val errorCode: Int, val errorMessage: String, private val data: T) {
    fun apiData(): T {
        if (errorCode == 0) {
            return data
        } else {
            throw ResponseCodeException(errorCode)
        }
    }
}
