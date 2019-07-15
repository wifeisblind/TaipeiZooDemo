package com.example.repository

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    fun fetchData(): Observable<TaipeiZooResult>
}