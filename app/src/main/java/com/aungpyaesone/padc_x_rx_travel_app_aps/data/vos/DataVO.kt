package com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos


import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO

data class DataVO(

    var countryList: List<CountryVO>,
    var popourTourList: List<PopularTourVO>)
