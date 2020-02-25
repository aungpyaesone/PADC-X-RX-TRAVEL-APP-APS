package com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel

import androidx.lifecycle.LiveData
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO
import io.reactivex.Observable

interface CountryModel {

    fun getAllCountyFromDB(onError: (message: String) -> Unit):LiveData<List<CountryVO>>

    fun getAllPopularFromDB(onError: (message: String) -> Unit):LiveData<List<PopularTourVO>>

    fun getCommonApi(onError: (message: String) -> Unit) : Observable<DataVO>

    fun findTourById(name:String) : LiveData<CountryVO>

    fun findPopularTourById(name:String):LiveData<PopularTourVO>



}