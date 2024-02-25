package com.example.android5_2

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.android5_2.remote.LoveModel
import com.example.android5_2.remote.RetrofitService
import retrofit2.Call
import retrofit2.Response

class Repository {
    val api = RetrofitService().api
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
}