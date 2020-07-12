package com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_rx_travel_app_aps.dummydatas.getDummyCountries
import com.aungpyaesone.padc_x_rx_travel_app_aps.dummydatas.getDummyPopularCountries
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO
import io.reactivex.Observable

object MockCountryModel : CountryModel {

    var allCountryLiveData = MutableLiveData<List<CountryVO>>()
    var allPopularTourLiveData = MutableLiveData<List<PopularTourVO>>()


    override fun getAllCountyFromDB(onError: (message: String) -> Unit): LiveData<List<CountryVO>> {
        //val liveData = MutableLiveData<List<CountryVO>>()
        allCountryLiveData.postValue(getDummyCountries())
        return allCountryLiveData
    }

    override fun getAllPopularFromDB(onError: (message: String) -> Unit): LiveData<List<PopularTourVO>> {
        allPopularTourLiveData.postValue(getDummyPopularCountries())
        return allPopularTourLiveData

    }

    override fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO> {
      // this function is not use
        TODO("not implemented")
    }

    override fun findTourById(name: String): LiveData<CountryVO> {
        val liveData = MutableLiveData<CountryVO>()
        liveData.postValue(getDummyCountries().first { it.name == name })
        return liveData
    }

    override fun findPopularTourById(name: String): LiveData<PopularTourVO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}