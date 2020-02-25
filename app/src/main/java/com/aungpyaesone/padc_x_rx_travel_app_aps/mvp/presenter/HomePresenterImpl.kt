package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.HomeView
import com.aungpyaesone.padc_x_travel_app_aps.utils.EN_CONNECTION_ERROR
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomePresenterImpl: HomePresenter, AbstractBasePresenter<HomeView>() {

    private val mCountryModel:CountryModel = CountryModelImpl
    private lateinit var dataVO: DataVO
    private val compositeDisposable = CompositeDisposable()

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getCountryData(lifecycleOwner)
    }

    override fun onUiReadyState(lifecycleOwner: LifecycleOwner) {
        getCountryData(lifecycleOwner)
    }

    override fun onTouchCountryItem(name: String,value: Int) {
        mView?.navigateToTourDetail(name,value)
    }

    private fun getCountryData(lifecycleOwner: LifecycleOwner){
        dataVO = DataVO(arrayListOf(), arrayListOf())
        /*mCountryModel.getCommonApi(onError = {
            mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.disableSwipeRefresh()
                if (it.countryList.isNotEmpty() && it.popourTourList.isNotEmpty()) {
                    mView?.showEmptyView()
                  //  dataVO.countryList = it.countryList
                  //  dataVO.popourTourList = it.popourTourList
                    mView?.displayTourList(it)
                }
                else {
                mView?.showErrorMessage(EN_CONNECTION_ERROR)
                }
            },
                {
                mView?.showErrorMessage(it.localizedMessage)
                })
            .addTo(compositeDisposable)*/

        mCountryModel.getAllCountyFromDB(onError = {
            mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        })
            .observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if(it.isEmpty())
            {
            mView?.showEmptyView()
            }else{
            mView?.hideEmptyView()
                dataVO.countryList = it
                mView?.displayTourList(dataVO)
            }
        })

        mCountryModel.getAllPopularFromDB(onError = {
           mView?.disableSwipeRefresh()
            mView?.showEmptyView()
            mView?.showErrorMessage(it)
        })
            .observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if(it.isEmpty())
            {
                mView?.showEmptyView()
            }else
            {
                mView?.hideEmptyView()
                dataVO.popourTourList = it
                mView?.displayTourList(dataVO)
            }
        }
        )

    }
}