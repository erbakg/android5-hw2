package com.example.android5_2

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val liveData: MutableLiveData<Boolean> = MutableLiveData()

    fun initSharedPrefs(context: Context){
        repository.initSharedPrefs(context)
    }
    fun getOnBoardingShown() {
      liveData.postValue(repository.getOnboardingShown())
    }
    fun saveOnBoardingShown(){
        repository.saveOnboardingShown(true)
    }
}