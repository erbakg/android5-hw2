package com.example.android5_2.ui.history.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android5_2.databinding.HistoryRvItemBinding
import com.example.android5_2.remote.LoveModel

class LoveListAdapter(private var datalist:ArrayList<LoveModel>, val onClickButtonAction: (item : LoveModel) -> Unit): RecyclerView.Adapter<LoveListAdapter.ViewHolder>() {


    class ViewHolder(val binding: HistoryRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LoveModel) {
            binding.tvFname.text = item.fname
            binding.tvSname.text = item.sname
            binding.tvPercentage.text = item.percentage
            binding.tvResult.text = item.result

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HistoryRvItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            onClickButtonAction(datalist[position])
        }
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    fun setData(data: List<LoveModel>) {
        datalist.clear()
        datalist.addAll(data)
    }

    // add new data
    fun setNewData(newData: List<LoveModel>) {
        val diffCallback = DiffUtilCallback(datalist, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        datalist.clear()
        datalist.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

}