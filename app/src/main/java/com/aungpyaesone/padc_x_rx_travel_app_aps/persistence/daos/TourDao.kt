package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO

@Dao
interface TourDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(infos:List<CountryVO>)

    @Query("select * from country where name= :name")
    fun getTourById(name: String) : LiveData<CountryVO>

    @Query("select * from country")
    fun getAllCountryList():LiveData<List<CountryVO>>



}