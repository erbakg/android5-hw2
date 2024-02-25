package com.example.android5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android5_2.remote.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()
    val liveData: MutableLiveData<LoveModel> = MutableLiveData()
    fun getPercentage(firstName: String, secondName: String) {
       repository.getPercentage(firstName, secondName, liveData)
    }
}