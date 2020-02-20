package com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel

import android.content.Context
import com.aungpyaesone.padc_x_rx_travel_app_aps.network.NewtorkApi
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.database.TourDB
import com.aungpyaesone.padc_x_travel_app_aps.utils.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel  {

    protected var mNetworkApi:NewtorkApi
    protected lateinit var mTheDB:TourDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

       // val headerInterceptor =

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mNetworkApi = retrofit.create(NewtorkApi::class.java)
    }

    fun initDatabase(context: Context){
        mTheDB = TourDB.getInstance(context)
    }

}