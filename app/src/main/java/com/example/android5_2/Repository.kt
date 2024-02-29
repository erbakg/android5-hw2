package com.example.android5_2

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.android5_2.data.SharedPreferencesManager
import com.example.android5_2.extension.PREFERENCES
import com.example.android5_2.remote.LoveApi
import com.example.android5_2.remote.LoveModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {
    fun getPercentage(firstName: String, secondName: String, viewModel: MutableLiveData<LoveModel>){
        api.getPercentage(firstName, secondName).enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("haha", "onResponse: $it")
                        viewModel.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.d("haha", "onFailure: " + t.message)
            }
        })
    }
    fun initSharedPrefs(context: Context){
        SharedPreferencesManager.init(context)
    }
    fun saveOnboardingShown(data: Boolean) {
        SharedPreferencesManager.saveString(PREFERENCES.ONBOARDING_SHOWN, data.toString())
    }

    fun getOnboardingShown(): Boolean {
       val result = SharedPreferencesManager.getString(PREFERENCES.ONBOARDING_SHOWN, "")
        return result == "true"
    }
}