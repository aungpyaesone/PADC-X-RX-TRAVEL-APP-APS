package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.DetailsView

interface DetailPresenter : BasePresenter<DetailsView> {

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

    fun onDetailUiReadyState(name:String,value:Int,lifecycleOwner: LifecycleOwner)
}