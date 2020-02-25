package com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views

import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO

interface DetailsView : BaseView {

    fun displayTourData(tourdata:PopularTourVO)

    fun displayCountryData(countrydata:CountryVO)
}