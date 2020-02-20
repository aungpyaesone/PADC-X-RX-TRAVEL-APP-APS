package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CoutryListTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<CountryVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CountryVO>{
        val countryListType = object : TypeToken<ArrayList<CountryVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}