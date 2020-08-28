package com.journey.eyes.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.journey.eyes.EyeApplication

/**
 * @By Journey 2020/8/4
 * @Description
 */

val sharedPreferences: SharedPreferences = EyeApplication.instance.getSharedPreferences(AppUtils.appPackage + "_preferences", Context.MODE_PRIVATE)

fun setOnClickListeners(vararg v: View, block: View.() -> Unit) {
    val listener = View.OnClickListener { it.block() }
    v.forEach {
        it.setOnClickListener(listener)
    }
}

fun Int.getString() = EyeApplication.instance.resources.getString(this)

fun String.showToast(): Toast {
    val toast = Toast.makeText(EyeApplication.instance, this, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    return toast
}


