package com.example.android5_2.ui.onboarding


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.android5_2.AppViewModel
import com.example.android5_2.databinding.FragmentOnboardingBinding
import com.example.android5_2.ui.onboarding.viewpager.ViewPagerAdapter

class OnboardingFragment: Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels<AppViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initClickers()
    }

    private fun initClickers() {
        binding.btnSkip.setOnClickListener{
            viewModel.saveOnBoardingShown()
            val intent = requireActivity().intent
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }


    private fun initViewPager() {
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPager.adapter = adapter
    }
}