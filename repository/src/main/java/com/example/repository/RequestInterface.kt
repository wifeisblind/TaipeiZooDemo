package com.example.repository

import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {

    @GET("")
    fun fetchData(@Body requestParam: RequestParam): Observable<TaipeiZooResult>
}