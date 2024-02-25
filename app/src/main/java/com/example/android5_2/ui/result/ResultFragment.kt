package com.example.android5_2.ui.result

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android5_2.LoveViewModel
import com.example.android5_2.remote.LoveModel
import com.example.android5_2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private val viewModel: LoveViewModel by activityViewModels<LoveViewModel>()
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        viewModel.liveData.observe(viewLifecycleOwner){
            binding.tvResultTitle.text =  it.result
            binding.tvResultPoints.text = it.percentage
        }
    }

    private fun initClickers() {
        with(binding) {
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}