package com.aungpyaesone.padc_x_rx_travel_app_aps.adapters

import androidx.recyclerview.widget.RecyclerView
import com.aungpyaesone.padc_x_rx_travel_app_aps.view.viewholders.BaseViewHolder

abstract class BaseAdapter<T:BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mDataList: MutableList<W> = mutableListOf()
    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun setData(data:List<W>){

        mDataList.clear()
        mDataList.addAll(data)
        notifyDataSetChanged()
    }
}