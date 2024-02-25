package com.example.android5_2.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    //https://love-calculator.p.rapidapi.com/getPercentage?fname=John&sname=Alice
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "d178c766d1msh6d5f68a005b85eep161effjsn8172190c0748",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}