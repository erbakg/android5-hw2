package com.example.android5_2

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
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
                       App.appDatabase.loveDao().insert(it)
                        viewModel.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.d("haha", "onFailure: " + t.message)
            }
        })
    }
}