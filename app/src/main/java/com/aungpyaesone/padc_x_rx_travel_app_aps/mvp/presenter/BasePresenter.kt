package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.BaseView

interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}