package com.example.android5_2.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    var fname: String,
    @SerializedName("sname")
    var sname: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
) : Serializable
