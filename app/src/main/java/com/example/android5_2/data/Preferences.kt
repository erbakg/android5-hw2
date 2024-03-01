package com.example.android5_2.data

import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor(private val pref: SharedPreferences) {
    fun isOnboardingShown(): Boolean = pref.getBoolean(ONBOARDING_SHOWN, false)
    fun setOnboardingShown() = pref.edit().putBoolean(ONBOARDING_SHOWN, true).apply()
    companion object {
        const val PREF_NAME = "MySharedPrefs"
        const val ONBOARDING_SHOWN = "ONBOARDING_SHOWN"
    }


}