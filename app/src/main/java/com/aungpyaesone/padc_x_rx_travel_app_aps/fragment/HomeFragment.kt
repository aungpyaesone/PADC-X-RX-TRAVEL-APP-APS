package com.aungpyaesone.padc_x_rx_travel_app_aps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.padc_x_rx_travel_app_aps.R
import com.aungpyaesone.padc_x_rx_travel_app_aps.adapters.MainAdapter
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.vos.DataVO
import com.aungpyaesone.padc_x_rx_travel_app_aps.delegate.CountryItemDelegate
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter.HomePresenter
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter.HomePresenterImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.HomeView
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO
import com.aungpyaesone.padc_x_travel_app_aps.utils.EN_CONNECTION_ERROR
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), HomeView{


    private var param1: String? = null
    private var param2: String? = null
   // private val mCountryModel: CountryModel = CountryModelImpl
    private val compositeDisposable = CompositeDisposable()
    private lateinit var mPresenter: HomePresenter

    lateinit var mMainAdapter: MainAdapter
    val mdataVOList: ArrayList<DataVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpSwipeRefresh()
        setUpRecyclerView()
        mPresenter.onUiReadyState(this)
        //  setUpViewPod()
        //  hideEmptyView()

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView() {
        mMainAdapter = MainAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mainRecyler.layoutManager = linearLayoutManager
        mainRecyler.adapter = mMainAdapter
    }

  /*  private fun requestData() {
        swipeRefreshLayout.isRefreshing = true

        mCountryModel.getCommonApi(onError = {
            showSnackbar(it)
            swipeRefreshLayout.isRefreshing = false
        }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                swipeRefreshLayout.isRefreshing = false
                if (it.countryList.isNotEmpty() && it.popourTourList.isNotEmpty()) {
                    mdataVOList.clear()
                    mdataVOList.add(it)
                    mMainAdapter.setData(mdataVOList.toMutableList())
                } else {
                    showSnackbar(EN_CONNECTION_ERROR)
                }

            },
                {
                    showSnackbar(it.localizedMessage)
                })
            .addTo(compositeDisposable)

    }*/

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayTourList(tourList: DataVO) {
        mdataVOList.clear()
        mdataVOList.add(tourList)
        mMainAdapter.setData(mdataVOList)
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showEmptyView() {

    }

    override fun hideEmptyView() {

    }

    override fun navigateToTourDetail(name: String,value:Int) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, DetailFragment.newInstance(name,value))?.addToBackStack(null)
            ?.commit()
    }

    override fun showErrorMessage(message: String) {
        showSnackbar(message)
    }

    private fun setUpSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener{
            mPresenter.onSwipeRefresh(this)
        }
    }
}
