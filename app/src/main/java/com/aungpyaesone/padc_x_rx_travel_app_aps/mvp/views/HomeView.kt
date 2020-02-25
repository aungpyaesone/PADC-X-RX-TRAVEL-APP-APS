package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views

import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO

interface HomeView: BaseView {

    fun displayTourList(tourList:DataVO)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()

    fun showEmptyView()
    fun hideEmptyView()

    fun navigateToTourDetail(name:String,value:Int)
}