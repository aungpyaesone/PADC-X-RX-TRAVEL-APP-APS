package com.aungpyaesone.padc_x_rx_travel_app_aps.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.daos.TourDao
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.database.TourDB
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest  {

    private lateinit var mTourDao : TourDao
    private lateinit var db : TourDB

    @Before
    fun setUpDB(){

        val context= ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TourDB::class.java).build()
        mTourDao=db.TourDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun databaseTest(){
        val tourOne = CountryVO()
        tourOne.name="Singapore"
        tourOne.location="AAAAAAAAAAAA"
      //  tourOne.averageRating="4.5"


        mTourDao.insertCountry(tourOne)
        assert(mTourDao.getTourById(tourOne.name).value?.name == tourOne.name)
    }
}