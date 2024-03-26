package com.mobelite.corelibkmm.src.data.local.manager

import com.mobelite.corelibkmm.src.models.RequestData

// DataManager class acts as a bridge between the application's business logic and the local data storage.
// It provides methods to save and read data using a DataStoreManager instance.
expect class DataManager (context : Any?) {

    //Saves the provided data with the given key into the local data storage.
    suspend fun saveData(key: String, value: RequestData)

    //Reads data from the local data storage corresponding to the given key
    suspend fun readData(key: String): RequestData?

    suspend fun saveCoreLibId(key: String, value: String)
    suspend fun readCoreLibId(key: String): String?

    suspend fun saveBaseUrl(key: String, value: String)
    suspend fun readBaseUrl(key: String): String?

    suspend fun saveMpDeviceIdentifier(key: String, value: String)
    suspend fun readMpDeviceIdentifier(key: String): String?
}