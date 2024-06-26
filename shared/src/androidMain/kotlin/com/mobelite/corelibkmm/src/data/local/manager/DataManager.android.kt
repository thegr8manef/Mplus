package com.mobelite.corelibkmm.src.data.local.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mobelite.corelibkmm.src.models.RequestData
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

actual class DataManager actual constructor(context: Any?)  {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "CoreLib")
    }

    private val androidContext = context as? Context

    actual suspend fun saveData(key: String, value: RequestData) {
        val serializedValue = Json.encodeToString(value)
        androidContext?.dataStore?.edit { preferences ->
            preferences[stringPreferencesKey(key)] = serializedValue
        }
    }

    actual suspend fun readData(key: String): RequestData? {
        val serializedValue = androidContext?.dataStore?.data?.firstOrNull()?.get(stringPreferencesKey(key))
        return serializedValue?.let { Json.decodeFromString(it) }
    }

    actual suspend fun saveCoreLibId(key: String, value: String) {
        androidContext?.dataStore?.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    actual suspend fun readCoreLibId(key: String): String? {
        return androidContext?.dataStore?.data?.firstOrNull()?.get(stringPreferencesKey(key))
    }

    actual suspend fun saveBaseUrl(key: String, value: String) {
        androidContext?.dataStore?.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    actual suspend fun readBaseUrl(key: String): String? {
        return androidContext?.dataStore?.data?.firstOrNull()?.get(stringPreferencesKey(key))
    }

    actual suspend fun saveMpDeviceIdentifier(key: String, value: String) {
        androidContext?.dataStore?.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    actual suspend fun readMpDeviceIdentifier(key: String): String? {
        return androidContext?.dataStore?.data?.firstOrNull()?.get(stringPreferencesKey(key))
    }
}