package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO

@Dao
interface PopularTourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(infos:List<PopularTourVO>)

    @Query("select * from popular_tour where name= :name")
    fun getTourById(name: String) : LiveData<PopularTourVO>

    @Query("select * from popular_tour")
    fun getAllCountryList():LiveData<List<PopularTourVO>>

}