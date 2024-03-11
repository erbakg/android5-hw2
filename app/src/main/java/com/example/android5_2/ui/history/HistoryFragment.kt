package com.example.android5_2.ui.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android5_2.App
import com.example.android5_2.databinding.FragmentHistoryBinding
import com.example.android5_2.remote.LoveModel
import com.example.android5_2.ui.history.bottom_sheet.BottomSheetListener
import com.example.android5_2.ui.history.bottom_sheet.HistoryBottomSheet
import com.example.android5_2.ui.history.recyclerview.LoveListAdapter

class HistoryFragment : Fragment(), BottomSheetListener {

    private var _binding: FragmentHistoryBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: LoveListAdapter
    private var callback: BottomSheetListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        callback = this;
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val list = App.appDatabase.loveDao().getAllByAlphabet()
        adapter = LoveListAdapter(list as ArrayList<LoveModel>, ::onItemClick)
        binding.historyRv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onItemClick(item: LoveModel) {
        val modal = callback?.let { HistoryBottomSheet(it) }
        val bundle = Bundle()
        bundle.putSerializable(HistoryBottomSheet.ITEM, item)
        modal?.arguments = bundle
        requireActivity().supportFragmentManager.let { modal?.show(it, HistoryBottomSheet.TAG) }
    }

    override fun onBottomSheetDismissed() {
        val list = App.appDatabase.loveDao().getAll()
        adapter.setNewData(list)
    }
}