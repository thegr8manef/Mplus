package com.mobelite.corelibkmm

import com.mobelite.corelibkmm.src.managers.DeviceInfo
import com.mobelite.corelibkmm.src.managers.getDeviceInfo

class Greeting {

    private val deviceModel: DeviceInfo = getDeviceInfo()

    fun greet(): String {
        return "Hello \n model: ${deviceModel.deviceModel}\n systName: ${deviceModel.sysName}\n systVersion(OS Vers): ${deviceModel.osVersion}\n deviceRegion: ${deviceModel.deviceRegion}\n timezone: ${deviceModel.timeZone}\n screenDpi: ${deviceModel.screenDpi} \n" +
                " osName: ${deviceModel.osName} \n timestamp: ${deviceModel.timestamp} \n" +
                " app identifier:  ${deviceModel.appIdentifier} \n appVersion: ${deviceModel.appVersion}" +
                "\n" +
                " deviceManufacturer: ${deviceModel.deviceManufacturer}"
    }
}

