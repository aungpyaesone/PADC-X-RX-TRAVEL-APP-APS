package com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.PhotoTypeConverter
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.ScoreAndReviewTypeConverter
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos.PopularTourDao
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos.TourDao
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO

@Database(entities = [CountryVO::class,PopularTourVO::class],version = 2,exportSchema = false)
@TypeConverters(ScoreAndReviewTypeConverter::class,PhotoTypeConverter::class)
abstract class TourDB : RoomDatabase() {
    companion object{
        val DB_NAME ="PADC_X_TOUR_DB"
        var dbInstance: TourDB? = null

        fun getInstance(context: Context): TourDB{
            when(dbInstance){
                null ->{
                    dbInstance = Room.databaseBuilder(context,TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun TourDao(): TourDao
    abstract fun PopularTourDao(): PopularTourDao
}