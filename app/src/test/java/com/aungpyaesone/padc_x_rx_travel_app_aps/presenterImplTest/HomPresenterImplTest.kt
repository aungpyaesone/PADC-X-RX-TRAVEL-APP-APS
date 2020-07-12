package com.aungpyaesone.padc_x_rx_travel_app_aps.presenterImplTest

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.CountryModelImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.data.mdoel.MockCountryModel
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.presenter.HomePresenterImpl
import com.aungpyaesone.padc_x_rx_travel_app_aps.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class HomPresenterImplTest {
    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView: HomeView

   private lateinit var countryModel: CountryModel



    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        CountryModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        countryModel= MockCountryModel
        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mCountryModel = this.countryModel

    }

    @Test
    fun onTouchCountry_Item(){
        mPresenter.onTouchCountryItem("Sea Flower Resort",2)

        verify {
            mView?.navigateToTourDetail("Sea Flower Resort",2)
        }
    }

    @Test
    fun getTourData_callEnableSwipeFresh(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReadyState(lifecycleOwner)
        verify {
            mView.disableSwipeRefresh()
        }
    }


}