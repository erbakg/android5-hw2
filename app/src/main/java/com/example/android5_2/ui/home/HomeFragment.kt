package com.example.android5_2.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android5_2.R
import com.example.android5_2.data.LoveModel
import com.example.android5_2.data.RetrofitService
import com.example.android5_2.databinding.FragmentHomeBinding
import com.example.android5_2.ui.result.ResultFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnHome.setOnClickListener {
                RetrofitService().api.getPercentage(
                    etFname.text.toString(),
                    etSname.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            val loveData: LoveModel? =
                                response.body()// create or retrieve your LoveModel instance
                            val bundle = Bundle().apply {
                                putSerializable(ResultFragment.RESULT_KEY, loveData)
                            }
                            findNavController().navigate(
                                R.id.action_navigation_home_to_resultFragment,
                                bundle
                            )
                            etSname.setText("")
                            etFname.setText("")
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG)
                        }
                    })
            }
            etFname.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val imm =
                        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view?.windowToken, 0)
                    true
                } else false
            })
            etSname.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val imm =
                        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view?.windowToken, 0)
                    true
                } else false
            })
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}