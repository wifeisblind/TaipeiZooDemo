package com.example.taipeizoodemo

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repository.Api
import com.example.repository.ApiMethods
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _data = MutableLiveData<List<MainItem>>()

    val data: LiveData<List<MainItem>> = _data

    fun get() {
        compositeDisposable.add(ApiMethods.getTaipeiZooData().doOnSubscribe {
            Log.d("MainViewModel", "onSubscribe")

        }.subscribe({
            _data.value = it.result.results.map { result -> MainItem(result.E_Pic_URL, result.E_Name, result.E_Info, result.E_Memo) }
        },{

        },{
            Log.d("MainViewModel", "onComplete")
        }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}