package com.example.repository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object Api {

    private const val BASE_URL = "https://data.taipei/opendata/datalist/"

    fun getApiService(): ApiInterface {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.getClient())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}