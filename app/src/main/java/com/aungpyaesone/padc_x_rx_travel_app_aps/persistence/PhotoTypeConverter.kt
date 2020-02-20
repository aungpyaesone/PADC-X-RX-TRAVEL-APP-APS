package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoTypeConverter {

    @TypeConverter
    fun toString(dataList:ArrayList<String>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<String>{
        val countryListType = object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}