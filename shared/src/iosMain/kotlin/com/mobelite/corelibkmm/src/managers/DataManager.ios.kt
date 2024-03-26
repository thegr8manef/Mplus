package com.mobelite.corelibkmm.src.managers

 import platform.Foundation.NSBundle
 import platform.Foundation.NSDate
 import platform.Foundation.NSLocale
import platform.Foundation.NSTimeZone
import platform.Foundation.currentLocale
import platform.Foundation.localTimeZone
 import platform.Foundation.timeIntervalSince1970
 import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

class IOSDeviceInfo: DeviceInfo {
    override val deviceModel: String = UIDevice.currentDevice.model
    override val sysName: String = UIDevice.currentDevice.systemName
    override val osVersion: String = UIDevice.currentDevice.systemVersion
    override val deviceIdentifierForVendor: String = UIDevice.currentDevice.identifierForVendor.toString()
    override val deviceRegion: String = NSLocale.currentLocale.objectForKey("kCFLocaleCountryCode")?.toString() ?: ""
    override val timeZone: String = NSTimeZone.localTimeZone.name
    override val screenDpi: String = (UIScreen.mainScreen.scale.toFloat() * 160.0f).toString()
    override val osName: String = UIDevice.currentDevice.systemName()
    override val timestamp: Long = NSDate().timeIntervalSince1970.toLong()
    override val appIdentifier: String = NSBundle.mainBundle.bundleIdentifier.toString()
    override val appVersion: String = NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleShortVersionString")?.toString() ?: ""
    override val deviceManufacturer: String = "Apple"
}

actual fun getDeviceInfo(): DeviceInfo = IOSDeviceInfo()

