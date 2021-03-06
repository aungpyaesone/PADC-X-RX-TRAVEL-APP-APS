package com.aungpyaesone.padc_x_rx_travel_app_aps.view.viewholders

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_rx_travel_app_aps.delegate.CountryItemDelegate
import com.aungpyaesone.padc_x_rx_travel_app_aps.view.viepods.EmptyViewPod
import com.aungpyaesone.padc_x_travel_app_aps.adapter.CountryListAdapter
import com.aungpyaesone.padc_x_travel_app_aps.adapter.PopularTourListAdapter
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.utils.EN_CONNECTION_ERROR

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_item_view.*
import kotlinx.android.synthetic.main.main_item_view.view.*
import kotlinx.android.synthetic.main.vertical_item_view.view.*

class MainViewHolder(itemView: View,delegate: CountryItemDelegate) : BaseViewHolder<DataVO>(itemView) {

    val mDelegate = delegate
    private lateinit var  viewPortEmpty: EmptyViewPod
    private var viewPool = RecyclerView.RecycledViewPool()
    private val countryList = mutableListOf<CountryVO>()

    private lateinit var mCountryListAdapter:CountryListAdapter
    private lateinit var mPopularTourListAdapter: PopularTourListAdapter
    override fun bindData(data: DataVO) {
      //  setUpViewPod()
       // hideEmptyView()
        mData = data
        setUpRecycler()
        if(data.countryList.isNotEmpty())
        {
            mCountryListAdapter.setData(data.countryList.toMutableList())
            mPopularTourListAdapter.setData(data.popourTourList.toMutableList())
        }

    }

    private fun setUpRecycler(){
        mCountryListAdapter = CountryListAdapter(mDelegate)
        mPopularTourListAdapter = PopularTourListAdapter(mDelegate)
        val mManagerOne = LinearLayoutManager(itemView.horizontalRecycler.context,LinearLayoutManager.HORIZONTAL,false)
        val mManagerTwo = LinearLayoutManager(itemView.verticalRecyclerView.context,LinearLayoutManager.VERTICAL,false)

        itemView.horizontalRecycler.layoutManager = mManagerOne
        itemView.verticalRecyclerView.layoutManager = mManagerTwo

        itemView.horizontalRecycler.adapter = mCountryListAdapter
        itemView.verticalRecyclerView.adapter = mPopularTourListAdapter
      /*  itemView.horizontalRecycler.setRecycledViewPool(viewPool)
        itemView.verticalRecyclerView.setRecycledViewPool(viewPool)*/

    }

    private fun setUpViewPod(){
     //   viewPortEmpty = itemView.vpEmpty as EmptyViewPod
     //   viewPortEmpty = itemView.vpEmptyTwo as EmptyViewPod
      //  viewPortEmpty.setEmptyData(EN_CONNECTION_ERROR,"https://i.pinimg.com/originals/ae/8a/c2/ae8ac2fa217d23aadcc913989fcc34a2.png")

    }

    private fun showEmptyView(){
      //  itemView.vpEmpty.visibility = View.VISIBLE
     //   itemView.vpEmptyTwo.visibility = View.VISIBLE
        itemView.verticalRecyclerView.visibility = View.GONE
        itemView.horizontalRecycler.visibility = View.GONE


    }

    private fun hideEmptyView(){
       // itemView.vpEmpty.visibility = View.GONE
      //  itemView.vpEmptyTwo.visibility = View.GONE
        itemView.horizontalRecycler.visibility = View.VISIBLE
        itemView.verticalRecyclerView.visibility = View.VISIBLE
    }

}