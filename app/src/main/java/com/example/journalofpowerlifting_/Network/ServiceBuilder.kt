package com.example.journalofpowerlifting_.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("tbc")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> BuildService(service: Class<T>): T
    {
        return retrofit.create(service)
    }

}