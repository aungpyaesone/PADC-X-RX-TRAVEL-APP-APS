package com.aungpyaesone.padc_x_rx_travel_app_aps.network

import com.aungpyaesone.padc_x_rx_travel_app_aps.network.response.GetAllCountryResponse
import com.aungpyaesone.padc_x_rx_travel_app_aps.network.response.GetAllTourResponse
import com.aungpyaesone.padc_x_travel_app_aps.utils.ACCESS_TOKEN
import com.aungpyaesone.padc_x_travel_app_aps.utils.GET_ALL_COUNTRY
import com.aungpyaesone.padc_x_travel_app_aps.utils.GET_ALL_TOUR
import io.reactivex.Observable
import retrofit2.http.*

interface NewtorkApi{
    @GET(GET_ALL_COUNTRY)
    fun getAllCourntries()
            : Observable<GetAllCountryResponse>

    @GET(GET_ALL_TOUR)
    fun getAllTours(): Observable<GetAllTourResponse>

}