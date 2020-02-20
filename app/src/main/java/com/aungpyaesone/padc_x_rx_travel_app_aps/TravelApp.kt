package com.aungpyaesone.padc_x_rx_travel_app_aps

import android.app.Application
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl

class TravelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CountryModelImpl.initDatabase(applicationContext)
    }
}