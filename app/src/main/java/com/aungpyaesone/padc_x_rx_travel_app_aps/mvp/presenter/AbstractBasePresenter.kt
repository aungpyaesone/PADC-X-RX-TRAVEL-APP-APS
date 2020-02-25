package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import androidx.lifecycle.ViewModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.BaseView

abstract class AbstractBasePresenter<T:BaseView> : BasePresenter<T>, ViewModel() {

    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }

}