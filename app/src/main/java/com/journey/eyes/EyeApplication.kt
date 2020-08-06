package com.journey.eyes

import android.app.Application
import android.content.Context

/**
 * @By Journey 2020/8/4
 * @Description
 */
class EyeApplication:Application() {
    companion object {
        lateinit var instance:Context
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}