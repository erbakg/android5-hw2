package com.example.android5_2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android5_2.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}