package com.aungpyaesone.padc_x_travel_app_aps.view.viewholder

import android.util.Log
import android.view.View
import com.aungpyaesone.padc_x_rx_travel_app_aps.delegate.CountryItemDelegate
import com.aungpyaesone.padc_x_rx_travel_app_aps.view.viewholders.BaseViewHolder
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO
import com.aungpyaesone.padc_x_travel_app_aps.utils.VALUE_TWO
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.vertical_item_view.view.*

class PopularTourViewHolder(itemView: View,delegate: CountryItemDelegate) : BaseViewHolder<PopularTourVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTouchCountryItem(it.name, VALUE_TWO)
            }

        }
    }

    override fun bindData(data: PopularTourVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photos[1])
            .centerCrop()
            .into(itemView.ImgOne)

        val title:String = getCountryName(data.location)
        itemView.title.text = title
        itemView.tvRate.text = data.average_rating.toString()
        Log.d("title",title)

    }
}