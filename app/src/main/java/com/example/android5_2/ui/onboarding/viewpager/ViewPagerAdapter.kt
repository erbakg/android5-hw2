package com.example.android5_2.ui.onboarding.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android5_2.ui.onboarding.viewpager.pages.Page1Fragment
import com.example.android5_2.ui.onboarding.viewpager.pages.Page2Fragment
import com.example.android5_2.ui.onboarding.viewpager.pages.Page3Fragment
import com.example.android5_2.ui.onboarding.viewpager.pages.Page4Fragment

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 4;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Page1Fragment()
            }
            1 -> {
                return Page2Fragment()
            }
            2 -> {
                return Page3Fragment()
            }
            3 -> {
                return Page4Fragment()
            }
            else -> {
                return Page1Fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
    }

}