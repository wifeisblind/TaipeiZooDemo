package com.example.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observer

class ApiMethods {

    companion object {

        fun getTaipeiZooData(observer: Observer<List<TaipeiZooResult>>) {
            Api.getApiService()
                .fetchData()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
        }
    }
}