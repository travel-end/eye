package com.journey.eyes.base

import androidx.lifecycle.*
import com.journey.eyes.repository.MainRepository
import com.journey.eyes.repository.net.NetWorkError
import com.journey.eyes.utils.ext.logE
import com.journey.eyes.utils.showToast
import kotlinx.coroutines.*

/**
 * @By Journey 2020/8/4
 * @Description
 */

open class BaseViewModel:ViewModel() {
    protected val mainRepository by lazy {
        MainRepository()
    }



    protected fun doLaunch(
        block: Block<Unit>,
        error:Error?=null,
        cancel: Cancel?=null,
        showLoadingView:Boolean = true
    ):Job {
        return viewModelScope.launch {
            try {
                block.invoke()
            } catch (e:Exception) {
                if (e is CancellationException) {
                    cancel?.invoke(e)
                } else {
                    val errorMsg = NetWorkError.getNetWorkErrorMessage(e)
                    errorMsg.showToast()
                    logE(msg = errorMsg)
                    error?.invoke(e)
                }
            }
        }
    }

    // 并行任务执行
    protected fun <T> doAsync(block: Block<T>):Deferred<T> {
        return viewModelScope.async {
            block.invoke()
        }
    }

    // 串行任务执行
    protected suspend fun <T> doSync(block: Block<T>) {
        withContext(Dispatchers.IO) {
            block.invoke()
        }
    }


}

typealias Block<T> = suspend () ->T
typealias Error = suspend (e: Exception) -> Unit
typealias Cancel = suspend (e: Exception) -> Unit