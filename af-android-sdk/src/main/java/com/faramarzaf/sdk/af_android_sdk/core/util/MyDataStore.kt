package com.faramarzaf.sdk.af_android_sdk.core.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.clear

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey

import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first

/**
 * @author Faramarz Afzali
 * 31/jan/2021
 */

class MyDataStore(context: Context) {

    private val DATA_STORE_NAME: String = "mydatastore"
    private var dataStore: DataStore<Preferences>

    init {
        dataStore = context.createDataStore(DATA_STORE_NAME)

    }

    suspend fun writeString(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun writeBoolean(key: String, value: Boolean) {
        val dataStoreKey = preferencesKey<Boolean>(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun writeInteger(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun writeFloat(key: String, value: Float) {
        val dataStoreKey = preferencesKey<Float>(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun writeLong(key: String, value: Long) {
        val dataStoreKey = preferencesKey<Long>(key)
        dataStore.edit {
            it[dataStoreKey] = value
        }
    }

    suspend fun readString(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun readInteger(key: String): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun readFloat(key: String): Float? {
        val dataStoreKey = preferencesKey<Float>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun readLong(key: String): Long? {
        val dataStoreKey = preferencesKey<Long>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun readBoolean(key: String): Boolean? {
        val dataStoreKey = preferencesKey<Boolean>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun clearAll() {
        dataStore.edit {
            it.clear()
        }
    }

}