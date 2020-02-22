package com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel

import androidx.lifecycle.LiveData
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import io.reactivex.Observable

interface CountryModel {

   /* fun getAllCountries(): Observable<List<CountryVO>>
    fun getAllTours() : Observable<List<CountryVO>>
*/
  //  fun getTwoApi(onError:(message:String)->Unit): Observable<List<CountryVO>>


    fun getCommonApi(onError: (message: String) -> Unit) : Observable<DataVO>

    fun findTourById(name:String) : LiveData<CountryVO>


}