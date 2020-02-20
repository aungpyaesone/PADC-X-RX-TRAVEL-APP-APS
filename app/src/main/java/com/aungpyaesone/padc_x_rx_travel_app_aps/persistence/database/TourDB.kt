package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos.TourDao
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO

@Database(entities = [CountryVO::class],version = 1,exportSchema = false)
abstract class TourDB : RoomDatabase() {
    companion object{
        val DB_NAME ="PADC_X_TOUR_DB"
        var dbInstance: TourDB? = null

        fun getInstance(context: Context): TourDB{
            when(dbInstance){
                null ->{
                    dbInstance = Room.databaseBuilder(context,TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun TourDao(): TourDao
}