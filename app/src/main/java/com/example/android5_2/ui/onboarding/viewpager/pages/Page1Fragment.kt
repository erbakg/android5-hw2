package com.example.android5_2.ui.onboarding.viewpager.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android5_2.R
import com.example.android5_2.databinding.FragmentViewPager1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Page1Fragment : Fragment() {
    private var binding: FragmentViewPager1Binding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.fragment_view_pager_1, container, false)

        if (binding == null) {
            binding = FragmentViewPager1Binding.bind(root)
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}