package com.example.android5_2.extension

import android.content.Context
import com.example.android5_2.R

fun Context.convertNumberToText(number: Int): String {
    return when (number) {
        selected1 -> resources.getString(R.string.radio_selected_1)
        selected2 -> resources.getString(R.string.radio_selected_2)
        else -> throw Exception()
    }
}

const val selected1 = 1
const val selected2 = 2