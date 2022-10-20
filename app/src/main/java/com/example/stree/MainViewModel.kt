package com.example.stree

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var dataList: MutableLiveData<List<Products>?> = MutableLiveData()
    private val service = RetrofitBuilder.buildService(DataService::class.java)


    fun getDataList(): MutableLiveData<List<Products>?> {
        return dataList
    }

    init {
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch(Dispatchers.IO) {
            val result = service.getData()
            if (result.isSuccessful) {
                dataList.postValue(result.body()?.products?.toList())
                Log.i("message", "Success in main list")
            } else {
                dataList.postValue(null)
                Log.i("message", "failure in main list")
            }
        }
    }
}