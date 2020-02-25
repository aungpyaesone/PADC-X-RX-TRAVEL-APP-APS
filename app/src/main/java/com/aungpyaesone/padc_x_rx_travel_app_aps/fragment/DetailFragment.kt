package com.aungpyaesone.padc_x_rx_travel_app_aps.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.padc_x_rx_travel_app_aps.R
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter.DetailPresenter
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter.DetailPresenterImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.DetailsView
import com.aungpyaesone.padc_x_travel_app_aps.adapter.PhotoAdapter
import com.aungpyaesone.padc_x_travel_app_aps.adapter.ScoreandReviewAdapter
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.fragment_detail.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailFragment : BaseFragment(),DetailsView {
    private var tourName: String = " "
    private var mValue: Int = 0
    private lateinit var mScoreandReviewAdapter: ScoreandReviewAdapter
    private lateinit var mPhotoAdapter: PhotoAdapter
    private lateinit var mDetailPresenter: DetailPresenter
    //val mCountryModel: CountryModel = CountryModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tourName = it.getString(ARG_PARAM1).toString()
            mValue = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPresneter()
        setUpRecycler()
        settingData()
        mDetailPresenter.onDetailUiReadyState(tourName,mValue,this)
    }

    private fun initPresneter(){
        mDetailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mScoreandReviewAdapter = ScoreandReviewAdapter()
        mPhotoAdapter = PhotoAdapter()

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerTwo = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        scoreRecyclerView.layoutManager = layoutManager
        imgRecyclerView.layoutManager = layoutManagerTwo
        scoreRecyclerView.adapter = mScoreandReviewAdapter
        imgRecyclerView.adapter = mPhotoAdapter
    }

    private fun settingData() {
        imgBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(name: String,value:Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                    putInt(ARG_PARAM2,value)
                }
            }
    }

    override fun displayTourData(tourdata: PopularTourVO) {
        activity?.let {
            Glide.with(it)
                .load(tourdata.photos[1])
                .centerCrop()
                .into(imgProfile)
        }
        title.text = tourdata.name
        tvLocation.text = tourdata.location
        tvRating.text = tourdata.average_rating.toString()
        ratingBar.rating = tourdata.average_rating.toFloat()
        mScoreandReviewAdapter.setData(tourdata.scores_and_reviews)
        mPhotoAdapter.setData(tourdata.photos)
        tvDescription.text = tourdata.description
    }

    override fun displayCountryData(countrydata: CountryVO) {
        activity?.let {
            Glide.with(it)
                .load(countrydata.photos[1])
                .centerCrop()
                .into(imgProfile)
        }
        title.text = countrydata.name
        tvLocation.text = countrydata.location
        tvRating.text = countrydata.average_rating.toString()
        ratingBar.rating = countrydata.average_rating.toFloat()
        mScoreandReviewAdapter.setData(countrydata.scores_and_reviews)
        mPhotoAdapter.setData(countrydata.photos)
        tvDescription.text = countrydata.description
    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }
}
