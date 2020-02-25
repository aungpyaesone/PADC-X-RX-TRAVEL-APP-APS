package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.DetailsView
import com.aungpyaesone.padc_x_travel_app_aps.utils.VALUE_ONE
import com.aungpyaesone.padc_x_travel_app_aps.utils.VALUE_TWO

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailsView>() {

    private val mCountryModel: CountryModel = CountryModelImpl
    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {

    }

    override fun onDetailUiReadyState(name: String,value:Int, lifecycleOwner: LifecycleOwner) {
        when(value){
            VALUE_ONE ->{
                mCountryModel.findTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayCountryData(it)
                })
            }
            VALUE_TWO ->{
                mCountryModel.findPopularTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayTourData(it)
                })
            }
        }

    }
}