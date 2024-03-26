package com.mobelite.corelibkmm.src.managers

import android.os.Build

import java.util.TimeZone

class AndroidDeviceInfo: DeviceInfo {

    override val deviceModel: String = Build.MODEL
    override val sysName: String = "Android"
    override val osVersion: String = Build.VERSION.RELEASE
    override val deviceIdentifierForVendor: String
        get() = TODO("Not yet implemented")
    override val deviceRegion: String = "This should be changed"
        //context.resources.configuration.locale.country ?: "N/A"

    override val timeZone: String = TimeZone.getDefault().id

    override val screenDpi: String
        get() = TODO("Not yet implemented")
    override val osName: String
        get() = TODO("Not yet implemented")
    override val timestamp: Long = 432423 //TODO change this
    override val appIdentifier: String
        get() = TODO("Not yet implemented")
    override val appVersion: String
        get() = TODO("Not yet implemented")
    override val deviceManufacturer: String = Build.MANUFACTURER

}

actual fun getDeviceInfo(): DeviceInfo = AndroidDeviceInfo()