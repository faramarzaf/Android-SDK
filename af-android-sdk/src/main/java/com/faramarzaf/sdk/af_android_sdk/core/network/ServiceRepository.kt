package com.faramarzaf.sdk.af_android_sdk.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * @author Faramarz Afzali
 * 6/july/2020
 */
class ServiceRepository {

    object ServiceBuilder {
        fun <T> buildService(baseUrl: String, apiInterface: Class<T>): T {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(apiInterface)
        }
    }
}