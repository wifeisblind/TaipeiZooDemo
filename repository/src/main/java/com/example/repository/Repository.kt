package com.example.repository

interface Repository {

    fun fetchData(param: RequestParam, callback: Response)
}