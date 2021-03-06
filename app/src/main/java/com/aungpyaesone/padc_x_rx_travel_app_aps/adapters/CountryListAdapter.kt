package com.aungpyaesone.padc_x_travel_app_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.padc_x_rx_travel_app_aps.R
import com.aungpyaesone.padc_x_rx_travel_app_aps.adapters.BaseAdapter
import com.aungpyaesone.padc_x_rx_travel_app_aps.delegate.CountryItemDelegate
import com.aungpyaesone.padc_x_rx_travel_app_aps.view.viewholders.BaseViewHolder
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.view.viewholder.CountryViewHolder

class CountryListAdapter(delegate: CountryItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>, CountryVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item_view,parent,false)
        return CountryViewHolder(view,mDelegate)
    }
}