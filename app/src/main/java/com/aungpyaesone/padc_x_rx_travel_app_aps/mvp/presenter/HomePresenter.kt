package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.padc_x_rx_travel_app_aps.delegate.CountryItemDelegate
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.HomeView

interface HomePresenter: BasePresenter<HomeView>, CountryItemDelegate {

    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)

    fun onUiReadyState(lifecycleOwner: LifecycleOwner)
}