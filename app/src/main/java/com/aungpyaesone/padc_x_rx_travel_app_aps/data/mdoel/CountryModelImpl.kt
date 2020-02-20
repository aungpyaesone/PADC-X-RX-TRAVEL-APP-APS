package com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers


object CountryModelImpl: BaseModel(), CountryModel {


    override fun getTwoApi(onError:(message:String)->Unit): Observable<List<CountryVO>>{
        return Observable.zip(
            mNetworkApi.getAllCourntries().map { it.data.toList() }.subscribeOn(Schedulers.io()),
            mNetworkApi.getAllTours()
                .map { it.data.toList() }
                .subscribeOn(Schedulers.io()),
            mergeList()
        ).subscribeOn(Schedulers.io())
    }

    private fun mergeList():BiFunction<List<CountryVO>,List<CountryVO>,List<CountryVO>>{
        val dataList = ArrayList<CountryVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                dataList.add(it)
            }
            dataList
        }
    }

    @SuppressLint("CheckResult")
    override fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO> {


        val observableOne = mNetworkApi.getAllCourntries().map { it.data.toList() }.subscribeOn(Schedulers.io())
        val observableTwo = mNetworkApi.getAllTours().map { it.data.toList()}.subscribeOn(Schedulers.io())
        val zipData = Observable.zip(
            observableOne,
            observableTwo,
            createDataVOModel())

            observableOne.subscribeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    mTheDB.TourDao().insertAllData(it) },{
                    Log.e("error",it.localizedMessage)
                })
            observableTwo.subscribeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    mTheDB.TourDao().insertAllData(it)
                },{
                    Log.e("error",it.localizedMessage.toString())
                })
       /* zipData.subscribeOn(Schedulers.io())
            .filter { it.countryList.size==5 && it.popourTourList.size>=5 }

            .subscribe( {

               // mTheDB.TourDao().insertAllData(it.popourTourList)
            },{
                Log.e("error",it.localizedMessage)
            })*/
        return zipData
    }

    private fun createDataVOModel():BiFunction<List<CountryVO>,List<CountryVO>,DataVO> {
        val dataList = ArrayList<CountryVO>()
        val popularList = ArrayList<CountryVO>()
        return BiFunction { one, two->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                popularList.add(it)
            }
            DataVO(dataList,popularList)
        }
    }


    override fun findTourById(name: String): LiveData<CountryVO> {
       return mTheDB.TourDao().getTourById(name)
    }
    }
