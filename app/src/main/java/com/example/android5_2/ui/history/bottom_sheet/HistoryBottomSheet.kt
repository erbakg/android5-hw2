package com.example.android5_2.ui.history.bottom_sheet

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android5_2.App
import com.example.android5_2.databinding.HistoryBottomSheetBinding
import com.example.android5_2.remote.LoveModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryBottomSheet(callback: BottomSheetListener) : BottomSheetDialogFragment() {
    private lateinit var binding: HistoryBottomSheetBinding
    private lateinit var loveModelItem: LoveModel
    private var bottomSheetListener: BottomSheetListener? = null

    init {
        this.bottomSheetListener = callback
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HistoryBottomSheetBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // used to show the bottom sheet dialog
        dialog?.setOnShowListener { it ->
            val d = it as BottomSheetDialog
            val bottomSheet =
                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModelItem = arguments?.getSerializable(ITEM, LoveModel::class.java)!!
        initViews(arguments?.getSerializable(ITEM, LoveModel::class.java)!!)
        setClickers()
    }

    private fun setClickers() {
        binding.applyBtn.setOnClickListener {
            App.appDatabase.loveDao().update(
                LoveModel(
                    binding.etFname.text.toString(),
                    binding.etSname.text.toString(),
                    binding.etPercentage.text.toString(),
                    binding.etResult.text.toString(),
                    loveModelItem.id
                )
            )
            bottomSheetListener?.onBottomSheetDismissed()
            dialog?.hide()
        }
    }

    private fun initViews(item: LoveModel) {
        binding.etFname.setText(item.fname)
        binding.etSname.setText(item.sname)
        binding.etPercentage.setText(item.percentage)
        binding.etResult.setText(item.result)
    }

    companion object {
        const val TAG = "history_bottom_sheet"
        const val ITEM = "bottom_sheet_item"
    }
}