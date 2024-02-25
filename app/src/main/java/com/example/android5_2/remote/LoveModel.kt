package com.example.android5_2.remote

import java.io.Serializable


data class LoveModel(
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String
) : Serializable
