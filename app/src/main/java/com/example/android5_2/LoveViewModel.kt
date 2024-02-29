package com.example.android5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android5_2.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val liveData: MutableLiveData<LoveModel> = MutableLiveData()
    fun getPercentage(firstName: String, secondName: String) {
       repository.getPercentage(firstName, secondName, liveData)
    }
}