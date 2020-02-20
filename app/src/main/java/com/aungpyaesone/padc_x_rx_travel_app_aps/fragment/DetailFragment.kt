package com.aungpyaesone.padc_x_rx_travel_app_aps.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.padc_x_rx_travel_app_aps.R
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_travel_app_aps.adapter.PhotoAdapter
import com.aungpyaesone.padc_x_travel_app_aps.adapter.ScoreandReviewAdapter
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.fragment_detail.*

private const val ARG_PARAM1 = "param1"

class DetailFragment : BaseFragment() {

    private var tourName: String = " "
    private lateinit var mScoreandReviewAdapter: ScoreandReviewAdapter
    private lateinit var mPhotoAdapter: PhotoAdapter
    val mCountryModel: CountryModel = CountryModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tourName = it.getString(ARG_PARAM1).toString()
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

        setUpRecycler()
        requestData()
        settingData()

    }

    private fun requestData() {
        mCountryModel.findTourById(tourName).observe(this, Observer { countryVO ->
            activity?.let {
                Glide.with(it)
                    .load(countryVO.photos[1])
                    .centerCrop()
                    .into(imgProfile)
            }
            title.text = countryVO.name
            tvLocation.text = countryVO.location
            tvRating.text = countryVO.average_rating.toString()
            ratingBar.rating = countryVO.average_rating.toFloat()
            mScoreandReviewAdapter.setData(countryVO.scores_and_reviews)
            mPhotoAdapter.setData(countryVO.photos)
            tvDescription.text = countryVO.description
        })
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
        fun newInstance(name: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                }
            }
    }
}
