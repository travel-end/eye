package com.journey.eyes.utils

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.provider.Settings
import android.text.TextUtils
import com.journey.eyes.EyeApplication
import com.journey.eyes.utils.ext.logW
import java.util.*

/**
 * @By Journey 2020/8/4
 * @Description
 */
object AppUtils {
    private var deviceSerial: String? = null

    val appPackage: String
        get() = EyeApplication.instance.packageName

    val eyeVersionCode: Long
        get() = 6030012

    val eyeVersionName: String
        get() = "6.3.01"

    fun getScreenPixel():String {
        EyeApplication.instance.resources.displayMetrics.run {
            return "${widthPixels}X${heightPixels}"
        }
    }

    @SuppressLint("HardwareIds")
    fun getDeviceSerial(): String {
        if (deviceSerial == null) {
            var deviceId: String? = null
            val appChannel = getApplicationMetaData("APP_CHANNEL")
            if ("google" != appChannel || "samsung" != appChannel) {
                try {
                    deviceId = Settings.Secure.getString(EyeApplication.instance.contentResolver, Settings.Secure.ANDROID_ID)
                } catch (e: Exception) {
                    logW(msg = "get android_id with error", tr = e)
                }
                if (!TextUtils.isEmpty(deviceId) && deviceId!!.length < 255) {
                    deviceSerial = deviceId
                    return deviceSerial.toString()
                }
            }
            var uuid = sharedPreferences.getString("uuid", "")
            if (!TextUtils.isEmpty(uuid)) {
                deviceSerial = uuid
                return deviceSerial.toString()
            }
            uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.getDefault())

            sharedPreferences.edit {
                putString("uuid", uuid)
            }

            deviceSerial = uuid
            return deviceSerial.toString()
        } else {
            return deviceSerial.toString()
        }
    }

    private fun getApplicationMetaData(key: String): String? {
        var applicationInfo: ApplicationInfo? = null
        try {
            applicationInfo = EyeApplication.instance.packageManager.getApplicationInfo(appPackage, PackageManager.GET_META_DATA)
        } catch (e: PackageManager.NameNotFoundException) {
            logW(msg = e.message, tr = e)
        }
        if (applicationInfo == null) return ""
        return applicationInfo.metaData.getString(key)
    }
}