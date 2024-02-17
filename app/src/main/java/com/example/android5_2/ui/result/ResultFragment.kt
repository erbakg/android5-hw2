package com.example.android5_2.ui.result

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.android5_2.data.LoveModel
import com.example.android5_2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    companion object {
        val RESULT_KEY = "result_key"
    }

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
        val loveResponse = arguments?.getSerializable(RESULT_KEY, LoveModel::class.java)
        initViews(loveResponse)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun initViews(response: LoveModel?) {
        with(binding) {
            tvResultTitle.text = response?.result.toString()
            tvResultPoints.text = response?.percentage.toString()
        }
    }
}