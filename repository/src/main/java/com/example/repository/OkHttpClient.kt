package com.example.repository

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

object OkHttpClient {

    fun getClient() =  OkHttpClient.Builder().addInterceptor(object: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val response = chain.proceed(request)
            return response
        }
    }).build()
}