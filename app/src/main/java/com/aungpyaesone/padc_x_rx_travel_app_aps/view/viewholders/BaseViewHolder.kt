package com.aungpyaesone.padc_x_rx_travel_app_aps.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData : T? = null

    abstract fun bindData(data:T)

    protected fun getCountryName(message:String):String{
        val result = message.trimEnd()
        return result.takeLastWhile {
            it.isLetter()
        }
    }
}