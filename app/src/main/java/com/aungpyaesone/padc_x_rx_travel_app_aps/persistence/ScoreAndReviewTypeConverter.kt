package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.ScoreandReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreAndReviewTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<ScoreandReviewVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<ScoreandReviewVO>{
        val countryListType = object : TypeToken<ArrayList<ScoreandReviewVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}